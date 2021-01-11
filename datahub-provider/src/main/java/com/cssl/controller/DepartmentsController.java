package com.cssl.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cssl.pojo.Departments;
import com.cssl.service.DepartmentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.net.www.content.text.plain;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("department")
public class DepartmentsController {
    @Autowired
    private DepartmentsService departmentsService;

    @RequestMapping("departmentList")
    public Object departmentList(Departments departments, int page, int limit) {
        Map<String, Object> map = new HashMap<>();
        Page<Departments> departmentsPage = new Page<>(page, limit);
        IPage<Departments> iPage;
        if (departments.getDepartment() != null) {
            iPage = departmentsService.page(departmentsPage, new QueryWrapper<Departments>().like("department", departments.getDepartment()).orderByDesc("departmentId"));

        } else {
            iPage = departmentsService.page(departmentsPage, new QueryWrapper<Departments>().orderByDesc("departmentId"));
        }
        map.put("code", 0);
        map.put("msg", "");
        map.put("count", iPage.getTotal());
        map.put("data", iPage.getRecords());
        return map;
    }

    @RequestMapping("addDepartment")
    public String addDepartment(Departments departments) {
        int count = departmentsService.count(new QueryWrapper<Departments>().eq("department", departments.getDepartment()));
        if (count == 0) {
            boolean i = departmentsService.save(departments);
            if (i) {
                return "添加成功";
            } else {
                return "添加失败";
            }
        } else {
            return departments.getDepartment() + "已存在";
        }
    }

    @RequestMapping("deleteDepartment")
    public String deleteDepartment(Integer departmentId) {
        boolean i = departmentsService.remove(new UpdateWrapper<Departments>().eq("departmentId", departmentId));
        if (i) {
            return "删除成功";
        } else {
            return "删除失败";
        }
    }
}
