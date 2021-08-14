package com.fc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

    @PostMapping("/test")
    @ResponseBody
    public String test(Integer id,String name){
        System.out.println("id="+id);
        System.out.println("name="+name);
        if(id>0){
            return "success "+name;
        }else{
            return "fail";
        }
    }

}
