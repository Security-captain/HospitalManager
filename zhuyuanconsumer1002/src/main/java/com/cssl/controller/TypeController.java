package com.cssl.controller;

import com.cssl.client.FeignDataHubClient;
import com.cssl.pojo.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//wyz       药品分类/类型
@RestController
@RequestMapping("type")
public class TypeController {
    @Autowired
    private FeignDataHubClient feignDataHubClient;

    @RequestMapping("findAllType")
    public Object TypeList(Type type, int page, int limit) {
        return feignDataHubClient.TypeList(type, page, limit);
    }

    @RequestMapping("addType")
    @ResponseBody
    public String addType(Type type) {
        return feignDataHubClient.addType(type);
    }

    @RequestMapping("deleteType")
    @ResponseBody
    public String deleteType(Integer typeId) {
        return feignDataHubClient.deleteType(typeId);
    }
}
