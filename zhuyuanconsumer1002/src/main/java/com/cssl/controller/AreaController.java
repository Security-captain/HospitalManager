package com.cssl.controller;

import com.cssl.client.FeignDataHubClient;
import com.cssl.pojo.Area;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//wyz       产地
@RestController
@RequestMapping("area")
public class AreaController {
    @Autowired
    private FeignDataHubClient feignDataHubClient;

    @RequestMapping("findAllArea")
    public Object AreaList(Area area, int page, int limit) {
        return feignDataHubClient.AreaList(area, page, limit);
    }

    @RequestMapping("addArea")
    public String addArea(Area area) {
        return feignDataHubClient.addArea(area);
    }

    @RequestMapping("deleteArea")
    public String deleteArea(Integer areaId) {
        return feignDataHubClient.deleteArea(areaId);
    }
}
