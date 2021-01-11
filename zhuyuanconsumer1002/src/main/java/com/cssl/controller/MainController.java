package com.cssl.controller;

import com.cssl.client.MenuClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * @author jalon
 * @date 2020-12-25 17:23
 * jia  后台首页展示的main页面
 */
@Controller
@RequestMapping("main")
public class MainController {

    @Autowired
    private MenuClient menuClient;

    @RequestMapping("one")
    @ResponseBody
    public Object one(){
        return menuClient.one();
    }
    @RequestMapping("two")
    @ResponseBody
    public Object two(){
        return menuClient.two();
    }
    @RequestMapping("three")
    @ResponseBody
    public Object three(){
        return menuClient.three();
    }
    @RequestMapping("four")
    @ResponseBody
    public Object four(){
        return menuClient.four();
    }
    @RequestMapping("five")
    @ResponseBody
    public Object five(){
        return menuClient.five();
    }
    @RequestMapping("six")
    @ResponseBody
    public Object six(){
        return menuClient.six();
    }
    @RequestMapping("seven")
    @ResponseBody
    public Object seven(){
        return menuClient.seven();
    }
    /*
     * 查询当天门诊人数
     * */
    @RequestMapping("currentNum")
    @ResponseBody
    public Object currentNum(){
        return menuClient.currentNum();
    }
    /*
     * 查询所有人数
     * */
    @RequestMapping("Total")
    @ResponseBody
    public Object Total(){
        return menuClient.Total();
    }
    /*
     * 查询住院所有人数
     * */
    @RequestMapping("zhuyuanTotal")
    @ResponseBody
    public Object zhuyuanTotal(){
        return menuClient.zhuyuanTotal();
    }
    /*
     * 查询当天住院所有人数
     * */
    @RequestMapping("currentZhuYuan")
    @ResponseBody
    public Object currentZhuYuan(){
        return menuClient.currentZhuYuan();
    }

}
