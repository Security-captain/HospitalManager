package com.cssl.client;


import com.cssl.pojo.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
//py    门诊管理
@FeignClient(name = "registeredtype")
public interface Nacosfegin {


    //左侧菜单数据

    @RequestMapping("/sel/toTreeLoad")
    public String toTreeLoad();


    /*cao*/

    //查询挂号所有数据
    @RequestMapping("/cao/index")
    //@ResponseBody
    String toreport(@RequestBody ReportVo reportVo, @RequestParam Model model, @RequestParam String params, @RequestParam Integer cc, @RequestParam HttpServletRequest request);


    //查询所有的科室
    @RequestMapping("/cao/seldep")
    @ResponseBody
    public Object seldep();

    //查询所有的挂号类型
    @RequestMapping("/cao/selreg")
    @ResponseBody
    public Object selreg();

    //查询医生信息
    @RequestMapping("/cao/seldoctor")
    @ResponseBody
    public Object seldoctor(@RequestBody CDoctor cDoctor, @RequestParam Integer SE, @RequestParam Integer LX);

    //根据挂号类型查找该类型的价格
    @RequestMapping("/cao/seltymo")
    public Integer seltymo(@RequestBody CRegisteredtype cRegisteredtype, @RequestParam Integer CR);

    //添加新的挂号
    @RequestMapping("/cao/addre")
    public String addre(@RequestBody CReport cReport);

    //根据id删除某个患者信息
    @RequestMapping("/cao/delre")
    @ResponseBody
    public String delre(@RequestParam Integer id);

    //根据id删除某个患者信息
    @RequestMapping("/cao/selById")
    @ResponseBody
    public Object selById(@RequestParam Integer reportId);

    //判断就诊用户电话身份证号唯一
    @RequestMapping("/cao/phone")
    public Object phone(@RequestBody CReport cReport);

    //转入住院部
    @RequestMapping("/cao/zhuanyuan")
    public Object zhuanyuan(@RequestParam Integer id, @RequestBody CReport cReport, @RequestParam String zhuan);


    /*caocc*/

    //查询所有患者信息
    @RequestMapping("/caocc/selpreson")
    public Map<String, Object> selperson(@RequestParam Integer page, @RequestParam Integer limit);

    //查询药品所有信息
    @RequestMapping("/caocc/seldrug")
    @ResponseBody
    public Map<String, Object> seldrug(@RequestParam String durgname, @RequestParam Integer page, @RequestParam Integer limit, @RequestBody CPharmacy cPharmacy);

    //查询该用户所有的处方
    @RequestMapping("/caocc/selall")
    @ResponseBody
    Map<String, Object> selall(@RequestParam Integer perid, @RequestParam Integer page, @RequestParam Integer limit);

    //查询处方中是否有这个药
    @RequestMapping("/caocc/selchu")
    @ResponseBody
    public Object seslchu(@RequestBody CCashier cCashier, @RequestParam Integer reid, @RequestParam String mename);

    //添加处方药品
    @RequestMapping("/caocc/addchu")
    public int addchu(@RequestBody CFTJ cftj);

    @RequestMapping("/caocc/selpepi")
    @ResponseBody
    public Object selpepi(@RequestParam Integer perid, @RequestParam Integer page, @RequestParam Integer limit);

    //删除处方中的药品
    @RequestMapping("/caocc/del")
    public String del(@RequestParam String durnme, @RequestParam Integer durnum, @RequestBody CFTJ cftj);

    //如果处方中有该药品则修改该药品的数量和价钱
    @RequestMapping("/caocc/updchu")
    @ResponseBody
    public Object updchu(@RequestBody CFTJ cftj);

    //模糊查询
    @RequestMapping("/caocc/mohu")
    @ResponseBody
    public Object mohu(@RequestParam String durgname, @RequestBody ReportVo reportVo, @RequestParam Integer page, @RequestParam Integer limit);

    //添加用户病因
    @RequestMapping("/caocc/addbing")
    public Object addbing(@RequestParam Integer reid, @RequestParam String bing, @RequestBody CReport cReport);

    //查询用户有没有填写病因
    @RequestMapping("/caocc/selbing")
    public  String selbing(@RequestParam Integer reid);

    //查看用户的检查结果
    @RequestMapping("/caocc/lookbing")
    @ResponseBody
    public Object lookbing(@RequestParam Integer reid);

    //查看该用户是否还有未交钱的项目
    @RequestMapping("/caocc/seljiao")
    @ResponseBody()
    public Object seljiao(@RequestParam Integer reid);

    //查询用户所有的项目处方
    @RequestMapping("/caocc/selximu")
    @ResponseBody
    public Object selximu(@RequestParam Integer perid, @RequestParam Integer page, @RequestParam Integer limit);

    //查看该用户是否有缴费未做的项目
    @RequestMapping("/caocc/selwei")
    public String selwei(@RequestParam Integer reid);


  /*  caoout  */



    //查询药品所有信息
    @RequestMapping("/caoout/selout")
    @ResponseBody
    public Object seldrug(@RequestBody Coutpatienttype coutpatienttype, @RequestParam Integer page, @RequestParam Integer limit, @RequestParam String projectName);

    //查询处方中是否有这个药
    @RequestMapping("/caoout/selchuo")
    @ResponseBody
    public Object seslchuo(@RequestBody CCashier cCashier, @RequestParam Integer reid, @RequestParam String mename);


    //添加处方药品
    @RequestMapping("/caoout/addchuo")
    @ResponseBody
    public Integer addchuo(@RequestBody CCashier cCashier, @RequestParam Integer ostate);

    //如果处方中有该药品则修改该药品的数量和价钱
    @RequestMapping("/caoout/updchuo")
    @ResponseBody
    public Object updchuo(@RequestParam CCashier cCashier, @RequestBody CPharmacy cPharmacy);

    //删除处方中的药品
    @RequestMapping("/caoout/delo")
    public String del(@RequestBody CCashier cCashier);

    //查询处方的总价钱
    @RequestMapping("/caoout/selch")
    public Object selch(@RequestBody CCashier cCashier);

    @RequestMapping("/caoout/shoufei")
    public Object shoufei(@RequestBody ReportVo reportVo);

   /* xpay*/

    //选择患者后对该患者的项目进行查询
    @RequestMapping("/xpay/selxiang")
    @ResponseBody
    public Object selxiang(@RequestParam Integer page, @RequestParam Integer limit, @RequestParam Integer perid);

    //点击确认收费前确定该患者有没有收费项目
    @RequestMapping("/xpay/selshoux")
    @ResponseBody
    public Object selshoux(@RequestParam Integer perid);

    //项目缴费修改项目的收费状态
    @RequestMapping("/xpay/shoufei")
    @ResponseBody
    public Object shoufei(@RequestParam Integer perid);

    //查询该用户的所有要检查的项目
    @RequestMapping("/xpay/selcha")
    @ResponseBody
    public Object selcha(@RequestParam Integer page, @RequestParam Integer limit, @RequestParam Integer perid);

    //添加用户项目的检查结果
    @RequestMapping("/xpay/addbing")
    @ResponseBody
    public Object addbing(@RequestBody CCashier cCashier, @RequestParam Integer reid, @RequestParam String bing, @RequestParam Integer cashier);


   /* caotake*/

    //查询所有患者信息
    @RequestMapping("/caotake/tselpreson")
    @ResponseBody
    public Object tselperson(@RequestParam Integer page, @RequestParam Integer limit);

    //修改用户状态
    @RequestMapping("/caotake/chuku")
    @ResponseBody
    public Object chuku(@RequestBody ReportVo reportVo);

    //查看患者信息
    @RequestMapping("/caotake/selhuan")
    @ResponseBody
    public Object selhuan(@RequestBody ReportVo reportVo, @RequestParam Integer page, @RequestParam Integer limit);

    //查看该用户的总价格
    @RequestMapping("/caotake/zong")
    @ResponseBody
    public Object zong(@RequestParam Integer reid);

}
