package com.cssl.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cssl.pojo.InOutpatientType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InOutpatientTypeMapper extends BaseMapper<InOutpatientType> {
    List<InOutpatientType> findAllInOutpatientType(InOutpatientType inoutpatienttype);
}
