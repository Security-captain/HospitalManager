package com.cssl.controller;

import com.cssl.client.Nacosfegin;
import com.cssl.pojo.CDoctor;
import com.cssl.pojo.CRegisteredtype;
import com.cssl.pojo.CReport;
import com.cssl.pojo.ReportVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

//py 门诊挂号
@Controller
@RequestMapping("cao")
public class menzhenController {
    @Autowired
    private Nacosfegin nacosfegin;


//门诊挂号页面


    //查询挂号所有数据
    @RequestMapping("/index")
@ResponseBody
    public Object toreport(ReportVo reportVo,Model model, String params, Integer cc, HttpServletRequest request){
        System.out.println("//查询挂号所有数据");
        Object toreport=nacosfegin.toreport(reportVo,model,params,cc,request);

        System.out.println("*********");
        System.out.println(reportVo);
        System.out.println(model);
        System.out.println(params);
        System.out.println(cc);
        System.out.println(request);
        System.out.println("*********");
        return toreport;

    }

    //查询所有的科室
    @RequestMapping("/seldep")
    @ResponseBody
    public Object seldep(){
        System.out.println("//查询所有的科室");
        return nacosfegin.seldep();

    }

    //查询所有的挂号类型
    @RequestMapping("/selreg")
    @ResponseBody
    public Object selreg(){
        System.out.println("//查询所有的挂号类型");
        return nacosfegin.selreg();

    }

    //查询医生信息
    @RequestMapping("seldoctor")
    @ResponseBody
    public Object seldoctor(CDoctor cDoctor, Integer LX, Integer SE){
        System.out.println("//查询医生信息");

        LX=cDoctor.getRegisteredid();
        SE=cDoctor.getDepartmentId();


        System.out.println(nacosfegin.seldoctor(cDoctor,SE,LX));
        return nacosfegin.seldoctor(cDoctor,SE,LX);
    }
    //根据挂号类型查找该类型的价格
    @RequestMapping("seltymo")
    @ResponseBody
    public Object seltymo(CRegisteredtype cRegisteredtype,Integer CR){
        System.out.println("//根据挂号类型查找该类型的价格");

   //     return this.restTemplate.getForObject("http://registeredtype/cao/seltymo", String.class);

        System.out.println(cRegisteredtype.getRegisteredId());
        Integer cR=cRegisteredtype.getRegisteredId();
        CR=cR;
        Integer seltymo=nacosfegin.seltymo(cRegisteredtype,CR);
        System.out.println(seltymo);
        return seltymo;

    }
    //添加新的挂号
    @RequestMapping("addre")
    @ResponseBody
    public String addre( CReport cReport){

        System.out.println("//添加新的挂号");
        return nacosfegin.addre(cReport);
    }

    //根据id删除某个患者信息
    @RequestMapping("delre")
    @ResponseBody
    public Object delre(Integer id){
        System.out.println("//根据id删除某个患者信息1");
        String delre=nacosfegin.delre(id);
        return delre;

    }
    //根据id删除某个患者信息
    @RequestMapping("selById")
    @ResponseBody
    public Object selById(Integer reportId){
        System.out.println("//根据id删除某个患者信息2");
        return nacosfegin.selById(reportId);
    }

    //判断就诊用户电话身份证号唯一
    @RequestMapping("phone")
    @ResponseBody
    public Object phone(CReport cReport){

        return nacosfegin.phone(cReport);
    }
    //转入住院部
    @RequestMapping("zhuanyuan")
    @ResponseBody
    public Object zhuanyuan(Integer id,CReport cReport,String zhuan){
        return nacosfegin.zhuanyuan(id,cReport,zhuan);
    }
}
