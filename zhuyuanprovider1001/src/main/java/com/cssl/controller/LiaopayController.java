package com.cssl.controller;

import com.cssl.pojo.Lrecord;
import com.cssl.pojo.Pay;
import com.cssl.pojo.Register;
import com.cssl.service.LiaoAdminService;
import com.cssl.service.LiaoPayService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * --------------------缴费管理
 * @author jalon
 * @date 2020-12-4 17:56
 */
@RestController
public class LiaopayController {

    @Autowired
    private LiaoPayService liaoPayService;
    @Autowired
    private LiaoAdminService liaoAdminService;
    //time
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

    //查询和交款
    @RequestMapping("selPay")
    public List<Register> selPay(@RequestBody Register register, Double moneys){
        System.out.println("------------交钱  改预交款----------------");
        //判断是否是交款
        if(moneys!=0){
            register.setMoney(moneys);
            //修改预交款
            liaoPayService.updPay(register);
            //添加预交款记录
            liaoPayService.addPay(register);
        }
        List<Register> registers = liaoAdminService.selRegister(register);
        registers.forEach(i->{
            System.out.println("i.getRegisterDate() = " + i.getRegisterDate());
            System.out.println(i.getDay());
        });
        return registers;
    }

    //查询交款记录
    @RequestMapping("selPays")
    public Map<String, Object> selPays(Integer page, Integer limit,@RequestBody Register register){
        System.out.println("------------查交钱记录----------------");
        PageHelper.startPage(page, limit);
        List<Pay> selPays=liaoPayService.selPays(register);
        selPays.forEach(i->{
            System.out.println("交款时间---------"+i.getPayDate());
        });
        PageInfo pageInfo = new PageInfo(selPays);
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

    //查询已用多少
    @RequestMapping("selSurplus")
    public List<Lrecord> selSurplus(@RequestBody Lrecord lrecord){
        System.out.println("--------------查询用了多少----------------");
        System.out.println(lrecord);
        List<Lrecord> list = liaoPayService.selSurplus(lrecord);
        return list;
    }

}
