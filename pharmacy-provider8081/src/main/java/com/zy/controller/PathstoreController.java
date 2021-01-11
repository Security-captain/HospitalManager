package com.zy.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cssl.pojo.Drugstore;
import com.cssl.pojo.*;
import com.zy.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//zzy   跳转
@RestController
public class PathstoreController {
    @Autowired
    private SkullService skullService;

    @Autowired
    private UpplierService upplierService;

    @Autowired
    private WareHuoseService wareHuoseService;

    @Autowired
    private BaoqueService baoqueService;

    @Autowired
    private DrugstoreService storeService;
    //进入库房查询
    @RequestMapping("store")
    public Object store(){
        return "drugstore/c_store";
    }
    //进入库房查询
    @RequestMapping("pharymacyhtml")
    public Object pharymaryhtml(){
        return "drugstore/c_pharmacy";
    }
    //库房药品查询
    @RequestMapping("selectdurg")
    public Object selectdurg() {
        return "drugstore/c_selectDrug";
    }
    //库房药品查询
    @RequestMapping("recycle")
    public Object recycle() {
        return "drugstore/c_recycle";
    }

    //库房药品出库
    @RequestMapping("selectchuku")
    public int selectchuku(Model model) {
        System.out.print("进入出库");
        int selbaoquecount = baoqueService.count();
        return selbaoquecount;
    }
//    //进入药品日期报警
    @RequestMapping("seldrugDate")
    public int seldrugDate(Drugstore drugstore, Model model) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date now = new Date();
        String NowTime = sdf.format(now);
        int selcountlessnum = storeService.count(new QueryWrapper<Drugstore>().lt("validDate",NowTime));
        return selcountlessnum;
    }


    //进入入库单页面
    @RequestMapping("beputinstorage")
    public Map<String, Object> beputinstorage(Model model){
        //查询供货商，经办人，库房
        List<Upplier> selupp =  upplierService.list();
        List<Skull> selsku = skullService.list();
        List<Warehouse> selwar = wareHuoseService.list();
        Map<String,Object> mp = new HashMap<>();
        mp.put("selupp",selupp);
        mp.put("selsku",selsku);
        mp.put("selwar",selwar);
        /*model.addAttribute("selupp",selupp);
        model.addAttribute("selsku",selsku);
        model.addAttribute("selwar",selwar);*/
        return mp;
    }

    //进入药品报缺
    @RequestMapping("selectless")
    public Object selectless(Model model) {
        return "drugstore/c_lackdrug";
    }


    //进入操作记录页面
    @RequestMapping("record")
    public  Object record(){
        return "drugstore/c_record";
    }

}
