package com.cssl.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class registeredtypeController {



   /* 默认端口页面*/
    @RequestMapping("/index")
    public String login(){

        return "view/index";

    }






}
