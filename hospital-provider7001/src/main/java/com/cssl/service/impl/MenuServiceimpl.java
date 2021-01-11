package com.cssl.service.impl;

import com.cssl.dao.MenuDao;
import com.cssl.pojo.Menu;
import com.cssl.pojo.User;
import com.cssl.service.MenuService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class MenuServiceimpl implements MenuService {


       @Resource
       private MenuDao menuDao;

    @Override
    public User loginname(String loginname) {
        return menuDao.loginname(loginname);
    }

    @Override
    public List<Menu> queryMenuAllList(Menu menu) {
        return menuDao.queryMenuAllList(menu);
    }

    @Override
    public List<Menu> queryMenuByUid(Integer userid) {
        return menuDao.queryMenuByUid(userid);
    }

    @Override
    public List<Menu> loadAvailableMenu() {
        return menuDao.loadAvailableMenu();
    }

    @Override
    public int checkMenuHasChildren(Integer pid) {
        return menuDao.checkMenuHasChildren(pid);
    }

    @Override
    public int addMenu(Menu menu) {
        return menuDao.MenuAdd(menu);
    }


    @Override
    public int deleteMenu(int id) {
        return menuDao.deleteMenu(id);
    }

    @Override
    public int updateMenu(Menu menu) {
        return menuDao.MenuUp(menu);
    }


}
