package com.cssl.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.cssl.pojo.*;
import com.cssl.service.DepartmentsService;
import com.cssl.service.DoctorService;
import com.cssl.service.RegisteredTypeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("doctor")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;
    @Autowired
    private DepartmentsService departmentsService;
    @Autowired
    private RegisteredTypeService registeredTypeService;

    @RequestMapping("doctorList")
    public Object doctorList(Doctor doctor, int page, int limit) {
        Map<String, Object> map = new HashMap<>();
        PageHelper.startPage(page, limit);
        PageInfo pageInfo = new PageInfo(doctorService.doctorList(doctor));


        map.put("code", 0);
        map.put("msg", "");
        map.put("count", pageInfo.getTotal());
        map.put("data", pageInfo.getList());
        return map;
    }

    @RequestMapping("addDoctor")
    public String addDoctor(Doctor doctor, PaiBan paiban) {
        int count = doctorService.count(new QueryWrapper<Doctor>().eq("doctorName", doctor.getDoctorName()).eq("dstate", 0));
        if (count == 0) {
            boolean i = doctorService.save(doctor);
            if (i) {
                return "添加成功";
            } else {
                return "添加失败";
            }
        } else {
            return doctor.getDoctorName() + "已存在";
        }

    }

    @RequestMapping("editDoctor")
    public String editDoctor(Doctor doctor) {
        boolean i = doctorService.update(doctor, new UpdateWrapper<Doctor>().eq("doctorId", doctor.getDoctorId()));
        if (i) {
            return "修改成功";
        } else {
            return "修改失败";
        }

    }

    @RequestMapping("deleteDoctor")
    public String deleteDoctor(Integer doctorId) {
        int i1 = doctorService.checkCount(doctorId);
        if (i1 > 0) {
            return "该医生还有病人";
        } else {
            boolean i = doctorService.remove(new UpdateWrapper<Doctor>().eq("doctorId", doctorId));
            if (i) {
                return "删除成功";
            } else {
                return "删除失败";
            }
        }

    }

    @RequestMapping("findAllDepartments")
    public Object findAllDepartments() {
        List<Departments> allDepartments = departmentsService.list();
        return allDepartments;
    }

    @RequestMapping("findAllRegisteredtype")
    public Object findAllRegisteredtype() {
        List<RegisteredType> allRegisteredtype = registeredTypeService.list();
        return allRegisteredtype;
    }
}
