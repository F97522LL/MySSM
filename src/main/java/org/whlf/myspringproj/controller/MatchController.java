package org.whlf.myspringproj.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.whlf.myspringproj.entity.ImgList;
import org.whlf.myspringproj.entity.Match;
import org.whlf.myspringproj.entity.ResultModel;
import org.whlf.myspringproj.service.MatchService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class MatchController {
    @Autowired
    MatchService matchService;

    //跳转到管理员列表页面
    @RequestMapping("/match")
    public String match() {
        return "html/match";
    }

    //比赛列表
    @RequestMapping("/matchList")
    @ResponseBody
    public Map<String, Object> getMatchList(Match match, MultipartFile file) throws IOException {
        PageHelper.startPage(match.getPage(), match.getLimit());//springboot分页pagehelper
        List<Match> list = matchService.getMatchList();
        PageInfo<Match> pageInfo = new PageInfo<>(list);
        Map<String, Object> map = new HashMap<>();
        map.put("code", 0);             //编码.密码.码
        map.put("msg", "查询成功！");  //提示消息
        map.put("count", pageInfo.getTotal()); //查询返回的长度
        map.put("data", pageInfo.getList());         //查询返回的数据
        return map;

    }

    //添加比赛
    @RequestMapping("/match-add")
    public String matchAdd(Match match, Model model) {
        Match u = new Match();
        model.addAttribute("match", u);
        return "html/matchEdit";
    }

    @RequestMapping("/addMatch")//创建添加比赛
    @ResponseBody   // 指明这个方法是通过ajax异步交互来访问的
    public ResultModel establish(Match match, HttpServletRequest request) {
        HttpSession session = request.getSession();
        ImgList imgList = (ImgList) session.getAttribute("imgList");
        match.setMatchImg(imgList.getImg());
        int result = matchService.addMatch(match);
        if (result > 0) {
            return new ResultModel("成功", 1);
        } else {
            return new ResultModel("失败", 0);
        }
    }

    //    // 编辑比赛信息页面
//    @RequestMapping("/match-edit")
//    public String getEdit(Match match, Model model) {
//        Match m = matchService.getEdit(match);
//        model.addAttribute("match", m);
//        return "html/matchEdit";
//    }
//    //保存比赛信息
//    @RequestMapping("/matchEdit")
//    @ResponseBody   // 指明这个方法是通过ajax异步交互来访问的
//    public ResultModel matchEdit(Match match) {
//        int result = matchService.matchEdit(match);
//        if (result > 0) {
//            return new ResultModel("成功保存", 1);
//        } else {
//            return new ResultModel("保存失败", 0);
//        }
//    }
//    //删除比赛
//    @RequestMapping("/matchDel")
//    @ResponseBody   // 指明这个方法是通过ajax异步交互来访问的
//    public ResultModel matchDel(Match match) {
//        int result = matchService.matchDel(match);
//        if (result > 0) {
//            return new ResultModel("成功", 1);
//        } else {
//            return new ResultModel("失败", 0);
//        }
//    }
//
//
    @RequestMapping("/matchStart")
    @ResponseBody
    public ResultModel matchStar(Match match) {
        int result = matchService.matchStart(match);
        if (result > 0) {
            return new ResultModel("增加成功", 1);
        } else {
            return new ResultModel("开启失败", 0);
        }
    }
//
//    @RequestMapping("/matchEnd")//结束比赛
//    @ResponseBody
//    public ResultModel matchEnd(Match match) {
//        int result = matchService.matchEnd(match);
//        if (result > 0) {
//            return new ResultModel("成功", 1);
//        } else {
//            return new ResultModel("失败", 0);
//        }
//    }
//

}
