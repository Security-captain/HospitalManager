package com.cssl.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cssl.mapper.PaiBanMapper;
import com.cssl.pojo.PaiBan;
import com.cssl.service.PaiBanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaiBanServiceImpl extends ServiceImpl<PaiBanMapper, PaiBan> implements PaiBanService {

    @Autowired
    private PaiBanMapper paibanMapper;


    @Override
    public List<PaiBan> findAllPaiBan(PaiBan paiBan) {
        return paibanMapper.findAllPaiBan(paiBan);
    }
}
