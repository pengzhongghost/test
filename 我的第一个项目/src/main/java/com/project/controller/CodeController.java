package com.project.controller;


import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.project.utill.IdentifyCode;

@Controller
@RequestMapping("/RandomServlet/random.jpg")
public class CodeController {

    /**
     * 生成验证码
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @GetMapping()
    public ModelAndView createCode(HttpServletRequest request,
                                   HttpServletResponse response) throws Exception {
        // 设置响应的类型格式为图片格式
        response.setContentType("image/jpeg");
        // 禁止图像缓存。
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);

        // 自定义宽、高、字数和干扰线的条数
        IdentifyCode code = new IdentifyCode(100, 30, 4, 10);
        // 存入session
        HttpSession session = request.getSession();
        session.setAttribute("code", code.getCode());
        // 响应图片
        ServletOutputStream out = response.getOutputStream();
        code.write(out);
        try {
            out.flush();
        } finally {
            out.close();
        }
        return null;
    }


    /**
     * 验证验证码是否一致
     * @param request
     * @return
     */
    @GetMapping(value = "check")
    @ResponseBody
    public boolean checkCode(HttpServletRequest request) {
        String oldStr = (String) request.getSession().getAttribute(
                "myCode");
        String newStr = request.getParameter("code");
        if (oldStr.equalsIgnoreCase(newStr)) {
            return true;
        }
        return false;
    }

}
