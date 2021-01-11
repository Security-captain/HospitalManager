package com.zy.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cssl.pojo.Drugstore;
import java.util.List;
import java.util.Map;

public interface DrugstoreService extends IService<Drugstore> {

    List<Map<String,Object>> selectInsufficient(int page,int limit);
    List<Map<String,Object>> selectGuoQi(int page,int limit);
    int selectNum(String name);
    int updateDrugstore(String drugstorenum,String batch);
    int updrugstore(Drugstore drugstore);
}
