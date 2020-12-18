package com.cssl.client;

import com.cssl.pojo.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * @author jalon
 * @date 2020-12-8 11:02
 * feign调用
 */
@FeignClient(name = "zhuyuanprovider1001")
public interface MenuClient {

    //登陆      查用户信息
    @RequestMapping("login")
    public Map<String,Object> login(@RequestParam String loginname, @RequestParam String pwd);

    //加载后台首页左导航栏
    @RequestMapping("toTreeLoad")
    public List<TreeNode> toTreeLoad(@RequestParam Integer userid);

    /**
     * liaoAdmin    入院登记
     */
    @RequestMapping("selRegister")
    public Map<String,Object> selRegister(@RequestParam Integer page,@RequestParam Integer limit,@RequestBody Register register);
    @RequestMapping("selDepartment")
    public Object selDepartment();
    @RequestMapping("selDoctor")
    public Object selDoctor(@RequestParam Integer departmentId);
    @RequestMapping("selBed")
    public Object selBed(@RequestParam Integer departmentId);
    @RequestMapping("addRegister")
    public int addRegister(@RequestBody Register register);
    @RequestMapping("selDis")
    public Object selDis();
    @RequestMapping("selDoor")
    public Object selDoor(@RequestParam Integer page,@RequestParam  Integer limit);
    @RequestMapping("updKe")
    public int updKe(@RequestBody Register register);

    /*
    * liaoItem      项目记账
    * */
    @RequestMapping("selItems")
    public Object selItems(@RequestParam Integer page,@RequestParam Integer limit,@RequestBody Litem litem);
    @RequestMapping("addItem")
    public int updItem(@RequestBody Lrecord lrecord);
    @RequestMapping("selItem")
    public Object selItem(@RequestParam Integer page,@RequestParam Integer limit,@RequestBody Lrecord lrecord);
    @RequestMapping("delItem")
    public int delItem(@RequestParam Integer hospitalpriceid);

    /**
     * liaoPay      缴费管理
     */
    @RequestMapping("selPay")
    public List<Register> selPay(@RequestBody Register register,@RequestParam Double moneys);
    @RequestMapping("selPays")
    public Map<String, Object> selPays(@RequestParam Integer page,@RequestParam Integer limit,@RequestBody Register register);
    @RequestMapping("selSurplus")
    public List<Lrecord> selSurplus(@RequestBody Lrecord lrecord);

    /**
     * liaoDrug     药品记账
     */
    @RequestMapping("selDrug")
    public Object selDrug(@RequestParam Integer page,@RequestParam Integer limit,@RequestBody  Lpharmacy lpharmacy);
    @RequestMapping("selDrugs")
    public Object selDrugs(@RequestParam Integer page,@RequestParam Integer limit,@RequestBody  Lrecord lrecord);
    @RequestMapping("selPhar")
    public Object selPhar(@RequestParam Integer page,@RequestParam Integer limit,@RequestBody  Lrecord lrecord);
    @RequestMapping("selNum")
    public Object selNum(@RequestParam Integer pharmacyId);
    @RequestMapping("addDrug")
    public int addDrug(@RequestBody Lrecord lrecord);
    @RequestMapping("delDrug")
    public int delDrug(@RequestParam Integer hospitalpriceid,@RequestParam String durgname,@RequestParam Integer durgnum);
    @RequestMapping("updDrug")
    public int upddItem(@RequestBody Lrecord lrecord);

    /**
     * liaoLeave    出院结算
     */
    @RequestMapping("selRegisters")
    public Object selRegisters(@RequestParam Integer page,@RequestParam Integer limit,@RequestParam String userNames);
    @RequestMapping("updLeave")
    public int updLeave(@RequestBody Register register);
    @RequestMapping("selYaos")
    public Object selYaos(@RequestBody Register register);
    @RequestMapping("selregis")
    public Object selregis(@RequestParam Integer registerid);

}
