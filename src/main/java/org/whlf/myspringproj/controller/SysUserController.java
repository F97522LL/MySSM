package org.whlf.myspringproj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.whlf.myspringproj.entity.Menus;
import org.whlf.myspringproj.entity.ResultModel;
import org.whlf.myspringproj.entity.SysUser;
import org.whlf.myspringproj.service.MenusService;
import org.whlf.myspringproj.service.SysUserService;


import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Enumeration;
import java.util.List;

@Controller //标记为Controller 处理请求
public class SysUserController {
    @Autowired
    SysUserService userService;
    @Autowired
    MenusService menusService;

    @RequestMapping("/")
    public String a() {
        System.out.println("您是还未登录！请登录！！");
        return "login";
    }

    @RequestMapping("/login")
    @ResponseBody
    public ResultModel Login(SysUser user, HttpServletRequest request) {
        HttpSession session = request.getSession();
        Enumeration em = session.getAttributeNames();  //得到session中所有的属性名
        while (em.hasMoreElements()) {
            session.removeAttribute(em.nextElement().toString()); //遍历删除session中的值
        }
        System.out.println("登录方法");
        int result = userService.userLogin(user);
        if (result > 0) {
            user.setPassword(null);   //清空密码
            session.setAttribute("user", user);
            session.setAttribute("l", user.getUserName());//获取用户名
            return new ResultModel("登录成功", result);
        } else {
            return new ResultModel("登录失败", result);
        }
    }

    @RequestMapping("/user_register")
    @ResponseBody
    public ResultModel userRegiste(SysUser user, HttpServletRequest request) {
        HttpSession session = request.getSession();
        Enumeration em = session.getAttributeNames();  //得到session中所有的属性名
        while (em.hasMoreElements()) {
            session.removeAttribute(em.nextElement().toString()); //遍历删除session中的值
        }
        System.out.println("注册方法");
        int result = userService.userRegiste(user);
        if (result > 0) {
            user.setPassword(null);   //清空密码
            session.setAttribute("user", user);
            session.setAttribute("l", user.getUserName());//获取用户名
            return new ResultModel("注册成功", result);
        } else {
            return new ResultModel("注册失败", result);
        }
    }

    @RequestMapping("/index")
    public String index(Model model, HttpServletRequest request) {
        List<Menus> menusList = menusService.MenusList();
        model.addAttribute("menusList", menusList);
        HttpSession session = request.getSession();
        SysUser user = (SysUser) session.getAttribute("user");
        model.addAttribute("name", user.getUserName());
        System.out.println("这是一个菜单");
        return "index";
    }

    //退出登录，清空session
    @RequestMapping("/Logout")
    public String Logout(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Enumeration em = session.getAttributeNames();  //得到session中所有的属性名
        while (em.hasMoreElements()) {
            session.removeAttribute(em.nextElement().toString()); //遍历删除session中的值
        }
        return "login";
    }

    //个人主页
    @RequestMapping("/personalHomepage")
    public String person(Model model, HttpServletRequest request) {
        //获取Session对象
        HttpSession session = request.getSession();
        //获取session存入的user对象
        //键值对形式
        SysUser user = (SysUser) session.getAttribute("user");
        //把信息传入MODEL，返回前端
        model.addAttribute("name", user.getUserName());
        return "personalHomepage";
    }

    //个人信息编辑
    @RequestMapping("/personalHomepageEdit")
    @ResponseBody
    public ResultModel personEdit(String pwd, HttpServletRequest request) {
        HttpSession session = request.getSession();
        SysUser user = (SysUser) session.getAttribute("user");
        int result = 0;
        user.setPassword(DigestUtils.md5DigestAsHex(pwd.getBytes()));
        System.out.println(DigestUtils.md5DigestAsHex(pwd.getBytes()));
        result = userService.updatePassword(user);
        if (result > 0) {
            return new ResultModel("修改成功", 1);
        }
        return new ResultModel("修改失败", 0);
    }
}





