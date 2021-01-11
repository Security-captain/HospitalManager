package com.cssl.controller;

import com.cssl.client.SystemClient;
import com.cssl.pojo.DataGridView;
import com.cssl.pojo.User;
import com.cssl.pojo.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

//dy 用户
@Controller
@RequestMapping("user")
public class UserController {

                 @Autowired
                 private SystemClient systemClient;


                //查询所有用户
                @RequestMapping("selectAllUser")
                @ResponseBody
                public Object selectAllUser(User user, Integer page, Integer limit){
                    return systemClient.selectAllUser(user,page,limit);
                }


                /*
                 * 添加用户
                 * */
                @RequestMapping("addUser")
                @ResponseBody
                public String addUser(User user){
                       return systemClient.addUser(user);
                }

                /*
                   修改用户
                 */
                @RequestMapping("updateUser")
                @ResponseBody
                public String updateUser(User user){
                    return systemClient.updateUser(user);
                }

                /*
                 * 删除用户
                 * */
                @RequestMapping("deleteUser")
                @ResponseBody
                public String deleteUser(Integer userid){
                    return systemClient.deleteUser(userid);
                }

                /*
                 * 重置密码
                 * */
                @RequestMapping("resetUserPwd")
                @ResponseBody
                public String resetUserPwd(User user,Integer userid){
                    return systemClient.resetUserPwd(user,userid);
                   }
                /*
                 * 初始化用户分配角色
                 * */
                @RequestMapping("initUserRole")
                @ResponseBody
                public DataGridView initUserRole(Integer userid){
                    return systemClient.initUserRole(userid);
                }

                /*
                 * 保存用户和角色的关系
                 * */
                @RequestMapping("saveUserRole")
                @ResponseBody
                public String saveUserRole(UserRole userRole){
                    return systemClient.saveUserRole(userRole);
                }

}
