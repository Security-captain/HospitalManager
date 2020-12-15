package com.cssl.controller;

import com.cssl.client.MenuClient;
import com.cssl.pojo.Register;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jalon
 * @date 2020-12-11 09:54
 */
@Controller
@RequestMapping("/liao")
public class LiaoLeaveController {

    @Autowired
    private MenuClient client;

    //5.跳转出院结算
    @RequestMapping("leave")
    public String toleave(){
        System.out.println("------------------leave---------------");
        return "liao/leave";
    }

    //查询已经出院的信息
    @RequestMapping("/selRegisters")
    @ResponseBody
    public Object selRegisters(Integer page, Integer limit,String userNames){
        return client.selRegisters(page,limit,userNames);
    }


    //患者出院
    @RequestMapping("/updLeave")
    @ResponseBody
    public Object updLeave(Register register){
        int i = client.updLeave(register);
        if(i==0){
            return "出院失败！！";
        }else{
            return "出院成功！！";
        }
    }

    //判断是否还有未取出的药品
    @RequestMapping("/selYaos")
    @ResponseBody
    public Object selYaos(Register register){
        return client.selYaos(register);
    }

    //出院个人详情
    @RequestMapping("/selregis")
    @ResponseBody
    public Object selregis(Integer registerid){
        return client.selregis(registerid);
    }


}
