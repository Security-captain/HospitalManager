package com.zy.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cssl.pojo.Warehouse;
import java.util.List;
import java.util.Map;

public interface WareHuoseDao extends BaseMapper<Warehouse> {

    List<Map<String,Object>> selectWareHuosePharmacy(String name);

}
