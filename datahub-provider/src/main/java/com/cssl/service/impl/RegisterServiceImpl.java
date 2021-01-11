package com.cssl.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cssl.mapper.RegisterMapper;
import com.cssl.pojo.Register;
import com.cssl.service.RegisterService;
import org.springframework.stereotype.Service;

@Service
public class RegisterServiceImpl extends ServiceImpl<RegisterMapper, Register> implements RegisterService {

}
