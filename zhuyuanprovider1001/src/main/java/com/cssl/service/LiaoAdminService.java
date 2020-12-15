package com.cssl.service;

import com.cssl.pojo.*;

import java.util.List;

/**
 * @author jalon
 * @date 2020-12-5 09:40
 */
public interface LiaoAdminService {

    //科室
    List<Departments> selDepartment(Departments departments);
    //医生
    List<Doctor> selDoctor(Doctor doctor);
    //床位
    List<Bed> selBed(Bed bed);
    //添加患者
    int addRegister(Register register);
    //查询患者
    List<Register> selRegister(Register register);
    //修改床位状态
    int updBed(Register register);
    //查询折扣
    List<Moneytype> selDis();
    //门诊传过来的信息
    List<Register> selDoor();
    //逻辑删除门诊信息
    int updZ(Register register);
    //修改患者信息
    int updKe(Register register);

}
