package com.cssl.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cssl.mapper.ProjectTypeMapper;
import com.cssl.pojo.ProjectType;
import com.cssl.service.ProjectTypeService;
import org.springframework.stereotype.Service;

@Service
public class ProjectTypeServiceImpl extends ServiceImpl<ProjectTypeMapper, ProjectType> implements ProjectTypeService {

}
