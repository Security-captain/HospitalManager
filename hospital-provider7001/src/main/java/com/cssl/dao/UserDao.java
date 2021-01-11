package com.cssl.dao;

import com.cssl.pojo.DataGridView;
import com.cssl.pojo.Role;
import com.cssl.pojo.RoleMenu;
import com.cssl.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserDao {

    //查询
    List<User> selectAllUser(User user);

    //添加用户
    int addUser(User user);

    //添加检查用户唯一
    int checkUser(User user);

    //修改用户
    int updateUser(User user);

    //删除用户
    void deleteUser(Integer userid);
    int deleteUserById(Integer userid);
    int deleteRoleUser(Integer userid);
    //重置密码
    int resetUserPwd(User user);

    //查询所有用户角色
    DataGridView queryUserRole(Integer userid);
    //查询所有角色
    List<Role> queryAllRole();
    //按照用户id查询角色
    List<Role> queryRoleById(Integer uid);
    //保存角色和菜单
    void saveRoleMenu(RoleMenu roleMenu);
    //保存用户和角色
    void insertUserRole(@Param("uid")Integer userid, @Param("rid")Integer rid);



}
