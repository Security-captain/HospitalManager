package com.cssl.client;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cssl.pojo.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;


/**
 * zzy  仓库  药房
 */
@FeignClient(name = "zy-provider")
public interface StoreClient {

    /**
     * ------------跳转
     * @return
     */
    @RequestMapping("store")
    public Object store();
    //进入库房查询
    @RequestMapping("pharymacyhtml")
    public Object pharymaryhtml();
    //库房药品查询
    @RequestMapping("selectdurg")
    public Object selectdurg();
    //库房药品查询
    @RequestMapping("recycle")
    public Object recycle();


    //库房药品出库
    @RequestMapping("selectchuku")
    public int selectchuku() ;
    //进入药品日期报警
    @RequestMapping("seldrugDate")
    public int seldrugDate(@RequestBody Drugstore drugstore) ;
    //进入入库单页面
    @RequestMapping("beputinstorage")
    public Map<String,Object> beputinstorage();
    //进入药品报缺
    @RequestMapping("selectless")
    public Object selectless();
    //进入操作记录页面
    @RequestMapping("record")
    public  Object record();


    /**
     * ----------------------------------------------------------其他业务
     * @param maps
     * @return
     */
    @RequestMapping("insertDrugstore")
    public boolean insertDrugstore(@RequestParam Map<String,Object> maps);

    /**
     * 查询供货商
     * */
    @RequestMapping("selectUpplier")
    public List<Upplier> selectUpplier();
    /**
     * 查询经办人
     * */
    @RequestMapping("selectSkull")
    public List<Skull> selectSkull();

    /**
     * 查询仓库 WareHuose
     * */
    @RequestMapping("selectWareHuose")
    public List<Warehouse> selectWareHuose();

    @RequestMapping("selectDrugdictionary")
    public Map<String,Object> selectDrugdictionary(@RequestParam int limit,@RequestParam int page,@RequestParam String drugName);
    //查询此药品在仓库中还有多少
    @RequestMapping("selectNum")
    public int selectNum(@RequestParam String drugstoreName);
    //查询库房药品信息
    @RequestMapping("selectWareHuosePharmacy")
    public Map<String,Object> selectWareHuosePharmacy(@RequestParam String drugstoreName,@RequestParam int limit,@RequestParam int page);
    //修改仓库药品信息
    @RequestMapping("updateDrugstore")
    public Object updateDrugstore(@RequestParam Map<String,Object> map);
    /**
     * 查询药品类型
     * */
    @RequestMapping("selectType")
    public List<Type> selectType();

    /**
     * 查询产地
     * */
    @RequestMapping("selectArea")
    public List<Area> selectArea();

    @RequestMapping("selectUnit")
    public List<Unit> selectUnit();

    @RequestMapping("updateDrugstoreRk")
    public boolean updateDrugstoreRk(@RequestBody Drugstore drugstore);

    @RequestMapping("selectBaoque")
    public Map<String,Object> selectBaoque();

    @RequestMapping("selectByNameDrugstore")
    public Map<String,Object> selectByNameDrugstore(@RequestParam String name);
    //出库单开始
    @RequestMapping("updateDrugstoreCk")
    public boolean updateDrugstoreCk(@RequestParam Map<String,Object> map);

    @RequestMapping("addDrugstore")
    public boolean addDrugstore(@RequestParam Map<String,Object> map);
    //库存不足查询
    @RequestMapping("selectInsufficient")
    public Map<String,Object> selectInsufficient(@RequestParam int page,@RequestParam int limit);
    //过期提醒↓↓↓↓
    @RequestMapping("selectGuoQi")
    public Map<String,Object> selectGuoQi(@RequestParam int page,@RequestParam int limit);

    //删除过期的药品
    @RequestMapping("delGuoQi")
    public boolean delGuoQi(@RequestParam Map<String,Object> map);
    //查询全部操作记录
    @RequestMapping("selectJiLu")
    public Map<String,Object> selectJiLu(@RequestParam String type,@RequestParam int page,@RequestParam int limit);
    //查询所有回收药品
    @RequestMapping("selectHuiShou")
    public Map<String,Object> selectHuiShou(@RequestParam int page,@RequestParam int limit);

    //删除有问题回收的药品
    @RequestMapping("delHuiShou")
    public boolean delHuiShou(@RequestParam Map<String,Object> map);
    //end

    //查询药房信息
    @RequestMapping("selectPharmcay")
    public Map<String,Object> selectPharmcay(@RequestParam String pharmacyName,@RequestParam int page,@RequestParam int limit);
    //添加报缺信息
    @RequestMapping("addBaoQue")
    public boolean addBaoQue(@RequestParam Map<String,Object> map);

    //回收药品
    @RequestMapping("huiShou")
    public boolean huiShou(@RequestParam Map<String,Object> map,@RequestParam int pharmacyId);

}
