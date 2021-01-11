package com.zy.service.impl;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zy.dao.HuiShouDao;
import com.cssl.pojo.Huishou;
import com.zy.service.HuiShouService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HuiShouServiceImpl extends ServiceImpl<HuiShouDao, Huishou> implements HuiShouService {

    @Autowired
    private HuiShouDao hsd;

}
