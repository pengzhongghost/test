package com.project.controller;

import com.project.pojo.Department;
import com.project.pojo.Position;
import com.project.pojo.User;
import com.project.service.UserService;
import com.project.utill.FileNameUtils;
import com.project.utill.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/UserController")
public class UserController {
    @Autowired
    UserService userService;
    @Value("${web.picture-path}")
    private String path;
    @Resource
    private ResourceLoader resourceLoader;

    @RequestMapping( "/register")
    public String register(User user,MultipartFile img){
        String fileName = FileNameUtils.getFileName(img.getOriginalFilename());
        FileUtils.upload(img,path,fileName);
        System.out.println(fileName);
        user.setFile(fileName);
        int i=userService.register(user);
        String register="";
        if (i>0)
        {
            register="注册成功";
        }
        return "redirect:/login?register="+register;
    }

    @RequestMapping("/show")
    public ResponseEntity show(HttpServletRequest req){
        HttpSession session = req.getSession();
        User user =(User)session.getAttribute("user");
        System.out.println(user);
        if (user!=null){
            try {
                    return ResponseEntity.ok(resourceLoader.getResource("file:"+path+user.getFile()));
            }catch (Exception e){
                return ResponseEntity.notFound().build();
            }
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @RequestMapping("/show2")
    public ResponseEntity show2(Integer uid){

        User user = userService.findOne(uid);

        if (user!=null){
            try {
                return ResponseEntity.ok(resourceLoader.getResource("file:"+path+user.getFile()));
            }catch (Exception e){
                return ResponseEntity.notFound().build();
            }
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @RequestMapping("/login")
    public String login(@Validated User user, BindingResult result, HttpServletRequest req, Model model){
        String uri = req.getRequestURI();
        StringBuffer url = req.getRequestURL();
        System.out.println(uri+"******"+ url);
        if (result.hasErrors()){
           return "login";
        }
        HttpSession session = req.getSession();
        String randStr =(String) session.getAttribute("code");
        String yzm = req.getParameter("yzm");

        if (!randStr.equals(yzm)){
            model.addAttribute("error","验证码错误");
            return "login";
        }else {
            User user1=userService.login(user);
            if (user1==null){
                model.addAttribute("error","用户名或密码错误");
                return "login";
            }else {
                session.setAttribute("user",user1);
                return "index";
            }
        }
    }
    @RequestMapping("/loginOut")
    public String loginOut(HttpServletRequest req, User user){
        HttpSession session = req.getSession();
        session.invalidate();
        return "login2";
    }

    //员工管理

    @RequestMapping("/findAllStaff")
    public String findAllStaff(Model model){
        List<User> users=userService.findAllStaff();
        model.addAttribute("users",users);
        return "empList";
    }

    @RequestMapping("/toEmpAdd")
    public String toEmpAdd(Model model){
        List<Department> departments=userService.findAllDepartments();
        List<Position> positions=userService.findAllPosition();
        model.addAttribute("departments",departments);
        model.addAttribute("positions",positions);
        return "empAdd";
    }

    @RequestMapping("/staffAdd")
    public String staffAdd(User user, MultipartFile img){

        String fileName = FileNameUtils.getFileName(img.getOriginalFilename());
        FileUtils.upload(img,path,fileName);
        user.setFile(fileName);
        userService.staffAdd(user);
        return "redirect:/UserController/findAllStaff";
    }

    @RequestMapping("/findOne")
    public String findOne(int uid,Model model){
        User user=userService.findOne(uid);
        List<Department> departments=userService.findAllDepartments();
        List<Position> positions=userService.findAllPosition();
        model.addAttribute("positions",positions);
        model.addAttribute("departments",departments);
        model.addAttribute("user",user);
        return "/empUpdate";
    }

    @RequestMapping("/userUpdate")
    public String userUpdate(User user){
        userService.userUpdate(user);
        return "redirect:/UserController/findAllStaff";
    }

    @RequestMapping("/pwdedit")
    @ResponseBody
    public Object pwdedit(User user){

        int i=userService.pwdedit(user);
        return i;
    }

    @RequestMapping("/deleteUser")
    public String deleteUser(User user){
        userService.deleteUser(user);
        return "redirect:/UserController/findAllStaff";
    }


}

