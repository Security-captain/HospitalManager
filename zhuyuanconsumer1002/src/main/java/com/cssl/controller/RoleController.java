package com.cssl.controller;

import com.cssl.client.SystemClient;
import com.cssl.pojo.DataGridView;
import com.cssl.pojo.Role;
import com.cssl.pojo.RoleMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


//dy 角色-权限
@Controller
@RequestMapping("role")
public class RoleController {

                @Autowired
                private SystemClient systemClient;

                /*
                    查询所有权限
                */
                @RequestMapping("loadAllRole")
                @ResponseBody
                public Object loadAllRole(Role role, Integer page, Integer limit) {
                    return systemClient.loadAllRole(role,page,limit);
                }

                //新增权限
                @RequestMapping("insertRole")
                @ResponseBody
                public String insertRole(Role role){
                       return systemClient.insertRole(role);
                }

                //修改权限
                @RequestMapping("updateRole")
                @ResponseBody
                public String updateRole(Role role){
                      return systemClient.updateRole(role);
                }


                //删除角色权限
                @RequestMapping("deleteRole")
                @ResponseBody
                public String deleteRole(Integer roleid){
                    return systemClient.deleteRole(roleid);
                }


                //加载角色管理分配菜单
                @RequestMapping("initRoleMenuTreeJson")
                @ResponseBody
                public DataGridView initRoleMenuTreeJson(Integer roleid) {
                    return systemClient.initRoleMenuTreeJson(roleid);
                }

                //保存角色和菜单的关系
                @RequestMapping("saveRoleMenu")
                @ResponseBody
                public String saveRoleMenu(RoleMenu roleMenu){
                    return systemClient.saveRoleMenu(roleMenu);
                }
}
