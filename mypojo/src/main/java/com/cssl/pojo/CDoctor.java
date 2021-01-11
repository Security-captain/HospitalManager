package com.cssl.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CDoctor {

    private int doctorId;//医生id
    private String doctorName;//医生姓名
    private Integer departmentId;//外键科室id
    private Integer registeredid;//外键类型id
    private Integer dstate;

}
