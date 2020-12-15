package com.cssl.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author jalon
 * @date 2020-12-4 09:02
 * 跳默认页面
 */
//@RestController
@Controller
public class ZhuController {

//    @Value("${server.port}")
//    private String port;

    @RequestMapping("/")
    public String main(){
        return "index";
    }

//    @GetMapping("/index")
//    public String index(){
//        return "端口："+this.port;
//    }


}
