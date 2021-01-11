package com.cssl.controller;

import com.cssl.client.FeignDataHubClient;
import com.cssl.pojo.Upplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//wyz       供货商
@RestController
@RequestMapping("upplier")
public class UpplierController {

    @Autowired
    private FeignDataHubClient feignDataHubClient;

    @RequestMapping("findAllUpplier")
    public Object UpplierList(Upplier upplier, int page, int limit) {
        return feignDataHubClient.UpplierList(upplier, page, limit);
    }

    @RequestMapping("addUpplier")
    @ResponseBody
    public String addUpplier(Upplier upplier) {
        return feignDataHubClient.addUpplier(upplier);

    }

    @RequestMapping("deleteUpplier")
    @ResponseBody
    public String deleteUpplier(Integer supplierId) {
        return feignDataHubClient.deleteUpplier(supplierId);
    }
}
