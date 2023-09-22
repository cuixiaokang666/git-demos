package com.sing.respchain;

public class ClientTest {
    public static void main(String[] args) {
        //创建采购请求
        PurchaseRequest purchaseRequest = new PurchaseRequest(1,1000,1);

        //创建审批人
        Approver depar = new DepartmentApprover("郭主任");
        Approver dean = new Dean("方院长");
        Approver vice = new VicePrincipal("赵副校长");
        Approver prin = new Principal("崔校长");
        //设置下一个审批人
        depar.setApprover(dean);
        dean.setApprover(vice);
        vice.setApprover(prin);
        //这里要形成一个环链,避免如果3000金额以下的请求
        //直接交给校长处理,会出现空指针
        //当然,如果程序规定只能从主任开始处理
        //一层一层最后到校长处理,形成一个单链,这里就不用设置了
        prin.setApprover(depar);
        //测试
        depar.approve(purchaseRequest);
    }
}
