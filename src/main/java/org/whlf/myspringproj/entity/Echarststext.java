package org.whlf.myspringproj.entity;

public class Echarststext extends PageEntity {
    private String xaxis;
    private String DATA1;
    private String DATA2;
    private String DATA3;

    Echarststext() {

    }

    public Echarststext(String xaxis, String DATA1, String DATA2, String DATA3) {
        this.xaxis = xaxis;
        this.DATA1 = DATA1;
        this.DATA2 = DATA2;
        this.DATA3 = DATA3;
    }

    public String getXaxis() {
        return xaxis;
    }

    public void setXaxis(String xaxis) {
        this.xaxis = xaxis;
    }

    public String getDATA1() {
        return DATA1;
    }

    public void setDATA1(String DATA1) {
        this.DATA1 = DATA1;
    }

    public String getDATA2() {
        return DATA2;
    }

    public void setDATA2(String DATA2) {
        this.DATA2 = DATA2;
    }

    public String getDATA3() {
        return DATA3;
    }

    public void setDATA3(String DATA3) {
        this.DATA3 = DATA3;
    }
    public  String toString(){
        return "这是一个测试";
    }
}
