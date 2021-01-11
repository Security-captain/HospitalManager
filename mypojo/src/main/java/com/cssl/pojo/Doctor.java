package com.cssl.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@TableName("doctor")
public class Doctor {

    @TableId(value = "doctorId", type = IdType.AUTO)
    private Integer doctorId;
    @TableField("doctorName")
    private String doctorName;
    @TableField("departmentId")
    private Integer departmentId;
    @TableField("registeredId")
    private Integer registeredId;
    @TableField("dstate")
    private Integer dstate;
    private String department;
    private String type;
}
