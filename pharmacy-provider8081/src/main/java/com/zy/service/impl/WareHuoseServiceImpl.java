package com.zy.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zy.dao.WareHuoseDao;
import com.cssl.pojo.Warehouse;
import com.zy.service.WareHuoseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class WareHuoseServiceImpl extends ServiceImpl<WareHuoseDao, Warehouse> implements WareHuoseService {

    @Autowired
    private WareHuoseDao whd;

    @Override
    public List<Map<String, Object>> selectWareHuosePharmacy(String name) {
        return whd.selectWareHuosePharmacy(name);
    }
}
