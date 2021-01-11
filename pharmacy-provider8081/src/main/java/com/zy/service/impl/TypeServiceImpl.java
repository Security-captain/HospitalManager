package com.zy.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zy.dao.TypeDao;
import com.cssl.pojo.Type;
import com.zy.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TypeServiceImpl extends ServiceImpl<TypeDao, Type> implements TypeService {

    @Autowired
    private TypeDao td;

}
