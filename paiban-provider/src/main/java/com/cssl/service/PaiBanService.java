package com.cssl.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cssl.pojo.PaiBan;

import java.util.List;

public interface PaiBanService extends IService<PaiBan> {
    List<PaiBan> findAllPaiBan(PaiBan paiBan);
}
