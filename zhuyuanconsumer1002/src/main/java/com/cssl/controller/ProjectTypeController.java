package com.cssl.controller;

import com.cssl.client.FeignDataHubClient;
import com.cssl.pojo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//wyz       项目大类
@RestController
@RequestMapping("prjectType")
public class ProjectTypeController {

    @Autowired
    private FeignDataHubClient feignDataHubClient;

    @RequestMapping("findAllProjecttype")
    public Object ProjecttypeList(ProjectType projecttype, Integer page, Integer limit) {
        return feignDataHubClient.ProjecttypeList(projecttype, page, limit);
    }

    @RequestMapping("addProjecttype")
    public String addProjecttype(ProjectType projecttype) {
        return feignDataHubClient.addProjecttype(projecttype);

    }

    @RequestMapping("deleteProjecttype")
    @ResponseBody
    public String deleteProjecttype(Integer projectId) {
        return feignDataHubClient.deleteProjecttype(projectId);
    }

    @RequestMapping("findAllMoneytype")
    public Object MoneytypeList(MoneyType moneytype, Integer page, Integer limit) {
        return feignDataHubClient.MoneytypeList(moneytype, page, limit);
    }

    @RequestMapping("addMoneytype")
    @ResponseBody
    public String addMoneytype(MoneyType moneytype) {
        return feignDataHubClient.addMoneytype(moneytype);

    }

    @RequestMapping("editMoneytype")
    @ResponseBody
    public String editMoneytype(MoneyType moneytype) {
        return feignDataHubClient.editMoneytype(moneytype);

    }

    @RequestMapping("deleteMoneytype")
    @ResponseBody
    public String deleteMoneytype(Integer moneyId) {
        return feignDataHubClient.deleteMoneytype(moneyId);
    }

    @RequestMapping("findAllOutpatienttype")
    public Object OutpatienttypeList(OutpatientType outpatienttype, Integer page, Integer limit) {
        return feignDataHubClient.OutpatienttypeList(outpatienttype, page, limit);
    }

    @RequestMapping("findAllUnit")
    public Object UnitList() {
        return feignDataHubClient.UnitList();
    }

    @RequestMapping("findAllProjecttype1")
    public Object ProjecttypeList() {
        return feignDataHubClient.ProjecttypeList();
    }

    @RequestMapping("addOutpatienttype")
    @ResponseBody
    public String addOutpatienttype(OutpatientType outpatienttype, Integer projectId, Integer unitId) {
        return feignDataHubClient.addOutpatienttype(outpatienttype, projectId, unitId);

    }

    @RequestMapping("editOutpatienttype")
    @ResponseBody
    public String editOutpatienttype(OutpatientType outpatienttype, Integer projectId, Integer unitId) {
        return feignDataHubClient.editOutpatienttype(outpatienttype, projectId, unitId);
    }

    @RequestMapping("deleteOutpatienttype")
    @ResponseBody
    public String deleteOutpatienttype(Integer outpatientId) {
        return feignDataHubClient.deleteOutpatienttype(outpatientId);
    }

    @RequestMapping("findAllInoutpatienttype")
    public Object InoutpatienttypeList(InOutpatientType inoutpatienttype, Integer page, Integer limit) {
        return feignDataHubClient.InoutpatienttypeList(inoutpatienttype, page, limit);
    }

    @RequestMapping("findAllUnit1")
    public Object findAllUnit1() {
        return feignDataHubClient.findAllUnit1();
    }

    @RequestMapping("findAllProjecttype2")
    public Object findAllProjecttype2() {
        return feignDataHubClient.findAllProjecttype2();
    }

    @RequestMapping("addInoutpatienttype")
    @ResponseBody
    public String addInoutpatienttype(InOutpatientType inoutpatienttype, Integer projectId, Integer unitId) {
        return feignDataHubClient.addInoutpatienttype(inoutpatienttype, projectId, unitId);

    }

    @RequestMapping("editInoutpatienttype")
    @ResponseBody
    public String editInoutpatienttype(InOutpatientType inoutpatienttype, Integer projectId, Integer unitId) {
        return feignDataHubClient.editInoutpatienttype(inoutpatienttype, projectId, unitId);

    }

    @RequestMapping("deleteInoutpatienttype")
    @ResponseBody
    public String deleteInoutpatienttype(Integer inoutpatientId) {
        return feignDataHubClient.deleteInoutpatienttype(inoutpatientId);
    }

    @RequestMapping("findAllBed")
    public Object BedList(Bed bed, Integer page, Integer limit) {
        return feignDataHubClient.BedList(bed, page, limit);
    }

    @RequestMapping("addBed")
    @ResponseBody
    public String addBed(Bed bed) {
        return feignDataHubClient.addBed(bed);

    }

    @RequestMapping("editBed")
    @ResponseBody
    public String editBed(Bed bed) {
        return feignDataHubClient.editBed(bed);
    }

    @RequestMapping("deleteBed")
    @ResponseBody
    public String deleteBed(Integer bedId) {
        return feignDataHubClient.deleteBed(bedId);

    }

    @RequestMapping("departmentList")
    public Object DepartmentList() {
        return feignDataHubClient.DepartmentList();
    }
}
