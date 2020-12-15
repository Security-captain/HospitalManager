package com.cssl.controller;

import com.cssl.pojo.Register;
import com.cssl.service.LiaoLeaveService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * --------------------出院
 * @author jalon
 * @date 2020-12-4 17:56
 */
//@Controller
//@RequestMapping("/liao")
@RestController
public class LiaoleaveController {

    @Autowired
    private LiaoLeaveService liaoLeaveService;

    //查询已经出院的信息
    @RequestMapping("selRegisters")
    public Object selRegisters(Integer page, Integer limit,String userNames){
        Register register=new Register();
        register.setUserName(userNames);
        PageHelper.startPage(page, limit);
        List<Register> list = liaoLeaveService.selRegisters(register);
        PageInfo pageInfo = new PageInfo(list);
        Map<String, Object> tableData = new HashMap<String, Object>();
        //这是layui要求返回的json数据格式
        tableData.put("code", 0);
        tableData.put("msg", "");
        //将全部数据的条数作为count传给前台（一共多少条）
        tableData.put("count", pageInfo.getTotal());
        //将分页后的数据返回（每页要显示的数据）
        tableData.put("data", pageInfo.getList());
        return tableData;
    }


    //患者出院
    @RequestMapping("updLeave")
    public int updLeave(@RequestBody Register register){
        int i = liaoLeaveService.updRstate(register);
        if(i==1){
            int j = liaoLeaveService.updBstate(register);
            if(j==1){
                return j;      //"出院成功"
            }else{
                return 0;      //失败
            }
        }else{
            return 1;
        }
    }

    //判断是否还有未取出的药品
    @RequestMapping("selYaos")
    public Object selYaos(@RequestBody Register register){
        int i = liaoLeaveService.selYaos(register);
        return i;
    }

    //出院个人详情
    @RequestMapping("selregis")
    public Object selregis(Integer registerid){
        Register register=new Register();
        register.setRegisterid(registerid);
        List<Register> registers = liaoLeaveService.selRegisters(register);
        return registers;
    }


}
