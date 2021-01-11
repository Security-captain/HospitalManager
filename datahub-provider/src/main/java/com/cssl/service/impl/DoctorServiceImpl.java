package com.cssl.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cssl.mapper.DoctorMapper;
import com.cssl.pojo.Doctor;
import com.cssl.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorServiceImpl extends ServiceImpl<DoctorMapper, Doctor> implements DoctorService {
    @Autowired
    private DoctorMapper doctorMapper;

    @Override
    public List<Doctor> doctorList(Doctor doctor) {
        return doctorMapper.doctorList(doctor);
    }

    @Override
    public int checkCount(Integer doctorId) {
        return doctorMapper.checkCount(doctorId);
    }
}
