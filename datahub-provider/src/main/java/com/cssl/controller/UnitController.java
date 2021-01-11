package com.cssl.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cssl.pojo.Unit;
import com.cssl.service.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("unit")
public class UnitController {

    @Autowired
    private UnitService unitService;

    @RequestMapping("findAllUnit")
    public Object UnitList(Unit unit, int page, int limit) {
        Map<String, Object> map = new HashMap<>();
        Page<Unit> unitPage = new Page<>(page, limit);
        IPage<Unit> iPage;
        if (unit.getUnitName() != null && unit.getUnitName() != "") {
            iPage = unitService.page(unitPage, new QueryWrapper<Unit>().like("unitName", unit.getUnitName()).orderByDesc("unitid"));
        } else {
            iPage = unitService.page(unitPage, new QueryWrapper<Unit>().orderByDesc("unitid"));
        }

        map.put("code", 0);
        map.put("msg", "");
        map.put("count", iPage.getTotal());
        map.put("data", iPage.getRecords());
        return map;
    }

    @RequestMapping("addUnit")
    public String addUnit(Unit unit) {
        int count = unitService.count(new QueryWrapper<Unit>().eq("unitName", unit.getUnitName()));
        if (count == 0) {
            boolean i = unitService.save(unit);
            if (i) {
                return "添加成功";
            } else {
                return "添加失败";
            }
        } else {
            return unit.getUnitName() + "已存在";
        }

    }

    @RequestMapping("deleteUnit")
    public String deleteUnit(Integer unitId) {
        boolean i = unitService.remove(new UpdateWrapper<Unit>().eq("unitId", unitId));
        if (i) {
            return "删除成功";
        } else {
            return "删除失败";
        }
    }
}
