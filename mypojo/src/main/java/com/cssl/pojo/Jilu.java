package com.cssl.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
/**
 * 操作记录表
 * */
@Data
public class Jilu {

    @TableId
    private int jiluID; // 记录Id
    private String jiluName; // 记录名称;
    private String jiluTime; // 记录时间
    private String jiluType; // 记录状态
    private String jiluPeople; // 记录人员
    private int jiluNumber; // 记录数量
    private String jilupihao; // 记录批号

}
