package com.cssl.service.impl;

import com.cssl.dao.MainDao;
import com.cssl.pojo.PaiBan;
import com.cssl.service.MainService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author jalon
 * @date 2020-12-25 17:03
 */
@Service
@Transactional
public class MainServiceImpl implements MainService {

    @Resource
    private MainDao mainDao;

    @Override
    public List<PaiBan> one() {
        return mainDao.one();
    }

    @Override
    public List<PaiBan> two() {
        return mainDao.two();
    }

    @Override
    public List<PaiBan> three() {
        return mainDao.three();
    }

    @Override
    public List<PaiBan> four() {
        return mainDao.four();
    }

    @Override
    public List<PaiBan> five() {
        return mainDao.five();
    }

    @Override
    public List<PaiBan> six() {
        return mainDao.six();
    }

    @Override
    public List<PaiBan> seven() {
        return mainDao.seven();
    }

    @Override
    public int currentNum() {
        return mainDao.currentNum();
    }

    @Override
    public int Total() {
        return mainDao.Total();
    }

    @Override
    public int zhuyuanTotal() {
        return mainDao.zhuyuanTotal();
    }

    @Override
    public int currentZhuYuan() {
        return mainDao.currentZhuYuan();
    }

}
