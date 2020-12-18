package com.cssl.controller;

import com.cssl.pojo.Litem;
import com.cssl.pojo.Lrecord;
import com.cssl.service.LiaoDrugService;
import com.cssl.service.LiaoItemService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * --------------------项目记账
 * @author jalon
 * @date 2020-12-4 17:56
 */
@RestController
//@Controller
//@RequestMapping("/liao")
public class LiaoitemController {

    @Autowired
    private LiaoItemService liaoItemService;
    @Autowired
    private LiaoDrugService liaoDrugService;

    //查询收费项目
    @RequestMapping("selItems")
    public Object selItems(Integer page, Integer limit,@RequestBody Litem litem){
        PageHelper.startPage(page, limit);
        List<Litem> listAll =liaoItemService.selItems(litem);
        PageInfo pageInfo = new PageInfo(listAll);
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

    //添加收费项目
    @RequestMapping("addItem")
    public int updItem(@RequestBody Lrecord lrecord){
        lrecord.setDurgnum(1);
        lrecord.setState(1);
        lrecord.setRepicetotal(lrecord.getRepiceprice()*lrecord.getDurgnum());
        Integer integer = liaoDrugService.addDrug(lrecord);
        if(integer==1){
            return integer;     //成功
        }else{
            return 0;
        }
    }

    //查询患者收费项目
    @RequestMapping("selItem")
    public Object selItem(Integer page, Integer limit,@RequestBody Lrecord lrecord){
        lrecord.setState(1);
        PageHelper.startPage(page, limit);
        List<Lrecord> listAll =liaoDrugService.selDrugs(lrecord);
        PageInfo pageInfo = new PageInfo(listAll);
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

    //移除患者收费项目
    @RequestMapping("delItem")
    public int delItem(Integer hospitalpriceid){
        Lrecord lrecord=new Lrecord();
        lrecord.setHospitalpriceid(hospitalpriceid);
        int i = liaoDrugService.delDrug(lrecord);
        if (i == 1) {
            return i;      //移除成功
        } else {
            return 0;
        }
    }

}
