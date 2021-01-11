package com.cssl.service;

import com.cssl.pojo.DataGridView;
import com.cssl.pojo.Role;
import com.cssl.pojo.RoleMenu;

import java.util.List;

public interface RoleService {

    //加载所有角色
    List<Role> loadAllRole(Role role);

    //新增角色
    int insertRole(Role role);

    //修改角色
    int updateRole(Role role);

    //删除角色
    int deleteRoleId(Integer roleid);

    //删除角色和菜单关系
    int deleteRoleMenuId(Integer roleid);

    //删除角色与用户的管理
    int deleteRoleUserId(Integer roleid);

    //初始角色菜单
    DataGridView initRoleMenuTreeJson(Integer roleid);
    //保存角色与菜单的关系
    void saveRoleMenu(RoleMenu roleMenu);
}
