package com.cssl.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;

/**
 * 药房仓库
 * */
@Data
public class Drugstore implements Serializable {

    @TableId
    private int rugstoreId;
    private String drugstoreName; // 药房名称
    private int supplierId; // 供货单位id
    private int skullId; // 经办人id
    private int warehouseId; // 库房id
    private int unit; // 计量单位
    private int tradePrice; // 批发价
    private int sellingPrice; // 售价
    private int area; // 产地id
    private int type; // 类型id;
    private String produceDate; // 生产日期
    private String validDate; //过期日期
    private int drugstorenum; // 数量
    private String batch; // 批号

}
