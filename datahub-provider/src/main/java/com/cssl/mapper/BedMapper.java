package com.cssl.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cssl.pojo.Bed;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BedMapper extends BaseMapper<Bed> {
    List<Bed> findAllBed(Bed bed);

    int checkCount(Integer bedId);
}
