package com.cssl.controller;

import com.cssl.config.UserCredentialsMatcher;
import com.cssl.pojo.DataGridView;
import com.cssl.pojo.User;
import com.cssl.pojo.UserRole;
import com.cssl.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.print.DocFlavor;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UserController {

              @Autowired
              private UserService userService;

    //查询所有用户 模糊
    @RequestMapping("selectAllUser")
    public Map<String,Object> selectAllUser(@RequestBody User user, Integer page, Integer limit){
        PageHelper.startPage(page, limit);
        List<User> list = userService.selectAllUser(user);
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

    /*
     * 添加用户
     * */
    @RequestMapping("addUser")
    public String addUser(@RequestBody User user){
        int i1 = userService.checkUser(user);
        if(i1==1){
            return "当前登陆名已存在";
        }else {
            //加盐
            String salt = UserCredentialsMatcher.generateSalt(6);
            //MD5加密迭代两次
            user.setPwd(UserCredentialsMatcher.encryptPassword("md5", "123456", salt, 2));
            user.setType(2);
            user.setSalt(salt);
            System.out.println(salt);
            int i = userService.addUser(user);
            if (i > 0) {
                return "添加成功";
            } else {
                return "添加失败";
            }
        }
    }

    /*
     * 修改用户
     * */
    @RequestMapping("updateUser")
    public String updateUser(@RequestBody User user){
           int i=userService.updateUser(user);
           if(i>0){
               return "修改成功";
           }else{
               return "修改失败";
           }
    }


    /*
     * 删除用户
     * */
    @RequestMapping("deleteUser")
    public String deleteUser(Integer userid){
        userService.deleteUser(userid);
        return "删除成功";
    }

    /*
     * 重置密码
     * */
    @RequestMapping("resetUserPwd")
    public String resetUserPwd(User user,Integer userid){
        user.setUserid(userid);
        //加盐
        String salt = UserCredentialsMatcher.generateSalt(6);
        //MD5加密迭代两次
        user.setPwd(UserCredentialsMatcher.encryptPassword("md5", "123456", salt, 2));
        user.setType(2);
        user.setSalt(salt);
        userService.resetUserPwd(user);
        return "重置成功";
    }

    /*
     * 初始化用户分配角色
     * */
    @RequestMapping("initUserRole")
    public DataGridView initUserRole(Integer userid){
        return userService.queryUserRole(userid);
    }


    /*
     * 保存用户和角色的关系
     * */
    @RequestMapping("saveUserRole")
    public String saveUserRole(@RequestBody UserRole userRole){
        userService.saveUserRole(userRole);
        return "分配成功";
    }
}


