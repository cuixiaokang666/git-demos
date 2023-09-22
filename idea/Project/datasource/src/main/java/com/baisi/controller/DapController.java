package com.baisi.controller;
import com.baisi.entity.Dap;
import com.baisi.entity.Users;
import com.baisi.service.DapService;
import com.baisi.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class DapController {

    @Autowired
    private DapService dapService;
    @Autowired
    private UsersService userService;

    @GetMapping("/dap/selectAll")
    public String getDapService(){
        List<Dap> dap = dapService.selectAll();
        for (Dap dap1 : dap) {
            System.out.println(dap1.getName());
            System.out.println(dap1);
        }
        return "hello,dap";
    }

    @GetMapping("/users/selectAll")
    public String getUserService(){
        List<Users> user = userService.selectAll();
        for (Users users : user) {
            System.out.println(users.getNames());
            System.out.println(users);
        }
        return "hello,users";
    }
}
