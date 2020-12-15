package com.cssl.dao;

import com.cssl.pojo.*;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author jalon
 * @date 2020-12-5 09:46
 */
@Repository
@Mapper
public interface LiaoAdminDao {

    //条件查询科室
    List<Departments> selDepartment(Departments departments);
    //条件查询医生
    List<Doctor> selDoctor(Doctor doctor);
    //查询床位
    List<Bed> selBed(Bed bed);
    //执行添加患者
    int addRegister(Register register);
    //查询患者
    List<Register> selRegister(Register register);
    //修改患者床位状态
    int updBed(Register register);
    //查询折扣
    List<Moneytype> selDis();
    //查询门诊传过来的信息
    List<Register> selDoor();
    //逻辑删除门诊信息
    int updZ(Register register);
    //修改患者信息
    int updKe(Register register);

}
