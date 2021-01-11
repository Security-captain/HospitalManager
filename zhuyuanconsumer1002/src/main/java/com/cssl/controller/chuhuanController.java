package com.cssl.controller;


import com.cssl.client.Nacosfegin;
import com.cssl.pojo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.Map;

//py    处方
@Controller
@RequestMapping("caocc")
public class chuhuanController {

    @Autowired
    private Nacosfegin nacosfegin;

    //进入处方页面
    @RequestMapping("cc")
    public Object look(){
        return  "cao/cashier";
    }

    //查询所有患者信息
    @RequestMapping("selpreson")
    @ResponseBody
    public Object selperson(Integer page, Integer limit){
        System.out.println("//查询所有患者信息");
        Map<String,Object> selperson = nacosfegin.selperson(page,limit);
        return selperson;

    }
    //查询药品所有信息
    @RequestMapping("seldrug")
    @ResponseBody
    public Object seldrug(String durgname,Integer page, Integer limit,CPharmacy cPharmacy){
      System.out.println("//查询药品所有信息");
        Map<String,Object> seldrug = nacosfegin.seldrug(durgname,page,limit,cPharmacy);
        return seldrug;
    }
    //查询处方中是否有这个药
    @RequestMapping("selchu")
    @ResponseBody
    public Object seslchu(CCashier cCashier, Integer reid, String mename){
        System.out.println("//查询处方中是否有这个药");
       return nacosfegin.seslchu(cCashier,reid,mename);
    }
    //添加处方药品
    @RequestMapping("addchu")
    @ResponseBody
    public Object addchu(CFTJ cftj){
        System.out.println("///添加处方药品");
        return nacosfegin.addchu(cftj);

    }
    //查询该用户的处方
    @RequestMapping("selpepi")
    @ResponseBody
    public Object selpepi(Integer perid,Integer page, Integer limit){
        return nacosfegin.selpepi(perid,page,limit);
    }

    //删除处方中的药品
    @RequestMapping("del")
    @ResponseBody
    public String del(String durnme,Integer durnum,CFTJ cftj){
        System.out.println(" //删除处方中的药品");
        System.out.println(nacosfegin.del(durnme,durnum,cftj));
        return nacosfegin.del(durnme,durnum,cftj);
    }
    //如果处方中有该药品则修改该药品的数量和价钱
    @RequestMapping("updchu")
    @ResponseBody
    public Object updchu( CFTJ cftj){
        System.out.println(" //如果处方中有该药品则修改该药品的数量和价钱");
        return nacosfegin.updchu(cftj);
    }
    //模糊查询
    @RequestMapping("mohu")
    @ResponseBody
    public Object mohu(String durgname, ReportVo reportVo, Integer page, Integer limit){
        System.out.println("//模糊查询");
        return nacosfegin.mohu(durgname,reportVo,page,limit);
    }

    //添加用户病因
    @RequestMapping("addbing")
    @ResponseBody
    public Object addbing(Integer reid, String bing, CReport cReport){
        System.out.println(" //添加用户病因");
        return nacosfegin.addbing(reid,bing,cReport);
    }

    //查询用户有没有填写病因
    @RequestMapping("selbing")
    @ResponseBody
    public Object selbing(Integer reid){
        System.out.println(" //查询用户有没有填写病因");

        Object selbing =nacosfegin.selbing(reid);

        return selbing;
    }
    //查看用户的检查结果
    @RequestMapping("lookbing")
    @ResponseBody
    public Object lookbing(Integer reid){
        System.out.println(" //查看用户的检查结果");
        return nacosfegin.lookbing(reid);
    }
    //查看该用户是否还有未交钱的项目
    @RequestMapping("seljiao")
    @ResponseBody()
    public Object seljiao(Integer reid){
        System.out.println("//查看该用户是否还有未交钱的项目");
        return nacosfegin.seljiao(reid);
    }
    //查询该用户所有的处方
    @RequestMapping("selall")
    @ResponseBody
    public Object selall(Integer perid,Integer page, Integer limit){
        System.out.println("//查询该用户所有的处方");
        Map<String, Object> selalls=nacosfegin.selall(perid,page,limit);
        return selalls;
    }

    //查询用户所有的项目处方
    @RequestMapping("selximu")
    @ResponseBody
    public Object selximu(Integer perid,Integer page, Integer limit){
        System.out.println(" //查询用户所有的项目处方");
        return nacosfegin.selximu(perid,page,limit);
    }
    //查看该用户是否有缴费未做的项目
    @RequestMapping("selwei")
    @ResponseBody
    public String selwei(Integer reid){
        System.out.println("//查看该用户是否有缴费未做的项目");

       String selwei=nacosfegin.selwei(reid);
        System.out.println(selwei);
        return selwei;
    }
}
