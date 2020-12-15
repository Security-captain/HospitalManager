package com.cssl.controller;

import com.cssl.client.MenuClient;
import com.cssl.pojo.Lpharmacy;
import com.cssl.pojo.Lrecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.transaction.annotation.Transactional;

/**
 * @author jalon
 * @date 2020-12-10 19:00
 */
@Controller
@RequestMapping("/liao")
public class LiaodrugController {

    @Autowired
    private MenuClient client;

    //3.跳转药品记账页面
    @RequestMapping("drug")
    public String godrug(){
        System.out.println("-----------------drug----------------");
        return "liao/drug";
    }
    //跳转住院取药页面
    @RequestMapping("/pharmacy")
    public String pharmacy(){
        System.out.println("-----------------pharmacy----------------");
        return "liao/pharmacy";
    }

    //查询药品信息
    @RequestMapping("/selDrug")
    @ResponseBody
    public Object selDrug(Integer page, Integer limit, Lpharmacy lpharmacy){
        return client.selDrug(page,limit,lpharmacy);
    }

    //查用户的药品信息
    @RequestMapping("/selDrugs")
    @ResponseBody
    public Object selDrugs(Integer page, Integer limit, Lrecord lrecord){
        return client.selDrugs(page,limit,lrecord);
    }

    //查询用户取过的药品信息
    @RequestMapping("/selPhar")
    @ResponseBody
    public Object selPhar(Integer page, Integer limit, Lrecord lrecord){
        return client.selPhar(page,limit,lrecord);
    }

    //查询药品库存数量
    @RequestMapping("/selNum")
    @ResponseBody
    public Object selNum(Integer pharmacyId){
        return client.selNum(pharmacyId);
    }

    //添加药品清单
    @RequestMapping("/addDrug")
    @ResponseBody
    //@Transactional
    public Object addDrug(Lrecord lrecord) {
        int i = client.addDrug(lrecord);
        if(i==0){
            return "添加失败！!";
        }else{
            return "添加成功！！";
        }
    }

    //移除患者的药品信息
    @RequestMapping("/delDrug")
    @ResponseBody
    public Object delDrug(Integer hospitalpriceid,String durgname,Integer durgnum){
        int i = client.delDrug(hospitalpriceid,durgname,durgnum);
        if(i==0){
            return "移除失败！!";
        }else{
            return "移除成功！！";
        }
    }

    //改变患者的药品状态
    @RequestMapping("/updDrug")
    @ResponseBody
    public Object upddItem(Lrecord lrecord){
        int i = client.upddItem(lrecord);
        if(i==0){
            return "取药失败！!";
        }else{
            return "取药成功！！";
        }
    }

}
