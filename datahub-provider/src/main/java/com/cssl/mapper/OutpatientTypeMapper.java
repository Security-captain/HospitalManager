package com.cssl.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cssl.pojo.OutpatientType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OutpatientTypeMapper extends BaseMapper<OutpatientType> {
    List<OutpatientType> findAllOutpatientType(OutpatientType outpatienttype);
}
