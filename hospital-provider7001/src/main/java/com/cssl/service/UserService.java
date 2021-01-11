package com.cssl.service;

import com.cssl.pojo.DataGridView;
import com.cssl.pojo.User;
import com.cssl.pojo.UserRole;

import java.util.List;

public interface UserService {

    //查询用户
    List<User> selectAllUser(User user);

    //添加用户
    int addUser(User user);

    //添加检查用户唯一
    int checkUser(User user);
    //修改用户
    int updateUser(User user);
    //删除用户
    void deleteUser(Integer userid);

    //重置密码
    int resetUserPwd(User user);

    //查询所有用户角色
    DataGridView queryUserRole(Integer userid);
    //保存用户和角色的关系
    void saveUserRole(UserRole userRole);

}
