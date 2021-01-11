package com.cssl.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
/**
 * 操作记录表
 * */
@Data
public class Jilu {

    @TableId
    private int jiluid; // 记录Id
    private String jiluname; // 记录名称;
    private String jilutime; // 记录时间
    private String jilutype; // 记录状态
    private String jilupeople; // 记录人员
    private int jilunumber; // 记录数量
    private String jilupihao; // 记录批号

}
