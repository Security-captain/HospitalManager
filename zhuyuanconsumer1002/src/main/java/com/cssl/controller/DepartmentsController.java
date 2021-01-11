package com.cssl.controller;
import com.cssl.client.FeignDataHubClient;
import com.cssl.pojo.Departments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//wyz       科室
@RestController
@RequestMapping("department")
public class DepartmentsController {
    @Autowired
    private FeignDataHubClient feignDataHubClient;

    @RequestMapping("departmentList")
    public Object departmentList(Departments departments, int page, int limit) {
        return feignDataHubClient.departmentList(departments, page, limit);
    }

    @RequestMapping("addDepartment")
    @ResponseBody
    public String addDepartment(Departments departments) {
        return feignDataHubClient.addDepartment(departments);
    }

    @RequestMapping("deleteDepartment")
    @ResponseBody
    public String deleteDepartment(Integer departmentId) {
        return feignDataHubClient.deleteDepartment(departmentId);
    }
}
