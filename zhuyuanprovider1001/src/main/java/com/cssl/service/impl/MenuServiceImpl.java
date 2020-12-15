package com.cssl.service.impl;

import com.cssl.dao.MenuDao;
import com.cssl.pojo.Menu;
import com.cssl.pojo.User;
import com.cssl.service.MenuService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author jalon
 * @date 2020-12-4 10:47
 */
@Service
@Transactional
public class MenuServiceImpl implements MenuService {

    @Resource
    private MenuDao MenuDao;

    @Override
    public User loginname(String loginname) {
        return MenuDao.loginname(loginname);
    }

    @Override
    public List<Menu> queryMenuByUid(Integer userid) {
        return MenuDao.queryMenuByUid(userid);
    }

    @Override
    public List<Menu> loadAvailableMenu() {
        return MenuDao.loadAvailableMenu();
    }

    @Override
    public List<Menu> selAllMenuByUser(Integer userId) {
        return MenuDao.selAllMenuByUser(userId);
    }

    @Override
    public List<Menu> queryMenuAllList(Menu menu) {
        return MenuDao.queryMenuAllList(menu);
    }

    @Override
    public int addMenu(Menu menu) {
        return MenuDao.addMenu(menu);
    }

    @Override
    public int deleteMenu(Integer id) {
        return MenuDao.deleteMenu(id);
    }

    @Override
    public int checkMenuHasChildren(Integer pid) {
        return MenuDao.checkMenuHasChildren(pid);
    }

    @Override
    public int updateMenu(Menu menu) {
        return MenuDao.updateMenu(menu);
    }


}
