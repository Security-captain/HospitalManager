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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author jalon
 * @date 2020-12-4 17:56
 */
@RestController
//@Controller
//@RequestMapping("/liao")
public class LiaopayController {

    @Autowired
    private LiaoPayService liaoPayService;
    @Autowired
    private LiaoAdminService liaoAdminService;

//    //2.跳转预交款页面
//    @RequestMapping("pay")
//    public String topay(){
//        System.out.println("-----------------pay----------------");
//        return "liao/pay";
//    }

    //查询和交款
    @RequestMapping("selPay")
    public List<Register> selPay(@RequestBody Register register, Double moneys){
        System.out.println("------------P-----selpay----------------");
        System.out.println(register);
        System.out.println(moneys);
        //判断是否是交款
        if(moneys!=0){
            register.setMoney(moneys);
            //修改预交款
            liaoPayService.updPay(register);
            //添加预交款记录
            liaoPayService.addPay(register);
        }
        List<Register> registers = liaoAdminService.selRegister(register);
        return registers;
    }

    //查询交款记录
    @RequestMapping("selPays")
    public Map<String, Object> selPays(Integer page, Integer limit,@RequestBody Register register){
        System.out.println("------------P-----selpays----------------");
        System.out.println(register);
        PageHelper.startPage(page, limit);
        List<Pay> selPays=liaoPayService.selPays(register);
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
        System.out.println("--------------P---selSurplus----------------");
        System.out.println(lrecord);
        List<Lrecord> list = liaoPayService.selSurplus(lrecord);
        return list;
    }

}
