package com.cssl.client;

import com.cssl.pojo.PaiBan;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

//wyz       排班管理
@FeignClient(name = "paiban-provider")
public interface FeignPaiBanClient {

    @RequestMapping("/paiban/findAllPaiban")
    Object findAllPaiban(@SpringQueryMap PaiBan paiban, @RequestParam int page, @RequestParam int limit);

    @RequestMapping("/paiban/editPaiban")
    String editPaiban(@SpringQueryMap PaiBan paiban);

    @RequestMapping("/paiban/findAllBan")
    Object findAllBan();
}
