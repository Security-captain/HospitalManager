package com.cssl.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 计量单位表
 * */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Unit {

    @TableId(value = "unitId",type = IdType.AUTO)
    private Integer unitId;
    @TableField("unitName")
    private String unitName;
}
