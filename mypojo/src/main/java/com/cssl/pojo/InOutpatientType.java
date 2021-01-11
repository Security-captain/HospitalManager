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
@TableName("inoutpatientType")
public class InOutpatientType {
    @TableId(value = "inoutpatientId", type = IdType.AUTO)
    private Integer inoutpatientId;
    @TableField("projectName")
    private String projectName;
    private String pprojectName;
    @TableField("price")
    private double price;
    @TableField("bigproJectId")
    private Integer bigproJectId;
    @TableField("unit")
    private Integer unit;
    private String unitName;
}
