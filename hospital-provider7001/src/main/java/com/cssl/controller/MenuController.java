package com.cssl.controller;


import com.cssl.pojo.DataGridView;
import com.cssl.pojo.Menu;
import com.cssl.pojo.TreeNode;
import com.cssl.pojo.User;
import com.cssl.service.MenuService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//dy
@RestController
public class MenuController {

          @Autowired
          private MenuService menuService;


             //查询所有菜单MenuRight
             @RequestMapping("queryMenuAllList")
             public  Map<String,Object>  queryMenuAllList(@RequestBody Menu menu, Integer page, Integer limit){
                 PageHelper.startPage(page,limit);
                 List<Menu> list=menuService.queryMenuAllList(menu);
                 PageInfo pageInfo = new PageInfo(list);
                 Map<String, Object> map = new HashMap<>();
                 //layui要求返回的json数据格式
                 map.put("code", 0);
                 map.put("msg", "");
                 //将全部数据的条数作为count传给前台
                 map.put("count", pageInfo.getTotal());
                 //分页后数据返回(每页返回数据)
                 map.put("data", pageInfo.getList());
                 return map;
             }

            /*
             * 加载菜单管理左边的菜单树
             * */
            @RequestMapping("loadMenuMangerLeftTreeJson")
            public DataGridView loadMenuMangerLeftTreeJson(@RequestBody Menu menu) {
                //查询所有菜单
                List<Menu> list = menuService.queryMenuAllList(menu);
                System.out.println("................................"+list);
                //将查询的菜单循环放入TreeNode
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
                return new DataGridView(nodes);
            }


            //删除菜单
            @RequestMapping("deleteMenu")
            public String deleteMenu(int id){

                int num=menuService.deleteMenu(id);
                return "true";
            }

            //检查父级是否有子级菜单
           @RequestMapping("checkMenuHasChildren")
           public String checkMenuHasChildren(Integer id) {
               int pid_num = menuService.checkMenuHasChildren(id);
               if (pid_num <= 0) {
                   return "1";
               } else {
                   return "0";
               }
           }

           /*
             新增菜单
            */
           @RequestMapping("addMenu")
           public String addMenu(@RequestBody Menu menu){
               int i = menuService.addMenu(menu);
               if (i == 1) {
                   return "添加成功";
               } else {
                   return "添加失败";
               }
           }


           /*
            * 修改菜单
            */
           @RequestMapping("updateMenu")
           public String updateMenu(@RequestBody Menu menu) {
               menuService.updateMenu(menu);
               return "修改成功";
           }

}
