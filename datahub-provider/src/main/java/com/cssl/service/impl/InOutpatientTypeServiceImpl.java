package com.cssl.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cssl.mapper.InOutpatientTypeMapper;
import com.cssl.pojo.InOutpatientType;
import com.cssl.service.InOutpatientTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InOutpatientTypeServiceImpl extends ServiceImpl<InOutpatientTypeMapper, InOutpatientType> implements InOutpatientTypeService {

    @Autowired
    private InOutpatientTypeMapper inOutpatientTypeMapper;

    @Override
    public List<InOutpatientType> findAllInOutpatientType(InOutpatientType inoutpatienttype) {
        return inOutpatientTypeMapper.findAllInOutpatientType(inoutpatienttype);
    }
}
