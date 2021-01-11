package com.cssl.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cssl.pojo.Upplier;
import com.cssl.service.UpplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("upplier")
public class UpplierController {

    @Autowired
    private UpplierService upplierService;

    @RequestMapping("findAllUpplier")
    public Object UpplierList(Upplier upplier, int page, int limit) {
        Map<String, Object> map = new HashMap<>();
        Page<Upplier> upplierPage = new Page<>(page, limit);
        IPage<Upplier> iPage;
        if (upplier.getSupplierName() != null) {
            iPage = upplierService.page(upplierPage, new QueryWrapper<Upplier>().eq("state", 0).like("supplierName", upplier.getSupplierName()));
        } else {
            iPage = upplierService.page(upplierPage, new QueryWrapper<Upplier>().eq("state", 0));
        }


        map.put("code", 0);
        map.put("msg", "");
        map.put("count", iPage.getTotal());
        map.put("data", iPage.getRecords());
        return map;
    }

    @RequestMapping("addUpplier")
    public String addUpplier(Upplier upplier) {
        int count = upplierService.count(new QueryWrapper<Upplier>().eq("supplierName", upplier.getSupplierName()).eq("state", 0));
        if (count == 0) {
            boolean i = upplierService.save(upplier);
            if (i) {
                return "添加成功";
            } else {
                return "添加失败";
            }
        } else {
            return upplier.getSupplierName() + "已存在";
        }

    }

    @RequestMapping("deleteUpplier")
    public String deleteUpplier(Integer supplierId) {
        boolean i = upplierService.remove(new UpdateWrapper<Upplier>().eq("supplierId", supplierId));
        if (i) {
            return "删除成功";
        } else {
            return "删除失败";
        }
    }
}
