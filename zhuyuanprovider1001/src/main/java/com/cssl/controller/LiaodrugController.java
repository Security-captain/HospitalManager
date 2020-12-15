package com.cssl.controller;

import com.cssl.pojo.Lpharmacy;
import com.cssl.pojo.Lrecord;
import com.cssl.service.LiaoDrugService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * --------------------药品记账
 * @author jalon
 * @date 2020-12-5 09:03
 */
@RestController
//@Controller
//@RequestMapping("/liao")
public class LiaodrugController {

    @Autowired
    private LiaoDrugService liaoDrugService;

    //查询药品信息
    @RequestMapping("selDrug")
    public Object selDrug(Integer page, Integer limit,@RequestBody Lpharmacy lpharmacy){
        //pharmacy  药品表
        PageHelper.startPage(page,limit);
        List<Lpharmacy> listAll = liaoDrugService.selDrug(lpharmacy);
        PageInfo pageInfo = new PageInfo(listAll);
        Map<String,Object> tableData = new HashMap<>();
        //layui返回json格式
        tableData.put("code",0);
        tableData.put("msg","");
        //count记录数给前台
        tableData.put("count",pageInfo.getTotal());
        //将分页后的数据返回（每页要显示的数据）
        tableData.put("data",pageInfo.getList());
        return tableData;
    }

    //查用户的药品信息
    @RequestMapping("selDrugs")
    public Object selDrugs(Integer page, Integer limit,@RequestBody Lrecord lrecord){
        lrecord.setState(0);    //状态为0的
        PageHelper.startPage(page,limit);
        List<Lrecord> listAll = liaoDrugService.selDrugs(lrecord);
        PageInfo pageInfo = new PageInfo(listAll);
        Map<String,Object> tableData = new HashMap<>();
        tableData.put("code",0);
        tableData.put("msg","");
        tableData.put("count", pageInfo.getTotal());
        tableData.put("data", pageInfo.getList());
        return tableData;
    }

    //查询用户取过的药品信息
    @RequestMapping("selPhar")
    public Object selPhar(Integer page, Integer limit,@RequestBody Lrecord lrecord){
        lrecord.setState(2);
        PageHelper.startPage(page,limit);
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

    //查询药品库存数量
    @RequestMapping("selNum")
    public Object selNum(Integer pharmacyId){
        Lpharmacy lpharmacy=new Lpharmacy();
        lpharmacy.setPharmacyId(pharmacyId);
        List<Lpharmacy> listAll =liaoDrugService.selDrug(lpharmacy);
        return listAll;
    }

    //添加药品清单
    @RequestMapping("addDrug")
    @Transactional
    public int addDrug(@RequestBody Lrecord lrecord) {
        //查询是否添加过该药品
        lrecord.setState(0);
        int rel = 0;
        //查询是否添加过但未取出该药品
        List<Lrecord> lrecords = liaoDrugService.selDrugs(lrecord);
        for (int i = 0; i < lrecords.size(); i++) {
            if (lrecords.get(i).getDurgname().equals(lrecord.getDurgname())) {
                rel = 1;
                break;
            }
        }
        if (rel == 1) {
            //修改患者药品数量
            int j = liaoDrugService.updDrug(lrecord);
            if (j == 1) {
                //减少药品数量
                int o = liaoDrugService.updNum(lrecord);
                if (o == 1) {
                    return 1;          //添加成功
                } else {
                    return 0;          //添加失败
                }
            } else {
                return 0;
            }
        } else {
            //计算总价
            Double qian = lrecord.getRepiceprice();
            Integer shu = lrecord.getDurgnum();
            Double sum = qian * shu;
            lrecord.setRepicetotal(sum);
            lrecord.setState(0);
            //添加药品
            int i = liaoDrugService.addDrug(lrecord);
            if (i == 1) {
                //减少药品数量
                int j = liaoDrugService.updNum(lrecord);
                if (j == 1) {
                    return 1;
                } else {
                    return 0;
                }
            } else {
                return 0;
            }
        }
    }

    //移除患者的药品信息
    @RequestMapping("delDrug")
    public int delDrug(Integer hospitalpriceid,String durgname,Integer durgnum){
        Lrecord lrecord=new Lrecord();
        lrecord.setHospitalpriceid(hospitalpriceid);
        int i = liaoDrugService.delDrug(lrecord);
        if (i == 1) {
            lrecord.setDurgname(durgname);
            lrecord.setDurgnum(durgnum);
            int j = liaoDrugService.updDrugs(lrecord);
            if (j == 1) {
                return 1;          //移除成功
            } else {
                return 0;
            }
        } else {
            return 0;
        }
    }

    //改变患者的药品状态
    @RequestMapping("updDrug")
    public int upddItem(@RequestBody Lrecord lrecord){
        int upd = liaoDrugService.upd(lrecord);
        System.out.println(upd);
        return 1;          //"取药成功"
    }

}
