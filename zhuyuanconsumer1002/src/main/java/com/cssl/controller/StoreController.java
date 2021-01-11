package com.cssl.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cssl.client.StoreClient;
import com.cssl.pojo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * zzy  仓库管理
 */
@RestController
public class StoreController {

    @Autowired
    private StoreClient storeClient;

    /**
     * 添加药品到药品仓库
     * */
    @RequestMapping("insertDrugstore")
    public boolean insertDrugstore(@RequestParam Map<String,Object> maps){
        System.out.println("--------------"+maps);
        return storeClient.insertDrugstore(maps);
    }

    /**
     * 查询供货商
     * */
    @RequestMapping("selectUpplier")
    public List<Upplier> selectUpplier(){
        return storeClient.selectUpplier();
    }

    /**
     * 查询经办人
     * */
    @RequestMapping("selectSkull")
    public List<Skull> selectSkull(){
        return storeClient.selectSkull();
    }

    /**
     * 查询仓库 WareHuose
     * */
    @RequestMapping("selectWareHuose")
    public List<Warehouse> selectWareHuose(){
        return storeClient.selectWareHuose();
    }

    @RequestMapping("selectDrugdictionary")
    public Map<String,Object> selectDrugdictionary( int limit, int page, String drugName){
        return storeClient.selectDrugdictionary(limit,page,drugName);
    }

    //查询此药品在仓库中还有多少
    @RequestMapping("selectNum")
    public int selectNum( String drugstoreName){
        return storeClient.selectNum(drugstoreName);
    }

    /**
     *
     *                  以上是入库单的页面所需接口
     *
     **/

    /**
     * 查询库房药品信息
     * */
    @RequestMapping("selectWareHuosePharmacy")
    public Map<String,Object> selectWareHuosePharmacy( String drugstoreName, int limit,int page){
        return storeClient.selectWareHuosePharmacy(drugstoreName,limit,page);
    }

    //修改仓库药品信息
    @RequestMapping("updateDrugstore")
    public Object updateDrugstore(@RequestParam Map<String,Object> map){
        return storeClient.updateDrugstore(map);
    }


    /**
     * 查询药品类型
     * */
    @RequestMapping("selectType")
    public List<Type> selectType(){
        return storeClient.selectType();
    }

    /**
     * 查询产地
     * */
    @RequestMapping("selectArea")
    public List<Area> selectArea(){
        return storeClient.selectArea();
    }

    @RequestMapping("selectUnit")
    public List<Unit> selectUnit(){
        return storeClient.selectUnit();
    }

    @RequestMapping("updateDrugstoreRk")
    public boolean updateDrugstoreRk( Drugstore drugstore){
        return storeClient.updateDrugstoreRk(drugstore);
    }

    @RequestMapping("selectBaoque")
    public Map<String,Object> selectBaoque(){
        return storeClient.selectBaoque();
    }

    @RequestMapping("selectByNameDrugstore")
    public Map<String,Object> selectByNameDrugstore( String name){
        return storeClient.selectByNameDrugstore(name);
    }

    //出库单开始
    @RequestMapping("updateDrugstoreCk")
    public boolean updateDrugstoreCk(@RequestParam Map<String,Object> map){
        return storeClient.updateDrugstoreCk(map);
    }

    @RequestMapping("addDrugstore")
    public boolean addDrugstore(@RequestParam Map<String,Object> map){
        return storeClient.addDrugstore(map);
    }
    //出库单结束

    //库存不足查询
    @RequestMapping("selectInsufficient")
    public Map<String,Object> selectInsufficient( int page, int limit){
        return storeClient.selectInsufficient(page,limit);
    }
    //end

    //过期提醒↓↓↓↓
    @RequestMapping("selectGuoQi")
    public Map<String,Object> selectGuoQi( int page, int limit){
        return storeClient.selectGuoQi(page,limit);
    }

    //删除过期的药品
    @RequestMapping("delGuoQi")
    public boolean delGuoQi(@RequestParam Map<String,Object> map){
        return storeClient.delGuoQi(map);
    }

    //end

    //查询全部操作记录
    @RequestMapping("selectJiLu")
    public Map<String,Object> selectJiLu( String type, int page, int limit){
        return storeClient.selectJiLu(type,page,limit);
    }
    //end

    //查询所有回收药品
    @RequestMapping("selectHuiShou")
    public Map<String,Object> selectHuiShou( int page, int limit){
        return storeClient.selectHuiShou(page,limit);
    }

    //删除有问题回收的药品
    @RequestMapping("delHuiShou")
    public boolean delHuiShou(@RequestParam Map<String,Object> map){
        return storeClient.delHuiShou(map);
    }
    //end

    //查询药房信息
    @RequestMapping("selectPharmcay")
    public Map<String,Object> selectPharmcay( String pharmacyName, int page, int limit){
        return storeClient.selectPharmcay(pharmacyName,page,limit);
    }

    //添加报缺信息
    @RequestMapping("addBaoQue")
    public boolean addBaoQue(@RequestParam Map<String,Object> map){
        return storeClient.addBaoQue(map);
    }

    //回收药品
    @RequestMapping("huiShou")
    public boolean huiShou(@RequestParam Map<String,Object> map, int pharmacyId){
        return storeClient.huiShou(map,pharmacyId);
    }

}
