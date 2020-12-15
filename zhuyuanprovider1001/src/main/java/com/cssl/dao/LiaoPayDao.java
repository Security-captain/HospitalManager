package com.cssl.dao;

import com.cssl.pojo.Lrecord;
import com.cssl.pojo.Pay;
import com.cssl.pojo.Register;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author jalon
 * @date 2020-12-7 11:54
 */
@Mapper
public interface LiaoPayDao {

    int updPay(Register register);
    int addPay(Register register);
    List<Pay> selPays(Register register);
    List<Lrecord> selSurplus(Lrecord lrecord);

}
