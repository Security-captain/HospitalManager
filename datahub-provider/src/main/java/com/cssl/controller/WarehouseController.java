package com.cssl.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cssl.pojo.Warehouse;
import com.cssl.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("warehouse")
public class WarehouseController {
    @Autowired
    private WarehouseService warehouseService;

    @RequestMapping("findAllWarehuose")
    public Object WarehuoseList(Warehouse warehouse, int page, int limit) {
        Map<String, Object> map = new HashMap<>();
        Page<Warehouse> warehousePage = new Page<>(page, limit);
        IPage<Warehouse> iPage;
        if (warehouse.getSupplierName() != null) {
            iPage = warehouseService.page(warehousePage, new QueryWrapper<Warehouse>().like("supplierName", warehouse.getSupplierName()));
        } else {
            iPage = warehouseService.page(warehousePage);
        }
        map.put("code", 0);
        map.put("msg", "");
        map.put("count", iPage.getTotal());
        map.put("data", iPage.getRecords());
        return map;
    }

    @RequestMapping("addWarehuose")
    public String addWarehuose(Warehouse warehouse) {
        int count = warehouseService.count(new QueryWrapper<Warehouse>().eq("supplierName", warehouse.getSupplierName()));
        if (count == 0) {
            boolean i = warehouseService.save(warehouse);
            if (i) {
                return "添加成功";
            } else {
                return "添加失败";
            }
        } else {
            return warehouse.getSupplierName() + "已存在";
        }

    }

    @RequestMapping("deleteWarehuose")
    public String deleteWarehuose(Integer warehouseId) {
        boolean i = warehouseService.remove(new UpdateWrapper<Warehouse>().eq("warehouseId", warehouseId));
        if (i) {
            return "删除成功";
        } else {
            return "删除失败";
        }
    }
}
