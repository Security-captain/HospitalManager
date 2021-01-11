package com.zy.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zy.dao.UpplierDao;
import com.cssl.pojo.Upplier;
import com.zy.service.UpplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpplierServiceImpl extends ServiceImpl<UpplierDao, Upplier> implements UpplierService {

    @Autowired
    private UpplierDao uppDao;
}
