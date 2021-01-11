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
@TableName("Moneytype")
public class MoneyType {
    @TableId(value = "moneyId",type = IdType.AUTO)
    private Integer MoneyId;
    @TableField("moneytype")
    private String Moneytype;
    @TableField("Percent")
    private String percent;
}
