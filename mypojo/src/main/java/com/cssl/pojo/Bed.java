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
@TableName("bed")
public class Bed {
    @TableId(value = "bedId", type = IdType.AUTO)
    private Integer bedId;
    @TableField("bedname")
    private String bedname;
    @TableField("state")
    private Integer state;
    @TableField("price")
    private Double price;
    @TableField("departmentId")
    private Integer departmentId;
    private String department;
}
