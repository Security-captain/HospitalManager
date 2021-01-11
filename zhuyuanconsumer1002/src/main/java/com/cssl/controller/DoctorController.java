package com.cssl.controller;

import com.cssl.client.FeignDataHubClient;
import com.cssl.pojo.Doctor;
import com.cssl.pojo.PaiBan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//wyz       医生列表
@RestController
@RequestMapping("doctor")
public class DoctorController {

    @Autowired
    private FeignDataHubClient feignDataHubClient;

    @RequestMapping("doctorList")
    public Object doctorList(Doctor doctor, int page, int limit) {
        return feignDataHubClient.doctorList(doctor, page, limit);
    }

    @RequestMapping("addDoctor")
    @ResponseBody
    public String addDoctor(Doctor doctor, PaiBan paiban) {
        return feignDataHubClient.addDoctor(doctor, paiban);

    }

    @RequestMapping("editDoctor")
    @ResponseBody
    public String editDoctor(Doctor doctor) {
        return feignDataHubClient.editDoctor(doctor);

    }

    @RequestMapping("deleteDoctor")
    @ResponseBody
    public String deleteDoctor(Integer doctorId) {
        return feignDataHubClient.deleteDoctor(doctorId);

    }

    @RequestMapping("findAllDepartments")
    public Object findAllDepartments() {
        return feignDataHubClient.findAllDepartments();
    }

    @RequestMapping("findAllRegisteredtype")
    public Object findAllRegisteredtype() {
        return feignDataHubClient.findAllRegisteredtype();
    }
}
