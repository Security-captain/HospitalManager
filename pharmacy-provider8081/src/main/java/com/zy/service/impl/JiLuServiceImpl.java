package com.zy.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zy.dao.JiLuDao;
import com.cssl.pojo.Jilu;
import com.zy.service.JiLuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JiLuServiceImpl extends ServiceImpl<JiLuDao, Jilu> implements JiLuService {

    @Autowired
    private JiLuDao jd;

}
