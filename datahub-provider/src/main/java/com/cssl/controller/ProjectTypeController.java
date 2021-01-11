package com.cssl.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cssl.pojo.*;
import com.cssl.service.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("prjectType")
public class ProjectTypeController {

    @Autowired
    private ProjectTypeService projectTypeService;
    @Autowired
    private UnitService unitService;
    @Autowired
    private OutpatientTypeService outpatientTypeService;
    @Autowired
    private InOutpatientTypeService inOutpatientTypeService;
    @Autowired
    private MoneyTypeService moneyTypeService;
    @Autowired
    private BedService bedService;
    @Autowired
    private DepartmentsService departmentsService;

    @RequestMapping("findAllProjecttype")
    public Object ProjecttypeList(ProjectType projecttype, Integer page, Integer limit) {
        Map<String, Object> map = new HashMap<>();
        Page<ProjectType> projecttypePage = new Page<>(page, limit);
        IPage<ProjectType> iPage;
        if (projecttype.getProjectName() != null) {
            iPage = projectTypeService.page(projecttypePage, new QueryWrapper<ProjectType>().like("projectName", projecttype.getProjectName()).orderByDesc("projectId"));
        } else {
            iPage = projectTypeService.page(projecttypePage, new QueryWrapper<ProjectType>().orderByDesc("projectId"));
        }

        map.put("code", 0);
        map.put("msg", "");
        map.put("count", iPage.getTotal());
        map.put("data", iPage.getRecords());
        return map;
    }

    @RequestMapping("addProjecttype")
    public String addProjecttype(ProjectType projecttype) {
        int i1 = projectTypeService.count(new QueryWrapper<ProjectType>().eq("projectName", projecttype.getProjectName()));
        if (i1 == 0) {
            boolean i = projectTypeService.save(projecttype);
            if (i) {
                return "添加成功";
            } else {
                return "添加失败";
            }
        } else {
            return projecttype.getProjectName() + "已存在";
        }

    }

    @RequestMapping("deleteProjecttype")
    public String deleteProjecttype(Integer projectId) {
        boolean i = projectTypeService.remove(new UpdateWrapper<ProjectType>().eq("projectId", projectId));
        if (i) {
            return "删除成功";
        } else {
            return "删除失败";
        }
    }

    @RequestMapping("findAllMoneytype")
    public Object MoneytypeList(MoneyType moneytype, Integer page, Integer limit) {
        Map<String, Object> map = new HashMap<>();
        Page<MoneyType> moneytypePage = new Page<>(page, limit);
        IPage<MoneyType> iPage;
        if (moneytype.getMoneytype() != null) {
            iPage = moneyTypeService.page(moneytypePage, new QueryWrapper<MoneyType>().like("moneytype", moneytype.getMoneytype()).orderByDesc("moneyId"));
        } else {
            iPage = moneyTypeService.page(moneytypePage, new QueryWrapper<MoneyType>().orderByDesc("moneyId"));

        }
        map.put("code", 0);
        map.put("msg", "");
        map.put("count", iPage.getTotal());
        map.put("data", iPage.getRecords());
        return map;
    }

    @RequestMapping("addMoneytype")
    public String addMoneytype(MoneyType moneytype) {
        int i1 = moneyTypeService.count(new QueryWrapper<MoneyType>().eq("moneytype", moneytype.getMoneytype()));
        if (i1 == 0) {
            boolean i = moneyTypeService.save(moneytype);
            if (i) {
                return "添加成功";
            } else {
                return "添加失败";
            }
        } else {
            return moneytype.getMoneytype() + "已存在";
        }

    }

    @RequestMapping("editMoneytype")
    public String editMoneytype(MoneyType moneytype) {
        boolean i = moneyTypeService.update(moneytype, new UpdateWrapper<MoneyType>().eq("moneyId", moneytype.getMoneyId()));
        if (i) {
            return "修改成功";
        } else {
            return "修改失败";
        }

    }

    @RequestMapping("deleteMoneytype")
    public String deleteMoneytype(Integer moneyId) {
        boolean i = moneyTypeService.remove(new UpdateWrapper<MoneyType>().eq("moneyId", moneyId));
        if (i) {
            return "删除成功";
        } else {
            return "删除失败";
        }
    }

    @RequestMapping("findAllOutpatienttype")
    public Object OutpatienttypeList(OutpatientType outpatienttype, Integer page, Integer limit) {
        Map<String, Object> map = new HashMap<>();
        PageHelper.startPage(page, limit);
        PageInfo pageInfo = new PageInfo(outpatientTypeService.findAllOutpatientType(outpatienttype));

        map.put("code", 0);
        map.put("msg", "");
        map.put("count", pageInfo.getTotal());
        map.put("data", pageInfo.getList());
        return map;
    }

    @RequestMapping("findAllUnit")
    public Object UnitList() {
        List<Unit> listAll = unitService.list();
        return listAll;
    }

    @RequestMapping("findAllProjecttype1")
    public Object ProjecttypeList() {
        List<ProjectType> listAll = projectTypeService.list();
        return listAll;
    }

    @RequestMapping("addOutpatienttype")
    public String addOutpatienttype(OutpatientType outpatienttype, Integer projectId, Integer unitId) {
        outpatienttype.setBigprojectId(projectId);
        outpatienttype.setUnit(unitId);
        int i1 = outpatientTypeService.count(new QueryWrapper<OutpatientType>().eq("outpatientId", outpatienttype.getOutpatientId()));
        if (i1 == 0) {
            boolean i = outpatientTypeService.save(outpatienttype);
            if (i) {
                return "添加成功";
            } else {
                return "添加失败";
            }
        } else {
            return outpatienttype.getProjectName() + "已存在";
        }

    }

    @RequestMapping("editOutpatienttype")
    public String editOutpatienttype(OutpatientType outpatienttype, Integer projectId, Integer unitId) {
        outpatienttype.setBigprojectId(projectId);
        outpatienttype.setUnit(unitId);
        boolean i = outpatientTypeService.update(outpatienttype, new UpdateWrapper<OutpatientType>().eq("outpatientId", outpatienttype.getOutpatientId()));
        if (i) {
            return "修改成功";
        } else {
            return "修改失败";
        }
    }

    @RequestMapping("deleteOutpatienttype")
    public String deleteOutpatienttype(Integer outpatientId) {
        boolean i = outpatientTypeService.remove(new UpdateWrapper<OutpatientType>().eq("outpatientId", outpatientId));
        if (i) {
            return "删除成功";
        } else {
            return "删除失败";
        }
    }

    @RequestMapping("findAllInoutpatienttype")
    public Object InoutpatienttypeList(InOutpatientType inoutpatienttype, Integer page, Integer limit) {
        Map<String, Object> map = new HashMap<>();
        PageHelper.startPage(page, limit);
        PageInfo pageInfo = new PageInfo(inOutpatientTypeService.findAllInOutpatientType(inoutpatienttype));

        map.put("code", 0);
        map.put("msg", "");
        map.put("count", pageInfo.getTotal());
        map.put("data", pageInfo.getList());
        return map;
    }

    @RequestMapping("findAllUnit1")
    public Object findAllUnit1() {
        List<Unit> listAll = unitService.list();
        return listAll;
    }

    @RequestMapping("findAllProjecttype2")
    public Object findAllProjecttype2() {
        List<ProjectType> listAll = projectTypeService.list();
        return listAll;
    }

    @RequestMapping("addInoutpatienttype")
    public String addInoutpatienttype(InOutpatientType inoutpatienttype, Integer projectId, Integer unitId) {
        inoutpatienttype.setBigproJectId(projectId);
        inoutpatienttype.setUnit(unitId);
        int i1 = inOutpatientTypeService.count(new QueryWrapper<InOutpatientType>().eq("projectName", inoutpatienttype.getProjectName()));
        if (i1 == 0) {
            boolean i = inOutpatientTypeService.save(inoutpatienttype);
            if (i) {
                return "添加成功";
            } else {
                return "添加失败";
            }
        } else {
            return inoutpatienttype.getProjectName() + "已存在";
        }

    }

    @RequestMapping("editInoutpatienttype")
    public String editInoutpatienttype(InOutpatientType inoutpatienttype, Integer projectId, Integer unitId) {
        inoutpatienttype.setBigproJectId(projectId);
        inoutpatienttype.setUnit(unitId);
        boolean i = inOutpatientTypeService.update(inoutpatienttype, new UpdateWrapper<InOutpatientType>().eq("inoutpatientId", inoutpatienttype.getInoutpatientId()));
        if (i) {
            return "修改成功";
        } else {
            return "修改失败";
        }

    }

    @RequestMapping("deleteInoutpatienttype")
    public String deleteInoutpatienttype(Integer inoutpatientId) {
        boolean i = inOutpatientTypeService.remove(new UpdateWrapper<InOutpatientType>().eq("inoutpatientId", inoutpatientId));
        if (i) {
            return "删除成功";
        } else {
            return "删除失败";
        }
    }

    @RequestMapping("findAllBed")
    public Object BedList(Bed bed, Integer page, Integer limit) {
        Map<String, Object> map = new HashMap<>();
        PageHelper.startPage(page, limit);
        PageInfo pageInfo = new PageInfo(bedService.findAllBed(bed));

        map.put("code", 0);
        map.put("msg", "");
        map.put("count", pageInfo.getTotal());
        map.put("data", pageInfo.getList());
        return map;
    }

    @RequestMapping("addBed")
    public String addBed(Bed bed) {
        int i1 = bedService.count(new QueryWrapper<Bed>().eq("bedname", bed.getBedname()));
        if (i1 == 0) {
            boolean i = bedService.save(bed);
            if (i) {
                return "添加成功";
            } else {
                return "添加失败";
            }
        } else {
            return bed.getBedname() + "已存在";
        }

    }

    @RequestMapping("editBed")
    public String editBed(Bed bed) {
        boolean i = bedService.update(bed, new UpdateWrapper<Bed>().eq("bedId", bed.getBedId()));
        if (i) {
            return "修改成功";
        } else {
            return "修改失败";
        }
    }

    @RequestMapping("deleteBed")
    public String deleteBed(Integer bedId) {
        int i1 = bedService.checkCount(bedId);
        if (i1 == 1) {
            return "该床位还有病人";
        } else {
            boolean i = bedService.remove(new UpdateWrapper<Bed>().eq("bedId", bedId));
            if (i) {
                return "删除成功";
            } else {
                return "删除失败";
            }
        }

    }

    @RequestMapping("departmentList")
    public Object DepartmentList() {
        List<Departments> listAll = departmentsService.list();
        return listAll;
    }
}
