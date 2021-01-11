package com.cssl.controller;


import com.cssl.client.Nacosfegin;
import com.cssl.pojo.CCashier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

//py 缴费
@Controller
@RequestMapping("xpay")
public class xianmujiaohuiController {
    @Autowired
    private Nacosfegin nacosfegin;


    //进入项目收费页面
    @RequestMapping("xiangpay")
    public String xiangpay(){
        return "cao/xaingmupay";
    }
    //选择患者后对该患者的项目进行查询
    @RequestMapping("selxiang")
    @ResponseBody
    public Object selxiang(Integer page,Integer limit,Integer perid){
        System.out.println(" //选择患者后对该患者的项目进行查询");
        return nacosfegin.selxiang(page,limit,perid);
    }
    //点击确认收费前确定该患者有没有收费项目
    @RequestMapping("selshoux")
    @ResponseBody
    public Object selshoux(Integer perid)
    {
        System.out.println("//点击确认收费前确定该患者有没有收费项目");
        return nacosfegin.selshoux(perid);
    }
    //项目缴费修改项目的收费状态
    @RequestMapping("shoufei")
    @ResponseBody
    public Object shoufei(Integer perid){
        System.out.println("//项目缴费修改项目的收费状态");
        return nacosfegin.shoufei(perid);
    }
    //进入项目检查页面
    @RequestMapping("seljian")
    public Object seljian()
    {
        return "cao/jiancha";
    }
    //查询该用户的所有要检查的项目
    @RequestMapping("selcha")
    @ResponseBody
    public Object selcha(Integer page,Integer limit,Integer perid){
        System.out.println("//查询该用户的所有要检查的项目");
        return nacosfegin.selcha(page,limit,perid);
    }
    //添加用户项目的检查结果
    @RequestMapping("addbing")
    @ResponseBody
    public Object addbing(CCashier cCashier, Integer reid, String bing, Integer cashier){
        System.out.println("//添加用户项目的检查结果");
        return nacosfegin.addbing(cCashier,reid,bing,cashier);
    }
}
