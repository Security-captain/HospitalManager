package com.zy.controller;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cssl.pojo.*;
import com.zy.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 仓库管理接口！      zzy
 * */
@RestController
public class StoreController {

    @Autowired
    private DrugDictionaryService ds;

    @Autowired
    private DrugstoreService storeService;

    @Autowired
    private HuiShouService huiShouService;

    @Autowired
    private JiLuService jiLuService;

    @Autowired
    private PharmacyService pharmacyService;

    @Autowired
    private SkullService skullService;

    @Autowired
    private UnitService unitService;

    @Autowired
    private UpplierService upplierService;

    @Autowired
    private WareHuoseService wareHuoseService;

    @Autowired
    private TypeService typeService;

    @Autowired
    private AreaService areaService;

    @Autowired
    private BaoqueService baoqueService;

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

    /**
     * 添加药品到药品仓库
     * */
    @RequestMapping("insertDrugstore")
    public boolean insertDrugstore(@RequestParam Map<String,Object> maps){
        Date now = new Date();
        String NowTime = sdf.format(now);
        Jilu jilu = JSON.parseObject(JSON.toJSONString(maps),Jilu.class); // 将map中jilu的属性存放到实体中
        Drugstore store = JSON.parseObject(JSON.toJSONString(maps),Drugstore.class);
        //jilu.setJilutime();(NowTime); // 设置记录表的记录时间，为当前系统时间
        jilu.setJilutime(NowTime);
        //查询仓库中是否有此药品，并且是否是同批号的，如果有则修改数量，时间，没有则新增
        int ifStore = storeService.count(new QueryWrapper<Drugstore>()
                    .eq("drugstoreName",store.getDrugstoreName())
                    .eq("batch",store.getBatch()));
        boolean add = false;
        boolean up = false;
        if (ifStore > 0 ){
            int num = storeService.updateDrugstore(store.getDrugstoreName(),store.getBatch());
            jiLuService.save(jilu);
            if (num >0)
                up = true;
            return up;
        }else {
            add = storeService.save(store);
            jiLuService.save(jilu);
            return add;
        }
    }

    /**
     * 查询供货商
     * */
    @RequestMapping("selectUpplier")
    public List<Upplier> selectUpplier(){

        return upplierService.list();
    }

    /**
     * 查询经办人
     * */
    @RequestMapping("selectSkull")
    public List<Skull> selectSkull(){

        return skullService.list();
    }

    /**
     * 查询仓库 WareHuose
     * */
    @RequestMapping("selectWareHuose")
    public List<Warehouse> selectWareHuose(){

        return wareHuoseService.list();
    }

    @RequestMapping("selectDrugdictionary")
    public Map<String,Object> selectDrugdictionary(@RequestParam int limit,@RequestParam int page,@RequestParam String drugName){

        Map<String,Object> map = new HashMap<>();
        List<Map<String,Object>> list = ds.selectDrugDictionary(drugName);
        //这是layui要求返回的json数据格式
        map.put("code", 0);
        map.put("msg", "");
        //将全部数据的条数作为count传给前台（一共多少条）
        map.put("count", list.size());
        map.put("data", list);

        return map;
    }

    //查询此药品在仓库中还有多少
    @RequestMapping("selectNum")
    public int selectNum(@RequestParam String drugstoreName){
        return storeService.selectNum(drugstoreName);
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
    public Map<String,Object> selectWareHuosePharmacy(@RequestParam String drugstoreName,@RequestParam int limit,@RequestParam int page){

        Map<String,Object> map = new HashMap<>();

        List<Map<String,Object>> list = wareHuoseService.selectWareHuosePharmacy(drugstoreName);
        map.put("data",list);
        map.put("code",0);
        map.put("msg","");
        map.put("count",list.size());

        return map;
    }

    //修改仓库药品信息
    @RequestMapping("updateDrugstore")
    public Object updateDrugstore(@RequestParam Map<String,Object> map){
        System.out.println("123123123");
        String areaId = (String) map.get("areaId");
        String typeId = (String) map.get("typeId");
        Drugstore store = JSON.parseObject(JSON.toJSONString(map),Drugstore.class);
        store.setArea(Integer.parseInt(areaId));
        store.setType(Integer.parseInt(typeId));
        System.out.println(store.toString());
        return storeService.updrugstore(store);
    }


    /**
     * 查询药品类型
     * */
    @RequestMapping("selectType")
    public List<Type> selectType(){

        return typeService.list();
    }

    /**
     * 查询产地
     * */
    @RequestMapping("selectArea")
    public List<Area> selectArea(){
        return areaService.list();
    }

    @RequestMapping("selectUnit")
    public List<Unit> selectUnit(){
        return unitService.list();
    }

    @RequestMapping("updateDrugstoreRk")
    public boolean updateDrugstoreRk(@RequestBody Drugstore drugstore){

        Drugstore temp = storeService.getById(drugstore.getRugstoreId());
        drugstore.setUnit(temp.getUnit());
        drugstore.setSkullId(temp.getSkullId());
        drugstore.setProduceDate(temp.getProduceDate());
        drugstore.setValidDate(temp.getValidDate());
        drugstore.setWarehouseId(temp.getWarehouseId());
        return storeService.update(drugstore,new QueryWrapper<Drugstore>().eq("rugstoreId",drugstore.getRugstoreId()));
    }

    @RequestMapping("selectBaoque")
    public Map<String,Object> selectBaoque(){
        Map<String,Object> map = new HashMap<>();
        List<Baoque> list = baoqueService.list();

        map.put("data",list);
        map.put("code",0);
        map.put("msg","");
        map.put("count",list.size());

        return map;
    }

    @RequestMapping("selectByNameDrugstore")
    public Map<String,Object> selectByNameDrugstore(@RequestParam String name){
        Map<String,Object> map = new HashMap<>();

        List<Drugstore> list = storeService.list(new QueryWrapper<Drugstore>().eq("drugstoreName",name));
        map.put("data",list);
        map.put("code",0);
        map.put("count",list.size());
        map.put("msg","");

        return map;
    }

    //出库单开始
    @RequestMapping("updateDrugstoreCk")
    public boolean updateDrugstoreCk(@RequestParam Map<String,Object> map){

        Drugstore drugstore = JSON.parseObject(JSON.toJSONString(map),Drugstore.class);
        Jilu jilu = JSON.parseObject(JSON.toJSONString(map),Jilu.class);
        Drugstore store = storeService.getById(drugstore.getRugstoreId());
        Baoque baoQue = baoqueService.getOne(new QueryWrapper<Baoque>().eq("baoqueName",drugstore.getDrugstoreName()));
        int bjNum = drugstore.getDrugstorenum();
        System.out.println("bjNum = "+bjNum);
        if (store.getDrugstorenum() >= bjNum){ // 查询补给数量是否超过仓库的存储
            store.setDrugstorenum(store.getDrugstorenum()- bjNum);
            if (store.getDrugstorenum() == 0){ // 判断如果仓库的此记录药品库存没有了则删除,否则更改数量
                storeService.removeById(store);
            }else{
                storeService.updateById(store);
            }

            int num = baoQue.getBaoqueNum() - bjNum;

            if (num<=0){ // 如果补给超过需求或者正好，则将此报缺记录删除
                baoqueService.removeById(baoQue.getBaoqueid());
            }else { // 否则更新此报缺记录
                baoQue.setBaoqueNum(num);
                baoqueService.updateById(baoQue);
            }

            //添加一条记录到记录表中
            Date now = new Date();
            String NowTime = sdf.format(now);
//            jilu.setJilutime();(NowTime);
            jilu.setJilutime(NowTime);
            jiLuService.save(jilu);

            //将补给的药品数量添加到药房去
            Pharmacy p = pharmacyService.getOne(new QueryWrapper<Pharmacy>().eq("pharmacyName",store.getDrugstoreName()));
            p.setDrugstoreNum(p.getDrugstoreNum()+bjNum);
            boolean f3 = pharmacyService.updateById(p);

            if (f3){
                return true;
            }
        }
        return false;
    }

    @RequestMapping("addDrugstore")
    public boolean addDrugstore(@RequestParam Map<String,Object> map){

        Drugstore drugstore = JSON.parseObject(JSON.toJSONString(map),Drugstore.class);
        Jilu jilu = JSON.parseObject(JSON.toJSONString(map),Jilu.class);
        Pharmacy pharmacy = JSON.parseObject(JSON.toJSONString(map),Pharmacy.class);
        Drugstore store = storeService.getById(drugstore.getRugstoreId());
        int bjNum = drugstore.getDrugstorenum();
        if (store.getDrugstorenum() >= bjNum){ // 查询补给数量是否超过仓库的存储
            store.setDrugstorenum(store.getDrugstorenum()- bjNum);
            if (store.getDrugstorenum() == 0){
                storeService.removeById(store.getRugstoreId());
            }else {
                storeService.updateById(store);
            }

            Pharmacy p = pharmacyService.getOne(new QueryWrapper<Pharmacy>().eq("pharmacyName",pharmacy.getPharmacyName()));
            if (p.getPharmacyName() != null && p.getPharmacyName() != ""){
                //p.getPharmacyName()       ----p.getPharmacyName()()
                p.setDrugstoreNum(p.getDrugstoreNum() + bjNum); // 更改药房药品数量
                pharmacyService.updateById(p);
                int count = baoqueService.count(new QueryWrapper<Baoque>().eq("baoqueName",p.getPharmacyName()));
                if (count > 0){ // 如果右边出库时左边的报缺有同样的药品时，将报缺的数据更改或删除
                    Baoque b = baoqueService.getOne(new QueryWrapper<Baoque>().eq("baoqueName",p.getPharmacyName()));
                    if (b.getBaoqueNum() == bjNum){
                        baoqueService.removeById(b.getBaoqueid());
                    }else {
                        b.setBaoqueNum(b.getBaoqueNum() - bjNum);
                        baoqueService.updateById(b);
                    }
                }
            }else {
                pharmacyService.save(pharmacy);
            }

            Date now = new Date();
            String NowTime = sdf.format(now);
            //jilu.setJilutime();(NowTime);
            jilu.setJilutime(NowTime);
            jiLuService.save(jilu);

            return true;
        }

        return false;
    }
    //出库单结束

    //库存不足查询
    @RequestMapping("selectInsufficient")
    public Map<String,Object> selectInsufficient(@RequestParam int page,@RequestParam int limit){

        Map<String,Object> map = new HashMap<>();

        List<Map<String,Object>> list = storeService.selectInsufficient(page,limit);
        map.put("data",list);
        map.put("code",0);
        map.put("msg","");
        map.put("count",list.size());

        return map;
    }
    //end

    //过期提醒↓↓↓↓
    @RequestMapping("selectGuoQi")
    public Map<String,Object> selectGuoQi(@RequestParam int page,@RequestParam int limit){

        Map<String,Object> map = new HashMap<>();
        page = (page-1)*limit;
        List<Map<String,Object>> list = storeService.selectGuoQi(page,limit);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date now = new Date();
        String NowTime = sdf.format(now);
        int coutn = storeService.count(new QueryWrapper<Drugstore>().lt("validDate",NowTime));
        map.put("data",list);
        map.put("code",0);
        map.put("msg","");
        map.put("count",coutn);
        return map;
    }

    //删除过期的药品
    @RequestMapping("delGuoQi")
    public boolean delGuoQi(@RequestParam Map<String,Object> map){
        String id = (String)map.get("rugstoreId");
        Jilu jilu = JSON.parseObject(JSON.toJSONString(map),Jilu.class);
        storeService.removeById(id);
        Date now = new Date();
        String NowTime = sdf.format(now);
        huiShouService.removeById(id);
        //jilu.setJilutime();(NowTime);
        jilu.setJilutime(NowTime);
        return jiLuService.save(jilu);
    }

    //end

    //查询全部操作记录
    @RequestMapping("selectJiLu")
    public Map<String,Object> selectJiLu(@RequestParam String type,@RequestParam int page,@RequestParam int limit){

        Map<String,Object> map = new HashMap<>();
        IPage<Jilu> ipage = jiLuService.page(
                new Page<Jilu>(page,limit),
                new QueryWrapper<Jilu>().like((!type.equals("q")),"jilutype",type.isEmpty())
                .orderByDesc("jiluid"));
        List<Jilu> list = ipage.getRecords();
        map.put("data",list);
        map.put("code",0);
        map.put("msg","");
        map.put("count",ipage.getTotal());
        return map;
    }
    //end

    //查询所有回收药品
    @RequestMapping("selectHuiShou")
    public Map<String,Object> selectHuiShou(@RequestParam int page,@RequestParam int limit){
        Map<String,Object> map = new HashMap<>();
        IPage<Huishou> ipage = huiShouService.page(new Page<Huishou>(page,limit));
        List<Huishou> list = ipage.getRecords();
        map.put("data",list);
        map.put("code",0);
        map.put("msg","");
        map.put("count",ipage.getTotal());
        return map;
    }

    //删除有问题回收的药品
    @RequestMapping("delHuiShou")
    public boolean delHuiShou(@RequestParam Map<String,Object> map){
        Jilu jilu = JSON.parseObject(JSON.toJSONString(map), Jilu.class);
        String id = (String)map.get("huishouid");
        Date now = new Date();
        String NowTime = sdf.format(now);
        huiShouService.removeById(id);
        //jilu.setJilutime();(NowTime);
        jilu.setJilutime(NowTime);
        return jiLuService.save(jilu);
    }
    //end

    //查询药房信息
    @RequestMapping("selectPharmcay")
    public Map<String,Object> selectPharmcay(@RequestParam String pharmacyName,@RequestParam int page,@RequestParam int limit){
        Map<String,Object> map = new HashMap<>();
        page = (page-1)*limit;
        List<Map<String,Object>> list = pharmacyService.selectPharmacy(pharmacyName,page,limit);
        int count = pharmacyService.count();
        map.put("data",list);
        map.put("code",0);
        map.put("msg","");
        map.put("count",count);
        return map;
    }

    //添加报缺信息
    @RequestMapping("addBaoQue")
    public boolean addBaoQue(@RequestParam Map<String,Object> map){
        Baoque baoQue = JSON.parseObject(JSON.toJSONString(map),Baoque.class);
        int count = baoqueService.count(new QueryWrapper<Baoque>().eq("baoqueName",baoQue.getBaoqueName()));

        if (count > 0){ // 查询报缺表中是否存在该药品，如果有则修改，没有就添加
            Baoque b = baoqueService.getOne(new QueryWrapper<Baoque>().eq("baoqueName",baoQue.getBaoqueName()));
            b.setBaoqueNum(b.getBaoqueNum()+baoQue.getBaoqueNum());
            return baoqueService.updateById(b);
        }

        return baoqueService.save(baoQue);
    }

    //回收药品
    @RequestMapping("huiShou")
    public boolean huiShou(@RequestParam Map<String,Object> map,@RequestParam int pharmacyId){

        Huishou huishou = JSON.parseObject(JSON.toJSONString(map),Huishou.class);
        //删除被回收的药品信息
        pharmacyService.removeById(pharmacyId);

        // 添加回收表
        return huiShouService.save(huishou);
    }


}
