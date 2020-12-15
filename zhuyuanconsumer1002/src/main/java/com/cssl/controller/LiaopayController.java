package com.cssl.controller;

import com.cssl.client.MenuClient;
import com.cssl.pojo.Lrecord;
import com.cssl.pojo.Register;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


/**
 * @author jalon
 * @date 2020-12-10 14:44
 * 缴费管理
 */
@Controller
@RequestMapping("/liao")
public class LiaopayController {

    @Autowired
    private MenuClient client;

    //2.跳转预交款页面
    @RequestMapping("pay")
    public String topay(){
        System.out.println("-----------------pay----------------");
        return "liao/pay";
    }

    //查询和交款
    @RequestMapping("selPay")
    @ResponseBody
    public Object selPay(Register register,Double moneys){
        System.out.println("register=========="+register);
        List<Register> lr = client.selPay(register,moneys);
        return lr;
    }

    //查询交款记录
    @RequestMapping("selPays")
    @ResponseBody
    public Object selPays(Integer page, Integer limit,Register register){
        System.out.println("-----------------selpays----------------"+"\n"+register);
        return client.selPays(page,limit,register);
    }

    //查询已用多少
    @RequestMapping("selSurplus")
    @ResponseBody
    public Object selSurplus(Lrecord lrecord){
        System.out.println("-----------------selSurplus----------------");
        List<Lrecord> ll = client.selSurplus(lrecord);
        return ll;
    }

}
