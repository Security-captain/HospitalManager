package com.cssl.service;

import com.cssl.pojo.Lpharmacy;
import com.cssl.pojo.Lrecord;

import java.util.List;

/**
 * @author jalon
 * @date 2020-12-7 11:51
 */
public interface LiaoDrugService {

    List<Lpharmacy> selDrug(Lpharmacy lpharmacy);
    List<Lrecord> selDrugs(Lrecord lrecord);
    int addDrug(Lrecord lrecord);
    int updDrug(Lrecord lrecord);
    int delDrug(Lrecord lrecord);
    int updDrugs(Lrecord lrecord);
    int updNum(Lrecord lrecord);
    int upd(Lrecord lrecord);


}
