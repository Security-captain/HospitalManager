package com.cssl.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cssl.pojo.Type;
import com.cssl.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("type")
public class TypeController {
    @Autowired
    private TypeService typeService;

    @RequestMapping("findAllType")
    public Object TypeList(Type type, int page, int limit) {
        Map<String, Object> map = new HashMap<>();
        Page<Type> typePage = new Page<>(page, limit);
        IPage<Type> iPage;
        if (type.getTypeName() != null) {
            iPage = typeService.page(typePage, new QueryWrapper<Type>().like("typeName", type.getTypeName()));
        } else {
            iPage = typeService.page(typePage);
        }

        map.put("code", 0);
        map.put("msg", "");
        map.put("count", iPage.getTotal());
        map.put("data", iPage.getRecords());
        return map;
    }

    @RequestMapping("addType")
    public String addType(Type type) {
        int count = typeService.count(new QueryWrapper<Type>().eq("typeName", type.getTypeName()));
        if (count == 0) {
            boolean i = typeService.save(type);
            if (i) {
                return "添加成功";
            } else {
                return "添加失败";
            }
        } else {
            return type.getTypeName() + "已存在";
        }

    }

    @RequestMapping("deleteType")
    public String deleteType(Integer typeId) {
        boolean i = typeService.remove(new UpdateWrapper<Type>().eq("typeId", typeId));
        if (i) {
            return "删除成功";
        } else {
            return "删除失败";
        }
    }
}
