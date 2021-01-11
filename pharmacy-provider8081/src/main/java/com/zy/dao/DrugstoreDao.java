package com.zy.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cssl.pojo.Drugstore;

import java.util.List;
import java.util.Map;

public interface DrugstoreDao extends BaseMapper<Drugstore> {

    List<Map<String,Object>> selectInsufficient(int page,int limit);

    List<Map<String,Object>> selectGuoQi(int page,int limit);
    int updateDrugstore(String drugstorenum,String batch);
    int selectNum(String name);
    int updrugstore(Drugstore drugstore);

}
