//package org.whlf.myspringproj.service.impl;
//
//import com.github.abel533.echarts.code.Trigger;
//import com.github.abel533.echarts.data.PieData;
//import com.github.abel533.echarts.series.Bar;
//import com.github.abel533.echarts.series.Pie;
//import com.github.pagehelper.PageHelper;
//import org.springframework.stereotype.Service;
//
//import java.util.Collections;
//
//@Service
//public class InjuryServiceImpl {
//    @Override
//    public Option selectRemoveCauses() throws BusinessException {
//        //查询前20
//        PageHelper.startPage(1, 20, false);
//        //数据库查询获取统计数据
//        List<Map<String, Object>> list = kc22Mapper.selectRemoveCauses();
//        //为了数据从大到小排列，这里需要倒叙
//        Collections.sort(list, new Comparator<Map<String, Object>>() {
//            @Override
//            public int compare(Map<String, Object> o1, Map<String, Object> o2) {
//                return -1;
//            }
//        });
//        //创建Option
//        Option option = new Option();
//        option.title("剔除药品").tooltip(Trigger.axis).legend("金额（元）");
//        //横轴为值轴
//        option.xAxis(new ValueAxis().boundaryGap(0d, 0.01));
//        //创建类目轴
//        CategoryAxis category = new CategoryAxis();
//        //柱状数据
//        Bar bar = new Bar("金额（元）");
//        //饼图数据
//        Pie pie = new Pie("金额（元）");
//        //循环数据
//        for (Map<String, Object> objectMap : list) {
//            //设置类目
//            category.data(objectMap.get("NAME"));
//            //类目对应的柱状图
//            bar.data(objectMap.get("TOTAL"));
//            //饼图数据
//            pie.data(new PieData(objectMap.get("NAME").toString(), objectMap.get("TOTAL")));
//        }
//        //设置类目轴
//        option.yAxis(category);
//        //饼图的圆心和半径
//        pie.center(900,380).radius(100);
//        //设置数据
//        option.series(bar, pie);
//        //由于药品名字过长，图表距离左侧距离设置180，关于grid可以看ECharts的官方文档
//        option.grid().x(180);
//        //返回Option
//        return option;
//    }
//
//}
