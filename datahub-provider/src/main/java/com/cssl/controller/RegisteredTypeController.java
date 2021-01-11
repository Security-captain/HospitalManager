package com.cssl.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cssl.pojo.RegisteredType;
import com.cssl.service.RegisteredTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("registeredType")
public class RegisteredTypeController {
    @Autowired
    private RegisteredTypeService registeredTypeService;

    @RequestMapping("registeredTypeList")
    public Object registeredTypeList(RegisteredType registeredtype, int page, int limit) {
        Map<String, Object> map = new HashMap<>();
        Page<RegisteredType> registeredtypePage = new Page<>(page, limit);
        IPage<RegisteredType> iPage;
        if (registeredtype.getType() != null) {
            iPage = registeredTypeService.page(registeredtypePage, new QueryWrapper<RegisteredType>().like("type", registeredtype.getType()));
        } else {
            iPage = registeredTypeService.page(registeredtypePage);
        }

        map.put("code", 0);
        map.put("msg", "");
        map.put("count", iPage.getTotal());
        map.put("data", iPage.getRecords());
        return map;
    }

    @RequestMapping("addRegisteredType")
    public String addRegisteredType(RegisteredType registeredtype) {
        int count = registeredTypeService.count(new QueryWrapper<RegisteredType>().eq("type", registeredtype.getType()));
        if (count == 0) {
            boolean i = registeredTypeService.save(registeredtype);
            if (i) {
                return "添加成功";
            } else {
                return "添加失败";
            }
        } else {
            return registeredtype.getType() + "已存在";
        }

    }


    @RequestMapping("editRegisteredType")
    public String editRegisteredType(RegisteredType registeredtype) {
        boolean i = registeredTypeService.update(registeredtype, new UpdateWrapper<RegisteredType>().eq("registeredId", registeredtype.getRegisteredId()));
        if (i) {
            return "修改成功";
        } else {
            return "修改失败";
        }

    }

    //改名了
    @RequestMapping("deleteRType")
    public String deleteRType(Integer registeredId) {
        boolean i = registeredTypeService.remove(new UpdateWrapper<RegisteredType>().eq("registeredId", registeredId));
        if (i) {
            return "删除成功";
        } else {
            return "删除失败";
        }
    }
}
