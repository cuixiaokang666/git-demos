package com.baisi.staff.controller;
import com.baisi.staff.entity.User;
import com.baisi.staff.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by houyuanbo
 * on 2019/12/9 14:34
 *
 * @Description ：
 */

@CrossOrigin
@RestController
public class UserController {

    @Autowired
    UserService userService;

    /**
     * 通过员工id删除员工
     *
     * @param userId
     * @return
     */
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public Integer delete(Integer userId) {
        System.out.println(userId);
        int result = userService.delete(userId);
        return result;
    }

    /**
     * 更新员工
     *
     * @param user
     * @return
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public String update(User user) {
        int result = userService.Update(user);
        if (result >= 1) {
            return "修改成功";
        } else {
            return "修改失败";
        }
    }

    /**
     * 插入员工
     *
     * @param user
     * @return
     */
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public User insert(User user) {
        return userService.insertUser(user);
    }

    /**
     * 查询所有
     *
     * @return
     */
    @RequestMapping(value = "/ListUser")
    @ResponseBody
    public List<User> ListUser() {
        return userService.ListUser();
    }

    /**
     * 通过名字查询  模糊查询
     *
     * @param userName
     * @return
     */
    @RequestMapping(value = "/ListByName")
    @ResponseBody
    public List<User> ListUserByName(String userName) {
        return userService.findByName(userName);
    }

    /**
     * 查询页数
     * @param page
     * @return
     */
    @RequestMapping(value ="/page")
    @ResponseBody
    public List<User> page(Integer page) {
        int pageNow = page == null ? 1 : page;//传入的页数是null  就查询第一页   否则就根据传入的页数进行查询
        int pageSize=5;
        int startRows = pageSize * (pageNow - 1);//开始的行数
        List<User> list = userService.queryPage(startRows);
        return list;
    }

    @RequestMapping(value ="rows")
    @ResponseBody
    public int rows(){
        return userService.getRowCount();
    }

}