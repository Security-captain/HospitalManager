package com.cssl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author jalon
 * @date 2020-12-8 10:49
 */
@Controller
public class ZhuController {

    //to index > login  去登陆页面
    @RequestMapping("/")
    public String main(){
        return "index";
    }

    //后台首页
//    @RequestMapping("/")
//    public String index(){
//        return "view/index";
//    }

}
