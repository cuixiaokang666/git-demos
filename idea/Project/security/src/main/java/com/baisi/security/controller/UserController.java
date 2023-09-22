package com.baisi.security.controller;
import com.baisi.security.entity.Role;
import com.baisi.security.entity.User;
import com.baisi.security.mapper.RoleMapper;
import com.baisi.security.mapper.UserMapper;
import com.baisi.security.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/show")
public class UserController {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RoleService roleService;

    @RequestMapping("/user")
    public List<User> getAll(){
        List<User> list = userMapper.getAll();
        return list;
    }

    @RequestMapping("/selId")
    public User selId(Integer id){
        return userMapper.getById(id);
    }

    @RequestMapping("/add")
    public Integer add(User user){
       Integer res = userMapper.add(user);
       return res;
    }

    @RequestMapping("/update")
    public Integer update(User user){
        Integer res = userMapper.update(user);
        return res;
    }

    @RequestMapping("/remove")
    public Integer remove(Integer id){
        return userMapper.remove(id);
    }

//    @RequestMapping("/role")
//    public String role(@PathVariable Integer id, ModelMap map){
//        List<Role> roles = roleService.getAll();
//        List<Integer> roleIds = userMapper.getByIds(id);
//        map.put("id",id);
//        map.put("roles",roles);
//        map.put("rolesIds",roleIds);
//        return "";
//    }
}
