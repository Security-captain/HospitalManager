package com.cssl.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 经办人表
 * */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Skull {

    @TableId(value = "skullId",type = IdType.AUTO)
    private Integer skullId;
    @TableField("skullName")
    private String skullName;

}
