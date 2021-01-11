package com.cssl.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cssl.pojo.Bed;

import java.util.List;

public interface BedService extends IService<Bed> {
    List<Bed> findAllBed(Bed bed);

    int checkCount(Integer bedId);
}
