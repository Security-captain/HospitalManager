package com.cssl.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.cssl.pojo.Area;
import com.cssl.pojo.DrugDictionary;
import com.cssl.pojo.Type;
import com.cssl.pojo.Unit;
import com.cssl.service.AreaService;
import com.cssl.service.DrugDictionaryService;
import com.cssl.service.TypeService;
import com.cssl.service.UnitService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("drugdictionary")
public class DrugDictionaryController {

    @Autowired
    private DrugDictionaryService drugDictionaryService;
    @Autowired
    private AreaService areaService;
    @Autowired
    private TypeService typeService;
    @Autowired
    private UnitService unitService;

    @RequestMapping("findAlldrugdictionary")
    public Object drugdictionaryList(DrugDictionary drugDictionary, int page, int limit) {
        Map<String, Object> map = new HashMap<>();
        PageHelper.startPage(page, limit);
        PageInfo pageInfo = new PageInfo(drugDictionaryService.findAllDrugDictionary(drugDictionary));

        map.put("code", 0);
        map.put("msg", "");
        map.put("count", pageInfo.getTotal());
        map.put("data", pageInfo.getList());
        return map;
    }

    @RequestMapping("adddrugdictionary")
    public String adddrugdictionary(DrugDictionary drugDictionary) {
        int count = drugDictionaryService.count(new QueryWrapper<DrugDictionary>().eq("drugName", drugDictionary.getDrugName()));
        if (count == 0) {
            boolean i = drugDictionaryService.save(drugDictionary);
            if (i) {
                return "添加成功";
            } else {
                return "添加失败";
            }
        } else {
            return drugDictionary.getDrugName() + "已存在";
        }

    }

    @RequestMapping("editdrugdictionary")
    public String editdrugdictionary(DrugDictionary drugDictionary) {
        boolean i = drugDictionaryService.update(drugDictionary, new UpdateWrapper<DrugDictionary>().eq("drugId", drugDictionary.getDrugId()));
        if (i) {
            return "修改成功";
        } else {
            return "修改失败";
        }

    }

    @RequestMapping("deletedrugdictionary")
    public String deletedrugdictionary(Integer drugId) {
        boolean i = drugDictionaryService.remove(new UpdateWrapper<DrugDictionary>().eq("drugId", drugId));
        if (i) {
            return "删除成功";
        } else {
            return "删除失败";
        }
    }

    @RequestMapping("findAllArea")
    public Object findAllArea() {
        List<Area> allArea = areaService.list();
        return allArea;
    }

    @RequestMapping("findAllType")
    public Object findAllType() {
        List<Type> allType = typeService.list();
        return allType;
    }

    @RequestMapping("findAllUnit")
    public Object findAllUnit() {
        List<Unit> allUnit = unitService.list();
        return allUnit;
    }
}
