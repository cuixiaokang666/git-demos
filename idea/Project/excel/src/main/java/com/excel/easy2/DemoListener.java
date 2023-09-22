package com.excel.easy2;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.exception.ExcelAnalysisException;
import com.alibaba.excel.util.StringUtils;
import lombok.Data;
import java.lang.reflect.Field;
import java.util.*;

@Data
public class DemoListener<T, D> extends AnalysisEventListener<T> {
    //储存读取到的数据
    private List<T> list = new ArrayList<>();

    private List<T> lists = new ArrayList<>();
    //错误数据结果集
    private List<ExcelCheckErrDto<T>> errDtos = new ArrayList<>();
    //过滤链
    private CheckChainFactory<T> errList = new CheckChainFactory();
    //对象反射类
    private Class<T> clazz;
    //实例化
    public DemoListener(Class<T> clazz, DemoServiceImpl demoService){
        this.clazz = clazz;
    }

    public DemoListener(Class<DemoData> demoDataClass) {
    }

    /**
     * 获取与excel表头对应的实体类属性
     * @param clazz
     * @return
     */
    public Map<Integer,String> getIndexNameMap(Class clazz) throws NoSuchFieldException {
        //创建一个map储存表头与实体类对应的属性
        Map<Integer,String> map = new HashMap<Integer, String>();
        Field field;
        //通过反射获取实体类的所有属性
        Field[] fields = clazz.getDeclaredFields();
        for(int i=0;i<fields.length;i++){
            //拿到属性名字
            field = clazz.getDeclaredField(fields[i].getName());
            //允许暴力反射
            field.setAccessible(true);
            //拿到属性对应的注解
            ExcelProperty excelProperty = field.getAnnotation(ExcelProperty.class);
            //如果注解不为空,拿到注解中的index属性,value值
            if(excelProperty != null){
                int index = excelProperty.index();
                String[] values = excelProperty.value();
                //创建StringBuilder 存入value值
                StringBuilder value = new StringBuilder();
                for(String v : values){
                    value.append(v);
                }
             //通过键值对的方式(index为键,value为值)
                map.put(index,value.toString());
            }
        }
        //这样就拿到实体类中的对应的表格中应该有的属性
        return map;
    }

    /**
     * 一行一行读取
     * @param t
     * @param analysisContext
     */
    @Override
    public void invoke(T t, AnalysisContext analysisContext) {
       String er;
       try{
           er = EasyExcelValidatorHelper.valid(t);
       }catch (Exception e){
           er = "解析数据出错";
           e.printStackTrace();
       }
       //如果错误数据不为空,证明当前这一条数据为错误数据
        if(!StringUtils.isEmpty(er)){
            //自定义一个校验出来的错误数据的类\
            //给监听器添加属性 er 用来装载错误数据
            ExcelCheckErrDto<T> excelCheckErrDto = new ExcelCheckErrDto<T>(t,er);
            errList.add(excelCheckErrDto);
        }else{
            list.add(t);
        }
        //每1000条处理一次
        if(list.size()>1000){
            //将数据存入数据库,并清空list
            errList.getCheck().forEach(chain->{
                List<ExcelCheckErrDto<T>> excelCheckErrDtos = chain.check(list);
                excelCheckErrDtos.forEach(errDtos::add);
            });
            list.forEach(lists::add);
            list.clear();
        }
    }

    /**
     * 读取表头内容
     * @param headMap
     * @param context
     */
    @Override
    public void invokeHeadMap(Map<Integer, String> headMap, AnalysisContext context) {
       //传入的泛型不能为null,excel导入要有对应的实体
        if(clazz != null){
            try{
                //拿到实体类对应的excel表头
                Map<Integer,String> in = getIndexNameMap(clazz);
                //循环in与参数headMap作对比
                //in实体类中对应的表头
                //headMap实际读取到的表头
                Set<Integer> keySet = in.keySet();
                for(Integer key : keySet){
                    //读取到空的表头,抛出解析异常
                    if(StringUtils.isEmpty(headMap.get(key))){
                        throw new ExcelAnalysisException("解析excel出错,请传入正确格式的excel");
                    }
                    //读取到的跟实体类中的不对应,抛出解析异常
                    if(!headMap.get(key).equals(in.get(key))){
                        throw new ExcelAnalysisException("解析excel出错,请传人正确格式的excel");
                    }
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    /**
     * 确保最后遗留的数据也被储存数据库
     * @param analysisContext
     */
    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        //将数据储存到数据库,并清除list
        //获取过滤链过滤 list数据
        errList.getCheck().forEach(chain->{
            List<ExcelCheckErrDto<T>> excelCheckErrDtos = chain.check(list);
            excelCheckErrDtos.forEach(errDtos::add);
        });
        list.forEach(lists::add);
        //list中剩下的数据都是校验成功的数据,应将持久化到数据库
        list.clear();
    }
}
