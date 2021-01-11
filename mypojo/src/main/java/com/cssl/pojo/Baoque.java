package com.cssl.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Baoque {

    @TableId
    private int baoqueid;
    private String baoqueName;
    private int baoqueNum;

}
