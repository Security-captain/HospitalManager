package com.cssl.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cssl.mapper.BanMapper;
import com.cssl.pojo.Ban;
import com.cssl.service.BanService;
import org.springframework.stereotype.Service;

@Service
public class BanServiceImpl extends ServiceImpl<BanMapper, Ban> implements BanService {

}
