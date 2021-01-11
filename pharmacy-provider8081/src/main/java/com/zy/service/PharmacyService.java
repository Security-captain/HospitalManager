package com.zy.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cssl.pojo.Pharmacy;

import java.util.List;
import java.util.Map;

public interface PharmacyService extends IService<Pharmacy> {

    List<Map<String,Object>> selectPharmacy(String name,int page,int limit);
}
