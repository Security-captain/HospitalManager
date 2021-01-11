package com.cssl.controller;

import com.cssl.client.FeignDataHubClient;
import com.cssl.pojo.RegisteredType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//wyz       挂号类型
@RestController
@RequestMapping("registeredType")
public class RegisteredTypeController {
    @Autowired
    private FeignDataHubClient feignDataHubClient;

    @RequestMapping("registeredTypeList")
    public Object registeredTypeList(RegisteredType registeredtype, int page, int limit) {
        return feignDataHubClient.registeredTypeList(registeredtype, page, limit);
    }

    @RequestMapping("addRegisteredType")
    @ResponseBody
    public String addRegisteredType(RegisteredType registeredtype) {
        return feignDataHubClient.addRegisteredType(registeredtype);
    }


    @RequestMapping("editRegisteredType")
    @ResponseBody
    public String editRegisteredType(RegisteredType registeredtype) {
        return feignDataHubClient.editRegisteredType(registeredtype);
    }


    @RequestMapping("deleteType")
    @ResponseBody
    public String deleteType(Integer registeredId) {
        return feignDataHubClient.deleteRType(registeredId);   //     方法名改了
    }
}
