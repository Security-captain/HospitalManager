package com.cssl.service;

import com.cssl.pojo.Lrecord;
import com.cssl.pojo.Pay;
import com.cssl.pojo.Register;

import java.util.List;

/**
 * @author jalon
 * @date 2020-12-7 11:52
 */
public interface LiaoPayService {

    int updPay(Register register);
    int addPay(Register register);
    List<Pay> selPays(Register register);
    List<Lrecord> selSurplus(Lrecord lrecord);

}
