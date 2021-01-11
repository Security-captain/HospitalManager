package com.cssl.controller;

import com.cssl.client.FeignDataHubClient;
import com.cssl.pojo.Warehouse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//wyz       仓库
@RestController
@RequestMapping("warehouse")
public class WarehouseController {
    @Autowired
    private FeignDataHubClient feignDataHubClient;

    @RequestMapping("findAllWarehuose")
    public Object WarehuoseList(Warehouse warehouse, int page, int limit) {
        return feignDataHubClient.WarehuoseList(warehouse, page, limit);
    }

    @RequestMapping("addWarehuose")
    @ResponseBody
    public String addWarehuose(Warehouse warehouse) {
        return feignDataHubClient.addWarehuose(warehouse);
    }

    @RequestMapping("deleteWarehuose")
    @ResponseBody
    public String deleteWarehuose(Integer warehouseId) {
        return feignDataHubClient.deleteWarehuose(warehouseId);
    }
}
