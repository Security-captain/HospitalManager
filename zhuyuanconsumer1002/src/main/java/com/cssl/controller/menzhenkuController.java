package com.cssl.controller;


import com.cssl.client.Nacosfegin;
import com.cssl.pojo.ReportVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

//py
@Controller
@RequestMapping("caotake")
public class menzhenkuController {
    @Autowired
    private Nacosfegin nacosfegin;
//    @Autowired
//    private DiscoveryClient discoveryClient;


    /*门诊取药页面*/
    @RequestMapping("seltake")
    private Object seltake()

    {
        return "cao/Cquyao";
    }
    //查询所有患者信息
    @RequestMapping("tselpreson")
    @ResponseBody
    public Object tselperson(Integer page, Integer limit){

        return nacosfegin.tselperson(page,limit);

    }
    //修改用户状态
    @RequestMapping("chuku")
    @ResponseBody
    public Object chuku(ReportVo reportVo){
        return nacosfegin.chuku(reportVo);
    }

    //进入查看患者页面
    @RequestMapping("haun")
    public Object haun(){

        return "cao/chuanzhe";

    }


    @RequestMapping("selhuan")
    @ResponseBody
    public Object selhuan(ReportVo reportVo,Integer page, Integer limit){

        System.out.println("consumter//查看患者信息");

        return nacosfegin.selhuan(reportVo,page,limit);
    }

    //查看该用户的总价格
    @RequestMapping("zong")
    @ResponseBody
    public Object zong(Integer reid){
        return nacosfegin.zong(reid);
    }
}
