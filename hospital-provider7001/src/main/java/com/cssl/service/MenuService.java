package com.cssl.service;

import com.cssl.pojo.Menu;
import com.cssl.pojo.User;

import java.util.List;

public interface MenuService {
    //登陆
    User loginname(String loginname);
    //查询所有菜单 模糊查询
    List<Menu> queryMenuAllList(Menu menu);

    //查询所有菜单
    List<Menu> queryMenuByUid(Integer userid);
    //查询可用菜单
    List<Menu> loadAvailableMenu();


    //检查父级中是否有子级菜单
    public int checkMenuHasChildren(Integer pid);

    //新增菜单
    public int addMenu(Menu menu);

    //删除菜单
    public int deleteMenu(int id);

    //修改菜单
    public int updateMenu(Menu menu);

}
