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
@TableName("paiban")
public class PaiBan {
    @TableId(value = "paiId",type = IdType.AUTO)
    private Integer paiId;
    @TableField("one")
    private String one;
    @TableField("two")
    private String two;
    @TableField("three")
    private String three;
    @TableField("four")
    private String four;
    @TableField("five")
    private String five;
    @TableField("six")
    private String six;
    @TableField("seven")
    private String seven;
    @TableField("doctorId")
    private Integer doctorId;
    private String doctorName;
}
