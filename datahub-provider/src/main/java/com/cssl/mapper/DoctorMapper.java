package com.cssl.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cssl.pojo.Doctor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorMapper extends BaseMapper<Doctor> {
    List<Doctor> doctorList(Doctor doctor);

    int checkCount(Integer doctorId);
}
