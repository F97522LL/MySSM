package org.whlf.myspringproj.controller;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.whlf.myspringproj.entity.Echarststext;
import org.whlf.myspringproj.service.EcharststextService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller //标记为Controller 处理请求
public class TextController {
    @Autowired
    EcharststextService echarststextService;

    @RequestMapping("text")
    public String a1() {
        return "text/Echarts";
    }

    @ResponseBody
    @RequestMapping("TestServlet")
    public Map<String, Object> getEa(Echarststext echarststext) {
        List<Echarststext> list = echarststextService.getEa(echarststext);
        PageInfo<Echarststext> pageInfo = new PageInfo<>(list);
        String a[] = {"类型1","类型2","类型3","类型4"};
        int b[] = {5,10,15,20};
        Map<String, Object> map = new HashMap<>();
        map.put("a", a);
        map.put("b", b);
        return map;

    }


//    @RequestMapping("text")
//    public String a(Model model,Echarststext echarststext) {
//        Echarststext a = eatchtsService.getEchars(echarststext);
//        model.addAttribute("e", a);
//        System.out.println("这是图表测试页面");
//
//        return "text/Echarts";
//
//    }
//
//    @RequestMapping("text12")
//    public String a1() {
//
//        return "text/echartsText1";
//
//    }
//    @ResponseBody
//    @RequestMapping("/login.do")
//    public void login(HttpServletResponse response){
//        JSONObject jo=new JSONObject();
//        JSONArray arr=new JSONArray();
//        arr.add(1);
//        arr.add(2);
//        arr.add(3);
//        arr.add(4);
//        arr.add(5);
//        arr.add(6);
//        JSONArray arr1=new JSONArray();
//        arr1.add(10);
//        arr1.add(20);
//        arr1.add(30);
//        arr1.add(40);
//        arr1.add(50);
//        arr1.add(60);
//        jo.put("xAxis", arr);
//        jo.put("series", arr1);
//
//        System.out.println( "========>"+jo.toString());
//
////后台输出的json格式：
//
////========>{"xAxis":[1,2,3,4,5,6],"series":[10,20,30,40,50,60]}
////========>{"xAxis":[1,2,3,4,5,6],"series":[10,20,30,40,50,60]}
//
//        JsonUtil.write(response, jo);  //把值返回给前台
//    }
//}
//    @Autowired
//    InjuryService  injuryService;
//    @RequestMapping("/removecauses")
//    @ResponseBody
//    public WebResult removecauses() throws Exception {
//        WebResult result = new WebResult();
//        try {
//            Option option = injuryService.selectRemoveCauses();
//            result.isOK();
//            result.setData(option);
//        } catch (BusinessException e) {
//            result.setException(e);
//        }
//        return result;
//    }


//    @RequestMapping("/echart")
//    @ResponseBody
//    private String dwcb(@RequestParam("scrq1") String scrq1, @RequestParam("scrq2") String scrq2,
//                        @RequestParam("dwmc") String dwmc) throws ParseException {
//        List category = new ArrayList();      //存放Echart柱状图的category
//        List value = new ArrayList();         //存放Echart柱状图的data
//
//        List<ViewNyDwrcb> list = rcbService.findSearchRcb(scrq1, scrq2, dwmc);
//        for (ViewNyDwrcb item : list) {
//            category.add(item.getScrq());
//            value.add(item.getRcb());
//        }
//
//        String categorydata = JSON.toJSONString(category);  //将list集合转换为json数组
//        String valuedata = JSON.toJSONString(value);
//        JSONObject jsonObject = new JSONObject();
//        jsonObject.put("categorydata", categorydata);
//        jsonObject.put("valuedata", valuedata);
//        jsonObject.put("dwmc", dwmc);
//
//        String result = JSON.toJSONString(jsonObject);
//
//        return result;
//    }
}
