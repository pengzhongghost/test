package com.project.controller;

import com.project.pojo.Department;
import com.project.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/DeptController")
public class DeptController {
    @Autowired
    DeptService deptService;
    @RequestMapping("/deptAdd")
    public Object deptAdd(Department dept){
        deptService.insertDept(dept);
        return "redirect:/DeptController/toDeptList";
    }

    @RequestMapping("/toDeptList")
    public String toDeptList(Model model){
        List<Department> departments=deptService.findAllDepts();
        model.addAttribute("departments",departments);
        return "deptList";
    }

    @RequestMapping("/check")
    @ResponseBody
    public Object check(Department dept){
        Department department=deptService.check(dept);
        if (department!=null){
            return 3;
        }else {
            return 1;
        }
    }

    @RequestMapping("/deptUpdate")
    public String deptUpdate(Department dept){
        deptService.updateDept(dept);
        return "redirect:/DeptController/toDeptList";
    }

    @RequestMapping("/deptDelete")
    public String deptDelete(Department dept){
        deptService.deptDelete(dept);
        return "redirect:/DeptController/toDeptList";
    }
}
