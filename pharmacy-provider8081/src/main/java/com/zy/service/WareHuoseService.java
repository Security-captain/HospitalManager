package com.zy.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cssl.pojo.Warehouse;

import java.util.List;
import java.util.Map;

public interface WareHuoseService extends IService<Warehouse> {

    List<Map<String,Object>> selectWareHuosePharmacy(String name);
}
