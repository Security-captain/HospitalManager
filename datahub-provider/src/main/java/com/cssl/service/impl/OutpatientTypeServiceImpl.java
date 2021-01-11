package com.cssl.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cssl.mapper.OutpatientTypeMapper;
import com.cssl.pojo.OutpatientType;
import com.cssl.service.OutpatientTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OutpatientTypeServiceImpl extends ServiceImpl<OutpatientTypeMapper, OutpatientType> implements OutpatientTypeService {

    @Autowired
    private OutpatientTypeMapper outpatientTypeMapper;

    @Override
    public List<OutpatientType> findAllOutpatientType(OutpatientType outpatienttype) {
        return outpatientTypeMapper.findAllOutpatientType(outpatienttype);
    }
}
