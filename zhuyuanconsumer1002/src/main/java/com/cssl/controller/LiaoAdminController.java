package com.cssl.controller;

import com.cssl.client.MenuClient;
import com.cssl.pojo.Register;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * @author jalon
 * @date 2020-12-9 17:33
 */
@Controller
@RequestMapping("/liao")
public class LiaoAdminController {

    @Autowired
    private MenuClient client;

    //1.跳到入院登记
    @RequestMapping("admin")
    public String toadmin(){
        System.out.println("----------------admin-----------------");
        return "liao/admin";
    }

    //查询患者信息
    @RequestMapping("/selRegister")
    @ResponseBody
    public Object selRegister(Integer page, Integer limit, Register register){
        Map<String,Object> tableData = client.selRegister(page,limit,register);
        return tableData;
    }

    //页面请求查询科室信息
    @RequestMapping("/selDepartment")
    @ResponseBody
    public Object selDepartment(){
        return client.selDepartment();
    }

    //页面请求查询医生信息
    @RequestMapping("selDoctor")
    @ResponseBody
    public Object selDoctor(Integer departmentId){
        return client.selDoctor(departmentId);
    }

    //查询床位
    @RequestMapping("selBed")
    @ResponseBody
    public Object selBed(Integer departmentId){
        return client.selBed(departmentId);
    }

    //添加患者
    @RequestMapping("addRegister")
    @ResponseBody
    public Object addRegister(Register register){
        int i = client.addRegister(register);
        if(i==2){
            return "该患者已存在，请不要重复添加！";
        }else if(i==0){
            return "添加失败！";
        }else {
            return "添加成功！";
        }
    }

    //查询折扣
    @RequestMapping("selDis")
    @ResponseBody
    public Object selDis(){
        return client.selDis();
    }

    //查询门诊过来的患者
    @RequestMapping("selDoor")
    @ResponseBody
    public Object selDoor(Integer page, Integer limit){
        return client.selDoor(page,limit);
    }

    //转科室
    @RequestMapping("updKe")
    @ResponseBody
    public Object updKe(Register register){
        int i = client.updKe(register);
        if(i==0){
            return "转科室失败！！";
        }else{
            return "转科室成功！！";
        }
    }

}
