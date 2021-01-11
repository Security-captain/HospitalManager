package com.cssl.controller;


import com.cssl.client.Nacosfegin;
import com.cssl.pojo.CCashier;
import com.cssl.pojo.CPharmacy;
import com.cssl.pojo.Coutpatienttype;
import com.cssl.pojo.ReportVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

//py 划价
@Controller
@RequestMapping("caoout")
public class yaowujiaofei {
    @Autowired
    private Nacosfegin nacosfegin;

    //进入项目划价页面
    @RequestMapping("xiang")
    public Object xiang(Model model)
    {
        return  "cao/Cxiangmu";
    }

    //进入收费页面
    @RequestMapping("out")
    public Object look()
    {
        return  "cao/Ctoll";
    }

    //查询项目药品所有信息
    @RequestMapping("selout")
    @ResponseBody
    public Object seldrug(Coutpatienttype coutpatienttype, Integer page, Integer limit, String projectName){
        return nacosfegin.seldrug(coutpatienttype,page,limit,projectName);
    }

    //查询处方中是否有这个药
    @RequestMapping("selchuo")
    @ResponseBody
    public Object seslchuo(CCashier cCashier, Integer reid, String mename){
        System.out.println("//查询处方中是否有这个药");
        return nacosfegin.seslchuo(cCashier,reid,mename);
    }
    //添加处方药品
    @RequestMapping("addchuo")
    @ResponseBody
    public Object addchuo(CCashier cCashier,Integer ostate){
        System.out.println("//添加处方药品");

        Object addchuo=nacosfegin.addchuo(cCashier,ostate);

        return addchuo;
    }

    //如果处方中有该药品则修改该药品的数量和价钱
    @RequestMapping("updchuo")
    @ResponseBody
    public Object updchuo(CCashier cCashier, CPharmacy cPharmacy){
        //修改处方中药品的数量
        return nacosfegin.updchuo(cCashier,cPharmacy);
    }

    //删除处方中的药品
    @RequestMapping("delo")
    @ResponseBody
    public String del(CCashier cCashier){
        System.out.println(nacosfegin.del(cCashier));
        return nacosfegin.del(cCashier);
    }

    //查询处方的总价钱
    @RequestMapping("selch")
    @ResponseBody
    public Object selch( CCashier cCashier){
        System.out.println(" //查询处方的总价钱");
        System.out.println(nacosfegin.selch(cCashier));
        return nacosfegin.selch(cCashier);
    }

    @RequestMapping("shoufei")
    @ResponseBody
    public Object shoufei(ReportVo reportVo){
        return nacosfegin.shoufei(reportVo);
    }

}
