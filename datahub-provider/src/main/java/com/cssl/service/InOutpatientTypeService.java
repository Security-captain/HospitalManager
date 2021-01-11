package com.cssl.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cssl.pojo.InOutpatientType;

import java.util.List;

public interface InOutpatientTypeService extends IService<InOutpatientType> {
    List<InOutpatientType> findAllInOutpatientType(InOutpatientType inoutpatienttype);
}
