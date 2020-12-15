package com.cssl.dao;

import com.cssl.pojo.Register;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author jalon
 * @date 2020-12-7 09:12
 */
@Mapper
public interface LiaoLeaveDao {

    List<Register> selRegisters(Register register);
    int updRstate(Register register);
    int updBstate(Register register);
    int selYaos(Register register);

}
