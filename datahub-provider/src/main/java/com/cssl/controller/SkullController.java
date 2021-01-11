package com.cssl.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cssl.pojo.Skull;
import com.cssl.service.SkullService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("skull")
public class SkullController {
    @Autowired
    private SkullService skullService;

    @RequestMapping("findAllSkull")
    public Object SkullList(Skull skull, int page, int limit) {
        Map<String, Object> map = new HashMap<>();
        Page<Skull> skullPage = new Page<>(page, limit);
        IPage<Skull> iPage;
        if (skull.getSkullName() != null) {
            iPage = skullService.page(skullPage, new QueryWrapper<Skull>().like("skullName", skull.getSkullName()));
        } else {
            iPage = skullService.page(skullPage);

        }

        map.put("code", 0);
        map.put("msg", "");
        map.put("count", iPage.getTotal());
        map.put("data", iPage.getRecords());
        return map;
    }

    @RequestMapping("addSkull")
    public String addSkull(Skull skull) {
        boolean i = skullService.save(skull);
        if (i) {
            return "添加成功";
        } else {
            return "添加失败";
        }
    }

    @RequestMapping("editSkull")
    public String editSkull(Skull skull) {
        boolean i = skullService.update(skull, new UpdateWrapper<Skull>().eq("skullId", skull.getSkullId()));
        if (i) {
            return "修改成功";
        } else {
            return "修改失败";
        }
    }

    @RequestMapping("deleteSkull")
    public String deleteSkull(Integer skullId) {
        boolean i = skullService.remove(new UpdateWrapper<Skull>().eq("skullId", skullId));
        if (i) {
            return "删除成功";
        } else {
            return "删除失败";
        }
    }
}
