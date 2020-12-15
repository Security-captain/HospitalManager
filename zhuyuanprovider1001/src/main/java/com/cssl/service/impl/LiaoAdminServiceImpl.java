package com.cssl.service.impl;

import com.cssl.dao.LiaoAdminDao;
import com.cssl.pojo.*;
import com.cssl.service.LiaoAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author jalon
 * @date 2020-12-5 09:40
 */
@Service
@Transactional
public class LiaoAdminServiceImpl implements LiaoAdminService {

    @Autowired
    private LiaoAdminDao liaoAdminDao;

    @Override
    public List<Departments> selDepartment(Departments departments) {
        return liaoAdminDao.selDepartment(departments);
    }

    @Override
    public List<Doctor> selDoctor(Doctor doctor) {
        return liaoAdminDao.selDoctor(doctor);
    }

    @Override
    public List<Bed> selBed(Bed bed) {
        return liaoAdminDao.selBed(bed);
    }

    @Override
    public int addRegister(Register register) {
        return liaoAdminDao.addRegister(register);
    }

    @Override
    public List<Register> selRegister(Register register) {
        return liaoAdminDao.selRegister(register);
    }

    @Override
    public int updBed(Register register) {
        return liaoAdminDao.updBed(register);
    }

    @Override
    public List<Moneytype> selDis() {
        return liaoAdminDao.selDis();
    }

    @Override
    public List<Register> selDoor() {
        return liaoAdminDao.selDoor();
    }

    @Override
    public int updZ(Register register) {
        return liaoAdminDao.updZ(register);
    }

    @Override
    public int updKe(Register register) {
        return liaoAdminDao.updKe(register);
    }

}
