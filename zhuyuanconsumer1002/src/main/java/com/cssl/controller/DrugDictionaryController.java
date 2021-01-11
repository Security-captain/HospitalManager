package com.cssl.controller;

import com.cssl.client.FeignDataHubClient;
import com.cssl.pojo.DrugDictionary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

//wyz       药品字典
@RestController
@RequestMapping("drugdictionary")
public class DrugDictionaryController {

    @Autowired
    private FeignDataHubClient feignDataHubClient;

    @RequestMapping("findAlldrugdictionary")
    public Object drugdictionaryList(DrugDictionary drugDictionary, int page, int limit) {
        Object b = feignDataHubClient.drugdictionaryList(drugDictionary, page, limit);

        return feignDataHubClient.drugdictionaryList(drugDictionary, page, limit);
    }

    @RequestMapping("adddrugdictionary")
    @ResponseBody
    public String adddrugdictionary(DrugDictionary drugDictionary) {
        return feignDataHubClient.adddrugdictionary(drugDictionary);

    }

    @RequestMapping("editdrugdictionary")
    @ResponseBody
    public String editdrugdictionary(DrugDictionary drugDictionary) {
        return feignDataHubClient.editdrugdictionary(drugDictionary);

    }

    @RequestMapping("deletedrugdictionary")
    @ResponseBody
    public String deletedrugdictionary(Integer drugId) {
        return feignDataHubClient.deletedrugdictionary(drugId);
    }

    @RequestMapping("findAllArea")
    public Object findAllArea() {
        return feignDataHubClient.findAllArea();
    }

    @RequestMapping("findAllType")
    public Object findAllType() {
        return feignDataHubClient.findAllType();
    }

    @RequestMapping("findAllUnit")
    public Object findAllUnit() {
        return feignDataHubClient.findAllUnit();
    }
}
