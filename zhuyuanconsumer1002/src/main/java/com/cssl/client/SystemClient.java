package com.cssl.client;

import com.cssl.pojo.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

//dy      系统管理
@FeignClient(name="nacos-provider7001")
public interface SystemClient {

     /*
       *
       * 菜单块
      */

    //查看菜单
    @RequestMapping("queryMenuAllList")
    public Map<String,Object> queryMenuAllList(@RequestBody Menu menu, @RequestParam Integer page, @RequestParam Integer limit);

    //加载菜单管理左边的菜单树
    @RequestMapping("loadMenuMangerLeftTreeJson")
    public DataGridView loadMenuMangerLeftTreeJson(@RequestBody Menu menu);

    //删除菜单
    @RequestMapping("deleteMenu")
    public String deleteMenu(@RequestParam int id);

    //检查父级是否有子级菜单
    @RequestMapping("checkMenuHasChildren")
    public String checkMenuHasChildren(@RequestParam Integer id);

    //新增菜单
    @RequestMapping("addMenu")
    public String addMenu(@RequestBody Menu menu);

    //修改菜单
    @RequestMapping("updateMenu")
    public String updateMenu(@RequestBody Menu menu);



    /*
       权限块
     */

    //查询所有角色权限
    @RequestMapping("loadAllRole")
    public Map<String,Object> loadAllRole(@RequestBody Role role, @RequestParam Integer page, @RequestParam Integer limit);

    //新增角色
    @RequestMapping("insertRole")
    public String insertRole(@RequestBody Role role);

    //修改角色
    @RequestMapping("updateRole")
    public String updateRole(@RequestBody Role role);

    //删除角色权限
    @RequestMapping("deleteRole")
    public String deleteRole(@RequestParam Integer roleid);

    //保存角色和菜单的关系
    @RequestMapping("initRoleMenuTreeJson")
    public DataGridView initRoleMenuTreeJson(@RequestParam Integer roleid);

    //保存角色和菜单的关系
    @RequestMapping("saveRoleMenu")
    public String saveRoleMenu(@RequestBody RoleMenu roleMenu);



    /*
      *
      * 用户块
     */

    //查询所有用户
    @RequestMapping("selectAllUser")
    public Map<String,Object> selectAllUser(@RequestBody User user, @RequestParam Integer page, @RequestParam Integer limit);

    /*
     * 添加用户
     * */
    @RequestMapping("addUser")
    public String addUser(@RequestBody User user);

    /*
     * 修改用户
     * */
    @RequestMapping("updateUser")
    public String updateUser(@RequestBody User user);

    /*
     * 删除用户
     * */
    @RequestMapping("deleteUser")
    public String deleteUser(@RequestParam Integer userid);

    /*
     * 重置密码
     * */
    @RequestMapping("resetUserPwd")
    public String resetUserPwd(@RequestBody User user, @RequestParam Integer userid);

    /*
     * 初始化用户分配角色
     * */
    @RequestMapping("initUserRole")
    public DataGridView initUserRole(@RequestParam Integer userid);

    /*
     * 保存用户和角色的关系
     * */
    @RequestMapping("saveUserRole")
    public String saveUserRole(@RequestBody UserRole userRole);

}
