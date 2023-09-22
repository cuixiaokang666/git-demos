package com.houduan.controller;

import com.houduan.service.Dapservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.houduan.entity.Dap;
import java.util.List;

@RestController
@CrossOrigin
public class Dapcontroller {

   @Autowired
    private Dapservice serivce;

    @GetMapping("/dap/selectAll")
    public List<Dap> selectAll(){
        List<Dap> daps = serivce.selectAll();
        return daps;

    }
}
