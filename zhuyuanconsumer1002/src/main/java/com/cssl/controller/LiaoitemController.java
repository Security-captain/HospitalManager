package com.cssl.controller;

import com.cssl.client.MenuClient;
import com.cssl.pojo.Litem;
import com.cssl.pojo.Lrecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * @author jalon
 * @date 2020-12-10 14:23
 */
@Controller
@RequestMapping("/liao")
public class LiaoitemController {

    @Autowired
    private MenuClient client;

    //4.跳转项目记账
    @RequestMapping("item")
    public String toitem(){
        System.out.println("------------------item---------------");
        return "liao/item";
    }

    //查询收费项目
    @RequestMapping("selItems")
    @ResponseBody
    public Object selItems(Integer page, Integer limit, Litem litem){
        return client.selItems(page,limit,litem);
    }

    //添加收费项目
    @RequestMapping("addItem")
    @ResponseBody
    public Object updItem(Lrecord lrecord){
        int i = client.updItem(lrecord);
        if(i==1){
            return "添加成功！！";
        }else{
            return "添加失败！！";
        }
    }

    //查询患者收费项目
    @RequestMapping("selItem")
    @ResponseBody
    public Object selItem(Integer page, Integer limit, Lrecord lrecord){
        return client.selItem(page,limit,lrecord);
    }

    //移除患者收费项目
    @RequestMapping("delItem")
    @ResponseBody
    public Object delItem(Integer hospitalpriceid){
        int i = client.delItem(hospitalpriceid);
        if(i==1){
            return "移除成功！！";
        }else{
            return "移除失败！！";
        }
    }

}
