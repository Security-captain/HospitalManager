package com.cssl.controller;

import com.cssl.client.MenuClient;
import com.cssl.pojo.TreeNode;
import com.cssl.pojo.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * @author jalon
 * @date 2020-12-8 10:51
 *  * 登陆
 *  * 加载左侧边栏
 */
@Controller
@RequestMapping("/sel")
public class MenuController {

    @Autowired
    private MenuClient client;

    //跳转到登陆页面
    @RequestMapping("toLogin")
    public String toLogin() {
        return "view/login";
    }

    //登陆   shiro登陆              !!!!!!!!!!!!!!!
    @RequestMapping("login")
    public String login(Model model, HttpServletRequest request, String loginname, String pwd) {
        Map<String,Object> mpp = client.login(loginname,pwd);
        Object fl = mpp.get("flag");
        System.out.println("fl =================== " + fl);         //标识登陆状态
        if(fl.equals(2)){
            //用户为空，或不存在
            model.addAttribute("msg","不存在这样的用户!");
            return "view/login";
        }else if(fl.equals(3)){
            model.addAttribute("msg","密码输入不正确！");
            return "view/login";
        }else{
            //取出map中的user，转换为实体对象
            ObjectMapper objectMapper = new ObjectMapper();
            User u = objectMapper.convertValue(mpp.get("user"),User.class);
            System.out.println("-----------------------"+u.getRealname());

            //把user放进session
            request.getSession().setAttribute("user",u);
            model.addAttribute("loginname",u.getRealname());
            model.addAttribute("id",u.getUserid());
            return "view/index";
        }

    }

    /*
     * 加载首页左边导航栏
     * */
    @RequestMapping("toTreeLoad")
    @ResponseBody
    public List<TreeNode> toTreeLoad( HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        Integer id = user.getUserid();
        System.out.println("用户：----------------------"+user.getUserid());
        List<TreeNode> treeNodes = client.toTreeLoad(id);
        return treeNodes;
    }

}
