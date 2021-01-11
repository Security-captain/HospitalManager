package com.cssl.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@TableName("outpatienttype")
public class OutpatientType {
    private Integer outpatientId;
    @TableField("projectName")
    private String projectName;
    private String pprojectName;
    @TableField("price")
    private double price;
    @TableField("bigprojectId")
    private Integer bigprojectId;
    @TableField("unit")
    private Integer unit;
    private String unitName;
    @TableField("ostate")
    private Integer ostate;
}
