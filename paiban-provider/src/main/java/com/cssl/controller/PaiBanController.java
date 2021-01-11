package com.cssl.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.cssl.pojo.Ban;
import com.cssl.pojo.PaiBan;
import com.cssl.service.BanService;
import com.cssl.service.PaiBanService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("paiban")
public class PaiBanController {
    @Autowired
    private PaiBanService paiBanService;
    @Autowired
    private BanService banService;

    @RequestMapping("findAllPaiban")
    public Object findAllPaiban(PaiBan paiban, int page, int limit) {
        Map<String, Object> map = new HashMap<>();
        PageHelper.startPage(page, limit);
        PageInfo pageInfo = new PageInfo(paiBanService.findAllPaiBan(paiban));

        map.put("code", 0);
        map.put("msg", "");
        map.put("count", pageInfo.getTotal());
        map.put("data", pageInfo.getList());
        return map;
    }

    @RequestMapping("editPaiban")
    public String editPaiban(PaiBan paiban) {
        int count = paiBanService.count(new QueryWrapper<PaiBan>().eq("doctorId", paiban.getDoctorId()));
        if (count == 1) {
            paiBanService.update(paiban, new UpdateWrapper<PaiBan>().eq("doctorId", paiban.getDoctorId()));
        } else if (count == 0) {
            paiBanService.saveOrUpdate(paiban, new UpdateWrapper<PaiBan>().eq("doctorId", paiban.getDoctorId()));
        }
        return "修改成功";
    }

    @RequestMapping("findAllBan")
    public Object findAllBan() {
        List<Ban> allBan = banService.list();
        return allBan;
    }
}
