package org.whlf.myspringproj.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.whlf.myspringproj.entity.Admin;
import org.whlf.myspringproj.entity.ResultModel;
import org.whlf.myspringproj.service.UserService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
public class UserController {
    @Autowired
    UserService adminService;

    //跳转到用户列表页面
    @RequestMapping("/admin")
    public String admin() {
        System.out.println("用户列表页面");
        return "html/admin";
    }

    //LIST用户表
    @RequestMapping("/adminList")
    @ResponseBody
    public Map<String, Object> getAdminList(Admin admin) {
        PageHelper.startPage(admin.getPage(), admin.getLimit());//分页
        System.out.println("管理员列表");
        List<Admin> list = adminService.getAdminList(admin);
        PageInfo<Admin> pageInfo = new PageInfo<>(list);
        Map<String, Object> map = new HashMap<>();
        map.put("code", 0);             //编码.密码
        map.put("msg", "查询成功！");  //提示消息
        map.put("count", pageInfo.getTotal()); //查询返回的长度
        map.put("data", pageInfo.getList());    //查询返回的数据
        return map;
    }

    //主页介绍
    @RequestMapping("/about")
    public String indexHome() {
        return "about";
    }

    //删除用户
    @RequestMapping("/adminDelete")
    @ResponseBody
    public ResultModel deleteAdmin(String adminid) {
        int result = adminService.deleteAdmin(adminid);
        if (result > 0) {
            return new ResultModel("登录成功", result);
        } else {
            return new ResultModel("登录失败", result);
        }
    }

    //获取当前要修改的用户信息
    @RequestMapping("/adminEdit")
    public String adminEdit(Admin admin, Model model) {
        Admin a = adminService.getAdmin(admin);
        model.addAttribute("admin", a);
        System.out.println("这是管理员编辑页面");
        return "html/adminEdit";
    }

    @RequestMapping("/adminUpdate")
    @ResponseBody
    public ResultModel adminUpdate(Admin admin, Model model) {
        int result = adminService.updateAdmin(admin);
        if (result > 0) {
            return new ResultModel("修改成功", result);
        } else {
            return new ResultModel("修改失败", result);
        }
    }

    //增加用户，不带信息
    @RequestMapping("insertAdmin")
    public String adminInsert(Model model) {
        Admin a = new Admin();
        model.addAttribute("admin", a);
        return "html/adminEdit";
    }

    @RequestMapping("adminInsert")
    @ResponseBody
    public ResultModel adminInsert(Admin admin, Model model) {
        Admin a = adminService.getAdmin(admin);
        if (a != null) {
            return new ResultModel("创建成功", 0);
        } else {
            int result = adminService.adminInsert(admin);
            if (result > 0) {
                return new ResultModel("增加成功", result);
            } else {
                return new ResultModel("增加失败", result);
            }
        }
    }

    //导出excel
    @RequestMapping("/UserInfoExcel")
    // @RequestMapping(value = "/UserInfoExcel", method = RequestMethod.GET)
    @CrossOrigin(origins = "*", maxAge = 3600)
    public void exportEnergyProExcel(HttpServletResponse response) {
        List<Admin> list = adminService.getAdminList1();
        ;//查出数据库数据
        XSSFWorkbook wb = new XSSFWorkbook();
        Sheet sheet = wb.createSheet("Admin");//创建一张表
        Row titleRow = sheet.createRow(0);//创建第一行，起始为0
        titleRow.createCell(0).setCellValue("序号");
        titleRow.createCell(1).setCellValue("用户账号");//第一列
        titleRow.createCell(2).setCellValue("作品");
        titleRow.createCell(3).setCellValue("赛区");
        titleRow.createCell(4).setCellValue("比赛ID");
        titleRow.createCell(5).setCellValue("评委");
        titleRow.createCell(6).setCellValue("分数");
        titleRow.createCell(7).setCellValue("分数");
        int cell = 1;
        for (Admin riskAdmin : list) {
            Row row = sheet.createRow(cell);//从第二行开始保存数据
            row.createCell(0).setCellValue(cell);
            row.createCell(1).setCellValue(riskAdmin.getAdminName());
            row.createCell(2).setCellValue(riskAdmin.getAdminPhone());//将数据库的数据遍历出来
            row.createCell(3).setCellValue(riskAdmin.getAdminN());
            row.createCell(4).setCellValue(riskAdmin.getAdminid());
            row.createCell(5).setCellValue(riskAdmin.getAdminEmail());
            row.createCell(6).setCellValue(riskAdmin.getAdminTime());
            row.createCell(7).setCellValue(riskAdmin.getAdminType());
            cell++;
        }
        String fileName = "作品信息表.xlsx";
        OutputStream outputStream = null;
        try {
            fileName = URLEncoder.encode(fileName, "UTF-8");
            //设置ContentType请求信息格式
            response.setContentType("application/vnd.ms-excel");
            response.setHeader("Content-disposition", "attachment;filename=" + fileName);
            outputStream = response.getOutputStream();
            wb.write(outputStream);
            outputStream.flush();
            outputStream.close();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


