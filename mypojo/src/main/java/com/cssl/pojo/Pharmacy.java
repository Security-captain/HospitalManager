package com.cssl.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
/**
 * 药房表
 * */
@Data
public class Pharmacy {

    @TableId
    private int pahrmacyId; //药房id
    private String pahrmacyName; // 药房名称
    private String drugstoreId; // 药品名称
    private int skullId; //经办人Id
    private int warehouseId; //库房Id
    private int unit; // 计量单位
    private int sellingPrice; // 售价
    private int area; // 产地
    private int type; // 药品类型
    private String produceDate; // 生产日期
    private int drugstoreNum; // 数量
    private String skullBatch; // 批号


}
