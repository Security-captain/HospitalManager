package com.zy.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cssl.pojo.Pharmacy;

import java.util.List;
import java.util.Map;

public interface PharmacyDao extends BaseMapper<Pharmacy> {

    List<Map<String,Object>> selectPharmacy(String name,int page,int limit);
}
