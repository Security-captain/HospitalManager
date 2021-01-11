package com.cssl.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cssl.pojo.Doctor;

import java.util.List;

public interface DoctorService extends IService<Doctor> {
    List<Doctor> doctorList(Doctor doctor);

    int checkCount(Integer doctorId);
}
