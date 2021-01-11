package com.zy.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zy.dao.SkullDao;
import com.cssl.pojo.Skull;
import com.zy.service.SkullService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SkullServiceImpl extends ServiceImpl<SkullDao, Skull> implements SkullService {

    @Autowired
    private SkullDao sd;

}
