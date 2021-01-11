package com.zy.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zy.dao.UnitDao;
import com.cssl.pojo.Unit;
import com.zy.service.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UnitServiceImpl extends ServiceImpl<UnitDao, Unit> implements UnitService {

    @Autowired
    private UnitDao ud;
}
