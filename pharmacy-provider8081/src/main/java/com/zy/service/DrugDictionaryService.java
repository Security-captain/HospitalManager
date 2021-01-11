package com.zy.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cssl.pojo.DrugDictionary;

import java.util.List;
import java.util.Map;

public interface DrugDictionaryService extends IService<DrugDictionary> {

    List<Map<String,Object>> selectDrugDictionary(String name);
}
