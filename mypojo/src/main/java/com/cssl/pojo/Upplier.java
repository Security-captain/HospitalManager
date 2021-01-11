package com.cssl.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 供货单位表
 * */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Upplier {


    @TableId(value = "supplierId",type = IdType.AUTO)
    private Integer supplierId;
    @TableField("supplierName")
    private String supplierName;
    @TableField("supplierPhone")
    private String supplierPhone;
    @TableField("supplierAddress")
    private String supplierAddress;

    /*@TableId
    private int supplierId; //供货单位id;
    private String supplierName; // 供货单位名称
    private String supplierPhone; // 联系电话
    private String supplierAddress; // 地址*/

}
