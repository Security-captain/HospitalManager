package com.cssl.controller;

import com.cssl.pojo.DataGridView;
import com.cssl.pojo.Role;
import com.cssl.pojo.RoleMenu;
import com.cssl.service.RoleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class RoleController {

    @Autowired
    private RoleService roleService;


    @RequestMapping("loadAllRole")
    public Map<String,Object> loadAllRole(@RequestBody Role role, Integer page, Integer limit) {
        PageHelper.startPage(page, limit);
        List<Role> list = roleService.loadAllRole(role);
        PageInfo pageInfo = new PageInfo(list);
        Map<String, Object> tableData = new HashMap<String, Object>();
        //这是layui要求返回的json数据格式
        tableData.put("code", 0);
        tableData.put("msg", "");
        //将全部数据的条数作为count传给前台（一共多少条）
        tableData.put("count", pageInfo.getTotal());
        //将分页后的数据返回（每页要显示的数据）
        tableData.put("data", pageInfo.getList());
        return tableData;
    }

    @RequestMapping("insertRole")
    public String insertRole(@RequestBody Role role) {
        int i = roleService.insertRole(role);
        if (i == 1) {
            return "添加成功";
        } else {
            return "添加失败";
        }
    }


    @RequestMapping("updateRole")
    public String updateRole(@RequestBody Role role) {
        int i = roleService.updateRole(role);
        if (i == 1) {
            return "修改成功";
        } else {
            return "修改失败";
        }
    }

    @RequestMapping("deleteRole")
    public String deleteRole(Integer roleid) {
        roleService.deleteRoleId(roleid);
        roleService.deleteRoleUserId(roleid);
        roleService.deleteRoleMenuId(roleid);
        return "删除成功";

    }

    //加载角色管理分配菜单
    @RequestMapping("initRoleMenuTreeJson")
    public DataGridView initRoleMenuTreeJson(Integer roleid) {
        return roleService.initRoleMenuTreeJson(roleid);
    }

    //保存角色和菜单的关系
    @RequestMapping("saveRoleMenu")
    public String saveRoleMenu(@RequestBody RoleMenu roleMenu){
        roleService.saveRoleMenu(roleMenu);
        return "分配成功";
    }
}
