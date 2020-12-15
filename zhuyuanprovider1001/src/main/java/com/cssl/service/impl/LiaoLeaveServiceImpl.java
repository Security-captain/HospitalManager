package com.cssl.service.impl;

import com.cssl.dao.LiaoLeaveDao;
import com.cssl.pojo.Register;
import com.cssl.service.LiaoLeaveService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author jalon
 * @date 2020-12-7 09:11
 */
@Service
@Transactional
public class LiaoLeaveServiceImpl implements LiaoLeaveService {

    @Resource
    private LiaoLeaveDao liaoLeaveDao;

    @Override
    public List<Register> selRegisters(Register register) {
        return liaoLeaveDao.selRegisters(register);
    }

    @Override
    public int updRstate(Register register) {
        return liaoLeaveDao.updRstate(register);
    }

    @Override
    public int updBstate(Register register) {
        return liaoLeaveDao.updBstate(register);
    }

    @Override
    public int selYaos(Register register) {
        return liaoLeaveDao.selYaos(register);
    }
}
