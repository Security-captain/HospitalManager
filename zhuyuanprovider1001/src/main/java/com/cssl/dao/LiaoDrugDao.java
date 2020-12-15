package com.cssl.dao;

import com.cssl.pojo.Lpharmacy;
import com.cssl.pojo.Lrecord;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author jalon
 * @date 2020-12-7 11:54
 */
@Mapper
public interface LiaoDrugDao {

    //查询药品信息
    List<Lpharmacy> selDrug(Lpharmacy lpharmacy);
    //查询患者的药品信息
    List<Lrecord> selDrugs(Lrecord lrecord);
    //添加药品
    int addDrug(Lrecord lrecord);
    //修改药品信息，时间，数量，价钱
    int updDrug(Lrecord lrecord);
    //删除患者药品
    int delDrug(Lrecord lrecord);
    //修改药房数量
    int updDrugs(Lrecord lrecord);
    //修改药房数量
    int updNum(Lrecord lrecord);
    //取出药品
    int upd(Lrecord lrecord);

}
