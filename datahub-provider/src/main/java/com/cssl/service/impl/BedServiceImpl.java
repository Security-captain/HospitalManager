package com.cssl.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cssl.mapper.BedMapper;
import com.cssl.pojo.Bed;
import com.cssl.service.BedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BedServiceImpl extends ServiceImpl<BedMapper, Bed> implements BedService {

    @Autowired
    private BedMapper bedMapper;

    @Override
    public List<Bed> findAllBed(Bed bed) {
        return bedMapper.findAllBed(bed);
    }

    @Override
    public int checkCount(Integer bedId) {
        return bedMapper.checkCount(bedId);
    }
}
