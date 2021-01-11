package com.cssl.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cssl.pojo.OutpatientType;

import java.util.List;

public interface OutpatientTypeService extends IService<OutpatientType> {
    List<OutpatientType> findAllOutpatientType(OutpatientType outpatienttype);
}
