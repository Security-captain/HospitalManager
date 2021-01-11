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
@TableName("registeredtype")
public class RegisteredType {
    @TableId(value = "registeredId",type = IdType.AUTO)
    private Integer registeredId;
    @TableField("type")
    private String type;
    @TableField("price")
    private double price;
}
