package com.cssl.controller;

import com.cssl.client.FeignPaiBanClient;
import com.cssl.pojo.PaiBan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//wyz       排班管理
@RestController
@RequestMapping("paiban")
public class PaiBanController {

    @Autowired
    private FeignPaiBanClient feignPaiBanClient;

    @RequestMapping("findAllPaiban")
    public Object findAllPaiban(PaiBan paiban, int page, int limit) {
        return feignPaiBanClient.findAllPaiban(paiban, page, limit);
    }

    @RequestMapping("editPaiban")
    public String editPaiban(PaiBan paiban) {
        return feignPaiBanClient.editPaiban(paiban);
    }

    @RequestMapping("findAllBan")
    public Object findAllBan() {
        return feignPaiBanClient.findAllBan();
    }

}
