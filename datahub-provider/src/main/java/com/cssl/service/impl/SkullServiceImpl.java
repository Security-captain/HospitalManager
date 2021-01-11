package com.cssl.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cssl.mapper.SkullMapper;
import com.cssl.pojo.Skull;
import com.cssl.service.SkullService;
import org.springframework.stereotype.Service;

@Service
public class SkullServiceImpl extends ServiceImpl<SkullMapper, Skull> implements SkullService {

}
