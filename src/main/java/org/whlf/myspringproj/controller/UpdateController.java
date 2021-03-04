package org.whlf.myspringproj.controller;


import org.whlf.myspringproj.entity.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.whlf.myspringproj.entity.ResultModel;
import org.whlf.myspringproj.service.MatchService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("upload")
public class UpdateController {
    @Autowired
    MatchService matchService;

//上传图片工具
    @RequestMapping("file")
    @ResponseBody
    public ResultModel upload(HttpServletRequest request, MultipartFile file, ImgList imgList) throws IOException {
        HttpSession session = request.getSession();
        session.setAttribute("imgList",null);//构建一个键值对
        if (!file.isEmpty()) {
            //构建上传文件的存放绝对路径
            String path = "E:/myspringproj/target/classes/static/img";

            // 获取上传的文件名称，并结合存放路径，构建新的文件名称
            String filename = file.getOriginalFilename();
            File filepath = new File(path, filename);

            // 判断路径是否存在，不存在则新创建一个
            if (!filepath.getParentFile().exists()) {
                filepath.getParentFile().mkdirs();
            }
            // 将上传文件保存到目标文件目录

            file.transferTo(new File(path + File.separator + filename));
            File targetFile = new File(path + File.separator + filename);
            System.out.println(targetFile);
            String diz = targetFile.toString();
            String diz1 = diz.substring(0, diz.indexOf("img"));
            String diz2 = diz.substring(diz1.length(), diz.length());
            imgList.setImg("\\" + diz2);
            session.setAttribute("imgList",imgList);//把地址存在session中
            // matchService.addImg(imgList);//把地址存在imgList表中
            return new ResultModel("ok", 1);
        } else {
            return new ResultModel("ok", 0);
        }
    }


}
