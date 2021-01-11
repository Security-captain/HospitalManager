package com.cssl.controller;

import com.cssl.client.StoreClient;
import com.cssl.pojo.Drugstore;
import com.cssl.pojo.Skull;
import com.cssl.pojo.Upplier;
import com.cssl.pojo.Warehouse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * zzy  仓库的跳转！
 */
@Controller
@RequestMapping("dsnavigation")
public class PathstoreController {

    @Autowired
    private StoreClient storeClient;

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
    //库房药品回收
    @RequestMapping("recycle")
    public Object recycle() {
        return "drugstore/c_recycle";
    }

    //库房药品出库
    @RequestMapping("selectchuku")
    //@ResponseBody
    public Object selectchuku(Model model) {
        int selbaoquecount = storeClient.selectchuku();
        System.out.println("data ================== " + selbaoquecount);
        //在进入出库时查询报缺单有几条报缺显示在表头
        model.addAttribute("selbaoquecount",selbaoquecount);
        return "drugstore/c_gooutstore";
    }
    //进入药品日期报警
    @RequestMapping("seldrugDate")
    //@ResponseBody
    public Object seldrugDate(Drugstore drugstore, Model model) {
        int selcountlessnum = storeClient.seldrugDate(drugstore);
        System.out.println("data ================== " + selcountlessnum);
        model.addAttribute("selcountlessnum",selcountlessnum);
        return "drugstore/c_storedrugDate";
    }

    //进入入库单页面--------------map
    @RequestMapping("beputinstorage")
    //@ResponseBody
    public Object beputinstorage(Model model){
        Map<String,Object> mp = storeClient.beputinstorage();
        List<Upplier> selupp = (List<Upplier>) mp.get("selupp");
        List<Skull> selsku = (List<Skull>) mp.get("selsku");
        List<Warehouse> selwar = (List<Warehouse>) mp.get("selwar");

        model.addAttribute("selupp",selupp);
        model.addAttribute("selsku",selsku);
        model.addAttribute("selwar",selwar);
        return "drugstore/c_beputinstorage";
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
