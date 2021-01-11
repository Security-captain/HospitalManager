package com.cssl.controller;

import com.cssl.client.FeignDataHubClient;
import com.cssl.pojo.Skull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//wyz       经办人
@RestController
@RequestMapping("skull")
public class SkullController {
    @Autowired
    private FeignDataHubClient feignDataHubClient;

    @RequestMapping("findAllSkull")
    public Object SkullList(Skull skull, int page, int limit) {
        return feignDataHubClient.SkullList(skull, page, limit);
    }

    @RequestMapping("addSkull")
    @ResponseBody
    public String addSkull(Skull skull) {
        return feignDataHubClient.addSkull(skull);
    }

    @RequestMapping("editSkull")
    @ResponseBody
    public String editSkull(Skull skull) {
        return feignDataHubClient.editSkull(skull);
    }

    @RequestMapping("deleteSkull")
    @ResponseBody
    public String deleteSkull(Integer skullId) {
        return feignDataHubClient.deleteSkull(skullId);
    }
}
