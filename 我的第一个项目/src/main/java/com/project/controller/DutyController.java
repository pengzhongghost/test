package com.project.controller;


import com.project.mapper.DepartmentMapper;
import com.project.pojo.Department;
import com.project.pojo.Duty;
import com.project.pojo.User;
import com.project.service.DeptService;
import com.project.service.DutyService;

import com.project.service.UserService;
import com.project.utill.PageBean;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/DutyController")
public class DutyController {
    @Autowired
    DutyService dutyService;
    @Autowired
    DeptService deptService;
    @RequestMapping("/signin")
    @ResponseBody
    public Object signin(HttpServletRequest req){
        HttpSession session = req.getSession();
        User user =(User) session.getAttribute("user");
        if (user==null){
            return 10;
        }else {
            Integer i = dutyService.signin(user);
            return i;
        }
    }
    @RequestMapping("/signout")
    @ResponseBody
    public Object signout(HttpServletRequest req){
        HttpSession session = req.getSession();
        User user =(User) session.getAttribute("user");
        if (user==null){
            return 10;
        }else {
            Integer i=dutyService.signout(user);
            return i;
        }
    }

    @RequestMapping("/findAllDuty")
    public String findAllDuty(Model model,HttpServletRequest req){
        String sindex = req.getParameter("index");
        String username = req.getParameter("username");
        String sdid = req.getParameter("did");
        String date = req.getParameter("date");
        int did=0;
        if (sdid!=null&&sdid!=""){
            did=Integer.parseInt(sdid);
        }
        int index=1;
        if (sindex!=null&&sindex!=""){
            index=Integer.parseInt(sindex);
        }
        List<Department> departments = deptService.findAllDepts();
        PageBean<Duty> pageBean=dutyService.findAllDuty(index,username,did,date);
        List<Duty> duties = pageBean.getList();
        model.addAttribute("duties",duties);
        model.addAttribute("pageBean",pageBean);
        model.addAttribute("departments",departments);
        model.addAttribute("username",username);
        model.addAttribute("did",did);
        model.addAttribute("date",date);

        return "/dutyList";
    }
    @RequestMapping("/ExcelHandler")
    public void ExcelHandler(Model model, HttpServletRequest req, HttpServletResponse resp,String[] dutyids){
        String sindex = req.getParameter("index");
        String username = req.getParameter("username");
        String sdid = req.getParameter("did");
        String date = req.getParameter("date");
        List<Integer> dids=new ArrayList<Integer>();
        if (dutyids!=null){
            for (String i:dutyids){
                int did = Integer.parseInt(i);
                dids.add(did);
            }
        }
        int index=1;
        if (sindex!=null&&sindex!=""){
            index=Integer.parseInt(sindex);
        }
        int did=0;
        if (sdid!=null&&sdid!=""){
            did=Integer.parseInt(sdid);
        }
        List<Department> departments = deptService.findAllDepts();
        List<Duty> duties1=dutyService.findSomeDuty(dids);
        PageBean<Duty> pageBean=dutyService.findAllDuty(index,username,did,date);
        List<Duty> duties = pageBean.getList();
        model.addAttribute("duties",duties);
        model.addAttribute("pageBean",pageBean);
        model.addAttribute("departments",departments);
        model.addAttribute("username",username);
        model.addAttribute("did",did);
        model.addAttribute("date",date);
        createExcel(duties1,resp);
    }


    private static void createExcel(List<Duty> list,HttpServletResponse resp) {
        // 创建一个Excel文件
        HSSFWorkbook workbook = new HSSFWorkbook();
        // 创建一个工作表
        HSSFSheet sheet = workbook.createSheet("考勤信息");

        CellRangeAddress region = new CellRangeAddress(0, // first row
                0, // last row
                0, // first column
                2 // last column
        );
        sheet.addMergedRegion(region);

        HSSFRow hssfRow = sheet.createRow(0);
        HSSFCell headCell = hssfRow.createCell(0);
        headCell.setCellValue("考勤信息");

        // 设置单元格格式居中
        HSSFCellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);

        headCell.setCellStyle(cellStyle);


        // 添加表头行
        hssfRow = sheet.createRow(1);
        // 添加表头内容
        headCell = hssfRow.createCell(0);
        headCell.setCellValue("用户名");
        headCell.setCellStyle(cellStyle);

        headCell = hssfRow.createCell(1);
        headCell.setCellValue("真实姓名");
        headCell.setCellStyle(cellStyle);

        headCell = hssfRow.createCell(2);
        headCell.setCellValue("所属部门");
        headCell.setCellStyle(cellStyle);

        headCell = hssfRow.createCell(3);
        headCell.setCellValue("出勤日期");
        headCell.setCellStyle(cellStyle);

        headCell = hssfRow.createCell(4);
        headCell.setCellValue("签到时间");
        headCell.setCellStyle(cellStyle);

        headCell = hssfRow.createCell(5);
        headCell.setCellValue("签退时间");
        headCell.setCellStyle(cellStyle);


        // 添加数据内容
        for (int i = 0; i < list.size(); i++) {
            hssfRow = sheet.createRow((int) i + 2);
            Duty student = list.get(i);

            // 创建单元格，并设置值
            HSSFCell cell = hssfRow.createCell(0);
            cell.setCellValue(student.getUser().getUsername());
            cell.setCellStyle(cellStyle);

            cell = hssfRow.createCell(1);
            cell.setCellValue(student.getUser().getRealname());
            cell.setCellStyle(cellStyle);

            cell = hssfRow.createCell(2);
            cell.setCellValue(student.getUser().getDepartment().getDeptname());
            cell.setCellStyle(cellStyle);

            cell = hssfRow.createCell(3);
            cell.setCellValue(student.getDate());
            cell.setCellStyle(cellStyle);

            cell = hssfRow.createCell(4);
            cell.setCellValue(student.getIntime());
            cell.setCellStyle(cellStyle);

            cell = hssfRow.createCell(5);
            cell.setCellValue(student.getOuttime());
            cell.setCellStyle(cellStyle);
        }

        // 保存Excel文件
        try {
            //OutputStream outputStream = new FileOutputStream("D:/duty.xls");
            resp.setContentType("application/vnd.ms-excel");
            resp.setHeader("Content-disposition", "attachment; fileName=" + new String(("duty.xls").getBytes(), "iso8859-1"));
            OutputStream outputStream = resp.getOutputStream();

            workbook.write(outputStream);
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @RequestMapping("/findMyDuty")
    public String findMyDuty(Model model,HttpServletRequest req){
        String sindex = req.getParameter("index");
        int index=1;
        if (sindex!=null&&sindex!=""){
            index=Integer.parseInt(sindex);
        }

        HttpSession session = req.getSession();
        User user =(User)session.getAttribute("user");
        PageBean<Duty> pageBean=dutyService.findMyDuty(user.getUid(),index);
        List<Duty> duties = pageBean.getList();
        model.addAttribute("duties",duties);
        model.addAttribute("pageBean",pageBean);


        return "/myDuty";
    }
}
