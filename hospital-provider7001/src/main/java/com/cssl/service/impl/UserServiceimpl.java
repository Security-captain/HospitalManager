package com.cssl.service.impl;

import com.cssl.dao.UserDao;
import com.cssl.pojo.DataGridView;
import com.cssl.pojo.Role;
import com.cssl.pojo.User;
import com.cssl.pojo.UserRole;
import com.cssl.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class UserServiceimpl implements UserService {

       @Resource
       private UserDao userDao;


    @Override
    public int resetUserPwd(User user) {
        return userDao.resetUserPwd(user);
    }

    @Override
    public List<User> selectAllUser(User user) {
        return userDao.selectAllUser(user);
    }

    @Override
    public int addUser(User user) {
        return userDao.addUser(user);
    }

    @Override
    public int checkUser(User user) {
        return userDao.checkUser(user);
    }

    @Override
    public int updateUser(User user) {
        return userDao.updateUser(user);
    }

    @Override
    public void deleteUser(Integer userid) {
        //根据id删除用户
        userDao.deleteUserById(userid);
        //根据id删除该用户所拥有的角色   中间表
        userDao.deleteRoleUser(userid);
    }

    @Override
    public DataGridView queryUserRole(Integer userid) {
        //按照用户id查询角色
        Integer uid=userid;
        //先查询所有角色
        List<Role> allRole = userDao.queryAllRole();
        //按照用户id查询角色
        List<Role> userRole = userDao.queryRoleById(uid);
        //如果allRole角色的id与userRole角色的id相等那么可以查询该用户已有的角色 复选框为true
        List<Map<String,Object>> data=new ArrayList<>();
        for (Role r1 : allRole) {
            Boolean LAY_CHECKED = false;
            for (Role r2 : userRole) {
                if (r1.getRoleid() == r2.getRoleid()) {
                    LAY_CHECKED = true;
                }
            }
            Map<String, Object> map = new HashMap<String, Object>();

            map.put("roleid", r1.getRoleid());
            map.put("rolename", r1.getRolename());
            map.put("roledesc", r1.getRoledesc());
            map.put("LAY_CHECKED", LAY_CHECKED);
            data.add(map);
        }
        return new DataGridView(data);
    }

    @Override
    public void saveUserRole(UserRole userRole) {
        Integer userid=userRole.getUserid();
        Integer[] roleids=userRole.getIds();
        userDao.deleteRoleUser(userid);
        //循环添加用户分配的角色
        if(roleids!=null&&roleids.length>0){
            for(Integer rid:roleids){
                userDao.insertUserRole(userid,rid);
            }
        }

    }

}