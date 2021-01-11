package com.cssl.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cssl.pojo.PaiBan;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaiBanMapper extends BaseMapper<PaiBan> {
    List<PaiBan> findAllPaiBan(PaiBan paiBan);
}
