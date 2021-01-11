package com.zy.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zy.dao.BaoqueDao;
import com.cssl.pojo.Baoque;
import com.zy.service.BaoqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BaoqueServiceImpl extends ServiceImpl<BaoqueDao, Baoque> implements BaoqueService {

    @Autowired
    private BaoqueDao bd;
}
