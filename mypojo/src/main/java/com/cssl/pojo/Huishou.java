package com.cssl.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * 回收表
 */
@Data
public class Huishou {

    @TableId
    private int huishouid;
    private String huishouname;
    private int huishounumber;
    private String huishoupihao;
    private String jbr;
    private String beizhu;

}
