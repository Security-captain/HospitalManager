package com.cssl.dao;

import com.cssl.pojo.Menu;
import com.cssl.pojo.User;

import java.util.List;

public interface MenuDao {

         User loginname(String loginname);
        //查询所有菜单   模糊查询
        List<Menu> queryMenuAllList(Menu menu);

         //新增菜单
         public int MenuAdd(Menu menu);

            //查询所有菜单
            List<Menu> queryMenuByUid(Integer userid);
            List<Menu> loadAvailableMenu();

         //删除菜单
         public int deleteMenu(int id);

        //检查父级中是否有子级菜单
        public int checkMenuHasChildren(Integer pid);

         //修改菜单
         public int MenuUp(Menu menu);

         //按照角色id查询菜单
         List<Menu> queryMenuByRoleId(Integer roleid);
}
