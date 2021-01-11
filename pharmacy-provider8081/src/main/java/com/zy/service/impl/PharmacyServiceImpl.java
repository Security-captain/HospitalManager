package com.zy.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zy.dao.PharmacyDao;
import com.cssl.pojo.Pharmacy;
import com.zy.service.PharmacyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class PharmacyServiceImpl extends ServiceImpl<PharmacyDao, Pharmacy> implements PharmacyService {

    @Autowired
    private PharmacyDao pd;


    @Override
    public List<Map<String, Object>> selectPharmacy(String name,int page,int limit) {
        return pd.selectPharmacy(name,page,limit);
    }
}
