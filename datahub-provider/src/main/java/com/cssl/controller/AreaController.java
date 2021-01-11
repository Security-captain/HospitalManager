package com.cssl.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cssl.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cssl.pojo.Area;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("area")
public class AreaController {
    @Autowired
    private AreaService areaService;

    @RequestMapping("findAllArea")
    public Object AreaList(Area area, int page, int limit) {
        Map<String, Object> map = new HashMap<>();
        Page<Area> areaPage = new Page<>(page, limit);
        IPage<Area> iPage;
        if (area.getAreaName() != null) {
            iPage = areaService.page(areaPage, new QueryWrapper<Area>().like("areaName", area.getAreaName()));
        } else {
            iPage = areaService.page(areaPage);
        }
        map.put("code", 0);
        map.put("msg", "");
        map.put("count", iPage.getTotal());
        map.put("data", iPage.getRecords());
        return map;
    }

    @RequestMapping("addArea")
    public String addArea(Area area) {
        int count = areaService.count(new QueryWrapper<Area>().eq("areaName", area.getAreaName()));
        if (count == 0) {
            boolean i = areaService.save(area);
            if (i) {
                return "添加成功";
            } else {
                return "添加失败";
            }
        } else {
            return area.getAreaName() + "已存在";
        }

    }

    @RequestMapping("deleteArea")
    public String deleteArea(Integer areaId) {
        boolean i = areaService.remove(new UpdateWrapper<Area>().eq("areaId", areaId));
        if (i) {
            return "删除成功";
        } else {
            return "删除失败";
        }
    }
}
