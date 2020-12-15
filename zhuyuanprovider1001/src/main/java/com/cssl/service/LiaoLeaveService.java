package com.cssl.service;

import com.cssl.pojo.Register;

import java.util.List;

/**
 * @author jalon
 * @date 2020-12-7 09:10
 */
public interface LiaoLeaveService {

    List<Register> selRegisters(Register register);
    int updRstate(Register register);
    int updBstate(Register register);
    int selYaos(Register register);

}
