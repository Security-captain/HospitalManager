package com.cssl.controller;

import com.cssl.client.FeignDataHubClient;
import com.cssl.pojo.Unit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//wyz       计量单位
@RestController
@RequestMapping("unit")
public class UnitController {

    @Autowired
    private FeignDataHubClient feignDataHubClient;

    @RequestMapping("findAllUnit")
    public Object UnitList(Unit unit, int page, int limit) {
        return feignDataHubClient.UnitList(unit, page, limit);
    }

    @RequestMapping("addUnit")
    @ResponseBody
    public String addUnit(Unit unit) {
        return feignDataHubClient.addUnit(unit);
    }

    @RequestMapping("deleteUnit")
    @ResponseBody
    public String deleteUnit(Integer unitId) {
        return feignDataHubClient.deleteUnit(unitId);
    }
}
