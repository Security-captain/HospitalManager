package com.cssl.controller;

import com.cssl.pojo.Menu;
import com.cssl.pojo.TreeNode;
import com.cssl.pojo.User;
import com.cssl.service.MenuService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jalon
 * @date 2020-12-4 10:43
 * 登陆
 * 加载左侧边栏
 */
@RestController               //充当提供者返回数据时用
@RequestMapping("/sel")
//@Controller                 //单层
public class MenuController {

    @Autowired
    private MenuService menuService;

    //跳转到登陆页面
    @RequestMapping("toLogin")
    public String toLogin() {
        return "view/login";
    }

    //登陆   shiro登陆
    @RequestMapping("login")
    public Map<String,Object> login(HttpServletRequest request,String loginname, String pwd) {
        //用map储存
        Map<String,Object> mp = new HashMap<>();
        //第一步：建立subject
        Subject subject = SecurityUtils.getSubject();
        //第二步：封装token  凭证
        UsernamePasswordToken token = new UsernamePasswordToken(loginname,pwd);
        //第三步   登陆
        try {
            //只要能通过认证就能通过了
            subject.login(token);
            User users = menuService.loginname(loginname);      //名字查用户

            //把user放进session
            request.getSession().setAttribute("user", users);
            //把yonghu放进session
            request.getSession().setAttribute("yonghu", users.getRealname());

            System.out.println("login****************************"+users.getRealname());
            mp.put("user",users);
            mp.put("flag",1);
            return mp;
        }catch (UnknownAccountException e){
            //用户为空，或不存在
            mp.put("flag",2);
            return mp;
        } catch (IncorrectCredentialsException e){
            //密码不对
            mp.put("flag",3);
            return mp;
        }
    }


    /*
     * 加载首页左边导航栏
     * */
    @RequestMapping("toTreeLoad")
    public List<TreeNode> toTreeLoad(Integer userid) {
        System.out.println("~~~~~~~~~~~~~~~~~导航栏~~~~~~~~~~~~~~~~~~~~~~");
        //获取用户登陆id根据不同的用户有不停菜单
        List<Menu> list = menuService.queryMenuByUid(userid);
        //创建list集合
        //把list放入nodes
        List<TreeNode> nodes = new ArrayList<>();
        for (Menu menus : list) {
            Integer id = menus.getId();
            Integer pid = menus.getPid();
            String title = menus.getTitle();
            String icon = menus.getIcon();
            String href = menus.getHref();
            Boolean spread = menus.getSpread() == true;
            String target = menus.getTarget();
            nodes.add(new TreeNode(id, pid, title, icon, href, spread, target));
        }
        //组装菜单
        List<TreeNode> treeNodes = new ArrayList<>();
        //n1.getPid() == 1 为父级菜单
        for (TreeNode n1 : nodes) {
            if (n1.getPid() == 1) {
                treeNodes.add(n1);
            }
            //将n2放入n1的子级中   id为子级
            for (TreeNode n2 : nodes) {
                if (n2.getPid() == n1.getId()) {
                    n1.getChildren().add(n2);
                }
            }
        }
        return treeNodes;
    }

}
