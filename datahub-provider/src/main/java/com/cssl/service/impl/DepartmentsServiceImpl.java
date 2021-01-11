package com.cssl.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cssl.mapper.DepartmentsMapper;
import com.cssl.pojo.Departments;
import com.cssl.service.DepartmentsService;
import org.springframework.stereotype.Service;

@Service
public class DepartmentsServiceImpl extends ServiceImpl<DepartmentsMapper, Departments> implements DepartmentsService {

}
