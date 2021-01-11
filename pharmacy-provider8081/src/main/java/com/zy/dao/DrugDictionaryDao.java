package com.zy.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cssl.pojo.DrugDictionary;

import java.util.List;
import java.util.Map;

public interface DrugDictionaryDao extends BaseMapper<DrugDictionary> {

    List<Map<String,Object>> selectDrugDictionary(String name);

}
