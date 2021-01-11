package com.cssl.dao;

import com.cssl.pojo.PaiBan;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

/**
 * @author jalon
 * @date 2020-12-25 17:04
 */
@Mapper
public interface MainDao {

    List<PaiBan> one();
    List<PaiBan> two();
    List<PaiBan> three();
    List<PaiBan> four();
    List<PaiBan> five();
    List<PaiBan> six();
    List<PaiBan> seven();
    int currentNum();
    int Total();
    int zhuyuanTotal();
    int currentZhuYuan();

}
