package com.cssl.controller;

import com.cssl.pojo.*;
import com.cssl.service.LiaoAdminService;
import com.cssl.service.LiaoLeaveService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * --------------------入院登记
 * @author jalon
 * @date 2020-12-4 15:37
 */
@RestController
//@Controller
//@RequestMapping("/liao")
public class LiaoadminController {

    //入院登记服务
    @Autowired
    private LiaoAdminService liaoAdminService;
    //出院服务
    @Autowired
    private LiaoLeaveService liaoLeaveService;

    //查询患者信息
    @RequestMapping("selRegister")
    //@ResponseBody
    public Map<String, Object> selRegister(Integer page,Integer limit,@RequestBody Register register){
        //分页查询
        PageHelper.startPage(page, limit);
        //查询未出院的患者信息
        List<Register> selreg=liaoAdminService.selRegister(register);
        //把查到的信息放入分页插件中
        PageInfo pageInfo = new PageInfo(selreg);
        Map<String, Object> tableData = new HashMap<String, Object>();
        //这是layui要求返回的json数据格式
        tableData.put("code", 0);
        tableData.put("msg", "");
        //将全部数据的条数作为count传给前台（一共多少条）
        tableData.put("count", pageInfo.getTotal());
        //将分页后的数据返回（每页要显示的数据）
        tableData.put("data", pageInfo.getList());
        //把数据返回到layui中
        return tableData;
    }

    //页面请求查询科室信息
    @RequestMapping("selDepartment")
    //@ResponseBody
    public Object selDepartment(){
        //new一个实体类
        Departments departments=new Departments();
        //查询所有科室
        List<Departments> Departments= liaoAdminService.selDepartment(departments);
        //把查到的科室返回前台下拉框中
        return Departments;
    }

    //页面请求查询医生信息
    @RequestMapping("selDoctor")
    public Object selDoctor(Integer departmentId){
        //new一个实体类
        Doctor doctor=new Doctor();
        //把获取过来的科室编号放入实体类中
        doctor.setDepartmentId(departmentId);
        //根据科室查询旗下所有医生
        List<Doctor> doctors = liaoAdminService.selDoctor(doctor);
        //把查到的医生返回前台下拉框中
        return doctors;
    }

    //查询床位
    @RequestMapping("selBed")
    public Object selBed(Integer departmentId){
        Bed bed= new Bed();
        //7内科 8外科
        bed.setDepartmentId(departmentId);
        //查询没有人入住的床位
        bed.setState(0);
        List<Bed> beds = liaoAdminService.selBed(bed);
        return beds;
    }

    //添加患者
    @RequestMapping("addRegister")
    //@ResponseBody
    public int addRegister(@RequestBody Register register, HttpServletRequest request){
        System.out.println("P register ============= " + register);

        Register register1=new Register();
        register1.setIdcard(register.getIdcard());
        //把患者的身份证号查询一下看看是否已经办理入住
        List<Register> registers = liaoAdminService.selRegister(register1);
        if(registers.size()==0){
            //如果是门诊转过来的用户删除门诊患者信息   改状态为5
            if(register.getReportid()!=0){
                liaoAdminService.updZ(register);
            }
            //获取管理人员姓名
            String yonghu = (String)request.getSession().getAttribute("yonghu");
            register.setOperator(yonghu);
            //添加患者信息
            int i = liaoAdminService.addRegister(register);
            if(i==1){
                //修改床位状态
                int j = liaoAdminService.updBed(register);
                if(j==1){
                    return 1;   //成功
                }else{
                    return 0;
                }
            }else{
                return 0;       //失败
            }
        }else{
            return 2;   //存在
        }
    }

    //查询折扣
    @RequestMapping("selDis")
    //@ResponseBody
    public Object selDis(){
        List<Moneytype> moneytypes = liaoAdminService.selDis();
        return moneytypes;
    }

    //查询门诊过来的患者
    @RequestMapping("selDoor")
    //@ResponseBody
    public Object selDoor(Integer page, Integer limit){
        PageHelper.startPage(page, limit);
        List<Register> selDoor=liaoAdminService.selDoor();
        PageInfo pageInfo = new PageInfo(selDoor);
        Map<String, Object> tableData = new HashMap<String, Object>();
        //这是layui要求返回的json数据格式
        tableData.put("code", 0);
        tableData.put("msg", "");
        //将全部数据的条数作为count传给前台（一共多少条）
        tableData.put("count", pageInfo.getTotal());
        //将分页后的数据返回（每页要显示的数据）
        tableData.put("data", pageInfo.getList());
        return tableData;
    }

    //转科室
    @RequestMapping("updKe")
    //@ResponseBody
    public int updKe(@RequestBody Register register){
        System.out.println("转科室---------------------"+"\n"+register);
        //把用户要住的床改成已住
        liaoAdminService.updBed(register);
        //把用户的曾经床位改成空床
        liaoLeaveService.updBstate(register);
        //把用户的信息进行更改
        int i = liaoAdminService.updKe(register);
        if(i==1){
            return i;
        }else{
            return 0;
        }
    }

}
