package com.cssl.service;

import com.cssl.pojo.PaiBan;

import java.util.List;

/**
 * @author jalon
 * @date 2020-12-25 17:02
 */
public interface MainService {

    //1--7 的排班
    List<PaiBan> one();
    List<PaiBan> two();
    List<PaiBan> three();
    List<PaiBan> four();
    List<PaiBan> five();
    List<PaiBan> six();
    List<PaiBan> seven();
    //门诊当天人数
    int currentNum();
    //总人数
    int Total();
    //住院总人数
    int zhuyuanTotal();
    //住院当天人数
    int currentZhuYuan();

}
