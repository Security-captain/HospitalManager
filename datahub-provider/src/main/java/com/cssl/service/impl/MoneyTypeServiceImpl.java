package com.cssl.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cssl.mapper.MoneyTypeMapper;
import com.cssl.pojo.MoneyType;
import com.cssl.service.MoneyTypeService;
import org.springframework.stereotype.Service;

@Service
public class MoneyTypeServiceImpl extends ServiceImpl<MoneyTypeMapper, MoneyType> implements MoneyTypeService {

}
