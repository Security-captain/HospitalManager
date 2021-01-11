package com.cssl.client;

import com.cssl.pojo.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

//wyz   数据中心
@FeignClient(name = "datahub-provider")
public interface FeignDataHubClient {

    /**
     * FeignAreaClient
     * @param area
     * @param page
     * @param limit
     * @return
     */
    @RequestMapping("/area/findAllArea")
    Object AreaList(@SpringQueryMap Area area, @RequestParam int page, @RequestParam int limit);
    @RequestMapping("/area/addArea")
    String addArea(@SpringQueryMap Area area);
    @RequestMapping("/area/deleteArea")
    String deleteArea(@RequestParam Integer areaId);

    /**
     * FeignDepartmentsClient
     * @param departments
     * @param page
     * @param limit
     * @return
     */
    @RequestMapping("/department/departmentList")
    Object departmentList(@SpringQueryMap Departments departments, @RequestParam int page, @RequestParam int limit);
    @RequestMapping("/department/addDepartment")
    String addDepartment(@SpringQueryMap Departments departments);
    @RequestMapping("/department/deleteDepartment")
    String deleteDepartment(@RequestParam Integer departmentId);

    /**
     * FeignDoctorClient
     * @param doctor
     * @param page
     * @param limit
     * @return
     */
    @RequestMapping("/doctor/doctorList")
    Object doctorList(@SpringQueryMap Doctor doctor, @RequestParam int page, @RequestParam int limit);
    @RequestMapping("/doctor/addDoctor")
    String addDoctor(@SpringQueryMap Doctor doctor, @SpringQueryMap PaiBan paiban);
    @RequestMapping("/doctor/editDoctor")
    String editDoctor(@SpringQueryMap Doctor doctor);
    @RequestMapping("/doctor/deleteDoctor")
    String deleteDoctor(@RequestParam Integer doctorId);
    @RequestMapping("/doctor/findAllDepartments")
    Object findAllDepartments();
    @RequestMapping("/doctor/findAllRegisteredtype")
    Object findAllRegisteredtype();

    /**
     * FeignDerugDictionaryClient
     * @param drugDictionary
     * @param page
     * @param limit
     * @return
     */
    @RequestMapping("/drugdictionary/findAlldrugdictionary")
    Object drugdictionaryList(@SpringQueryMap DrugDictionary drugDictionary, @RequestParam int page, @RequestParam int limit);
    @RequestMapping("/drugdictionary/adddrugdictionary")
    String adddrugdictionary(@SpringQueryMap DrugDictionary drugDictionary);
    @RequestMapping("/drugdictionary/editdrugdictionary")
    String editdrugdictionary(@SpringQueryMap DrugDictionary drugDictionary);
    @RequestMapping("/drugdictionary/deletedrugdictionary")
    String deletedrugdictionary(@RequestParam Integer drugId);
    @RequestMapping("/drugdictionary/findAllArea")
    Object findAllArea();
    @RequestMapping("/drugdictionary/findAllType")
    Object findAllType();
    @RequestMapping("/drugdictionary/findAllUnit")
    Object findAllUnit();

    /**
     * FeignProjectTypeClient
     * @param projecttype
     * @param page
     * @param limit
     * @return
     */
    @RequestMapping("/prjectType/findAllProjecttype")
    Object ProjecttypeList(@SpringQueryMap ProjectType projecttype, @RequestParam Integer page, @RequestParam Integer limit);
    @RequestMapping("/prjectType/addProjecttype")
    String addProjecttype(@SpringQueryMap ProjectType projecttype);
    @RequestMapping("/prjectType/deleteProjecttype")
    String deleteProjecttype(@RequestParam Integer projectId);
    @RequestMapping("/prjectType/findAllMoneytype")
    Object MoneytypeList(@SpringQueryMap MoneyType moneytype, @RequestParam Integer page, @RequestParam Integer limit);
    @RequestMapping("/prjectType/addMoneytype")
    String addMoneytype(@SpringQueryMap MoneyType moneytype);
    @RequestMapping("/prjectType/editMoneytype")
    String editMoneytype(@SpringQueryMap MoneyType moneytype);
    @RequestMapping("/prjectType/deleteMoneytype")
    String deleteMoneytype(@RequestParam Integer moneyId);
    @RequestMapping("/prjectType/findAllOutpatienttype")
    Object OutpatienttypeList(@SpringQueryMap OutpatientType outpatienttype, @RequestParam Integer page, @RequestParam Integer limit);
    @RequestMapping("/prjectType/findAllUnit")
    Object UnitList();
    @RequestMapping("/prjectType/findAllProjecttype1")
    Object ProjecttypeList();
    @RequestMapping("/prjectType/addOutpatienttype")
    String addOutpatienttype(@SpringQueryMap OutpatientType outpatienttype, @RequestParam Integer projectId, @RequestParam Integer unitId);
    @RequestMapping("/prjectType/editOutpatienttype")
    String editOutpatienttype(@SpringQueryMap OutpatientType outpatienttype, @RequestParam Integer projectId, @RequestParam Integer unitId);
    @RequestMapping("/prjectType/deleteOutpatienttype")
    String deleteOutpatienttype(@RequestParam Integer outpatientId);
    @RequestMapping("/prjectType/findAllInoutpatienttype")
    Object InoutpatienttypeList(@SpringQueryMap InOutpatientType inoutpatienttype, @RequestParam Integer page, @RequestParam Integer limit);
    @RequestMapping("/prjectType/findAllUnit1")
    Object findAllUnit1();
    @RequestMapping("/prjectType/findAllProjecttype2")
    Object findAllProjecttype2();
    @RequestMapping("/prjectType/addInoutpatienttype")
    String addInoutpatienttype(@SpringQueryMap InOutpatientType inoutpatienttype, @RequestParam Integer projectId, @RequestParam Integer unitId);
    @RequestMapping("/prjectType/editInoutpatienttype")
    String editInoutpatienttype(@SpringQueryMap InOutpatientType inoutpatienttype, @RequestParam Integer projectId, @RequestParam Integer unitId);
    @RequestMapping("/prjectType/deleteInoutpatienttype")
    String deleteInoutpatienttype(@RequestParam Integer inoutpatientId);
    @RequestMapping("/prjectType/findAllBed")
    Object BedList(@SpringQueryMap Bed bed, @RequestParam Integer page, @RequestParam Integer limit);
    @RequestMapping("/prjectType/addBed")
    String addBed(@SpringQueryMap Bed bed);
    @RequestMapping("/prjectType/editBed")
    String editBed(@SpringQueryMap Bed bed);
    @RequestMapping("/prjectType/deleteBed")
    String deleteBed(@RequestParam Integer bedId);
    @RequestMapping("/prjectType/departmentList")
    Object DepartmentList();

    /**
     * FeignRegisteredTypeClient
     * @param registeredtype
     * @param page
     * @param limit
     * @return
     */
    @RequestMapping("/registeredType/registeredTypeList")
    Object registeredTypeList(@SpringQueryMap RegisteredType registeredtype, @RequestParam int page, @RequestParam int limit);
    @RequestMapping("/registeredType/addRegisteredType")
    String addRegisteredType(@SpringQueryMap RegisteredType registeredtype);
    @RequestMapping("/registeredType/editRegisteredType")
    String editRegisteredType(@SpringQueryMap RegisteredType registeredtype);
    @RequestMapping("/registeredType/deleteRType")          //改名为registeredRType
    String deleteRType(@RequestParam Integer registeredId);

    /**
     * FeignSkullClient
     * @param skull
     * @param page
     * @param limit
     * @return
     */
    @RequestMapping("/skull/findAllSkull")
    Object SkullList(@SpringQueryMap Skull skull, @RequestParam int page, @RequestParam int limit);
    @RequestMapping("/skull/addSkull")
    String addSkull(@SpringQueryMap Skull skull);
    @RequestMapping("/skull/editSkull")
    String editSkull(@SpringQueryMap Skull skull);
    @RequestMapping("/skull/deleteSkull")
    String deleteSkull(@RequestParam Integer skullId);

    /**
     * FeignTypeClient
     * @param type
     * @param page
     * @param limit
     * @return
     */
    @RequestMapping("/type/findAllType")
    Object TypeList(@SpringQueryMap Type type, @RequestParam int page, @RequestParam int limit);
    @RequestMapping("/type/addType")
    String addType(@SpringQueryMap Type type);
    @RequestMapping("/type/deleteType")         //与FeignRegisteredTypeClient的方法冲突
    String deleteType(@RequestParam Integer typeId);

    /**
     * FeignUnitClient
     * @param unit
     * @param page
     * @param limit
     * @return
     */
    @RequestMapping("/unit/findAllUnit")
    Object UnitList(@SpringQueryMap Unit unit, @RequestParam int page, @RequestParam int limit);
    @RequestMapping("/unit/addUnit")
    String addUnit(@SpringQueryMap Unit unit);
    @RequestMapping("/unit/deleteUnit")
    String deleteUnit(@RequestParam Integer unitId);

    /**
     * FeignUpplierClient
     * @param upplier
     * @param page
     * @param limit
     * @return
     */
    @RequestMapping("/upplier/findAllUpplier")
    Object UpplierList(@SpringQueryMap Upplier upplier, @RequestParam int page, @RequestParam int limit);
    @RequestMapping("/upplier/addUpplier")
    String addUpplier(@SpringQueryMap Upplier upplier);
    @RequestMapping("/upplier/deleteUpplier")
    String deleteUpplier(@RequestParam Integer supplierId);

    /**
     * FeignWarehouseClient
     * @param warehouse
     * @param page
     * @param limit
     * @return
     */
    @RequestMapping("/warehouse/findAllWarehuose")
    Object WarehuoseList(@SpringQueryMap Warehouse warehouse, @RequestParam int page, @RequestParam int limit);
    @RequestMapping("/warehouse/addWarehuose")
    String addWarehuose(@SpringQueryMap Warehouse warehouse);
    @RequestMapping("/warehouse/deleteArea")
    String deleteWarehuose(@RequestParam Integer warehouseId);


}
