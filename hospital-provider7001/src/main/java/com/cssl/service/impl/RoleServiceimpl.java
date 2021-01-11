package com.cssl.service.impl;

import com.cssl.dao.MenuDao;
import com.cssl.dao.RoleDao;
import com.cssl.pojo.*;
import com.cssl.service.RoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class RoleServiceimpl implements RoleService {

        @Resource
        private RoleDao roleDao;

        @Resource
        private MenuDao menuDao;

    @Override
    public List<Role> loadAllRole(Role role) {
        return roleDao.loadAllRole(role);
    }

    @Override
    public int insertRole(Role role) {
        return roleDao.insertRole(role);
    }

    @Override
    public int updateRole(Role role) {
        return roleDao.updateRole(role);
    }

    @Override
    public int deleteRoleId(Integer roleid) {
        return roleDao.deleteRoleId(roleid);
    }

    @Override
    public int deleteRoleMenuId(Integer roleid) {
        return roleDao.deleteRoleMenuId(roleid);
    }

    @Override
    public int deleteRoleUserId(Integer roleid) {
        return roleDao.deleteRoleUserId(roleid);
    }

    @Override
    public DataGridView initRoleMenuTreeJson(Integer roleid) {
        //查询所有可用菜单
        List<Menu> allmenus = menuDao.loadAvailableMenu();
        //按照角色id查询菜单
        List<Menu> roleMenu=menuDao.queryMenuByRoleId(roleid);
        //如果roleMenu菜单的id与allmenus菜单的id相等那么可以查询该角色已有的菜单 复选框为true 1为选中
        List<TreeNode> data=new ArrayList<>();
        for(Menu m1:allmenus){
            String checkArr="0";
            for(Menu m2:roleMenu){
                if(m1.getId()==m2.getId()){
                    checkArr="1";//选中
                    break;
                }
            }
            Integer id = m1.getId();
            Integer pid = m1.getPid();
            String title = m1.getTitle();
            Boolean spread = m1.getSpread() == true;
            data.add(new TreeNode(id,pid,title,spread,checkArr));
        }
        return new DataGridView(data);
    }

    @Override
    public void saveRoleMenu(RoleMenu roleMenu) {
        Integer rid=roleMenu.getRoleid();
        Integer[] mids=roleMenu.getIds();
        //根据用户id删除角色拥有的菜单
        roleDao.deleteRoleMenuId(rid);
        //循环添加角色分配的菜单
        for(Integer mid:mids){
            roleDao.insertRoleMenu(rid,mid);
        }
    }
}
