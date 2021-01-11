package com.cssl.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 药品表
 * */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DrugDictionary {

    @TableId(value = "drugId", type = IdType.AUTO)
    private Integer drugId;
    @TableField("drugName")
    private String drugName;
    @TableField("unitId")
    private Integer unitId;
    @TableField("sellingPrice")
    private Double sellingPrice;
    @TableField("areaId")
    private Integer areaId;
    @TableField("typeId")
    private Integer typeId;

    private  String unitName;
    private  String areaName;
    private  String typeName;

}
