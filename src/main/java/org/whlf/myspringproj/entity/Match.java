package org.whlf.myspringproj.entity;

public class Match extends PageEntity {
    private String matchid;
    private String matchName;
    private String matchDivision;
    private String matchWork;
    private String matchStart;
    private String matchCreat;
    private String matchSum;
    private String matchImg;
    private String startTime;
    private String endTime;
    private String matchStage;
    private String matchType;

    public String getMatchType() {
        return matchType;
    }

    public void setMatchType(String matchType) {
        this.matchType = matchType;
    }

    public String getMatchImg() {
        return matchImg;
    }

    public void setMatchImg(String matchImg) {
        this.matchImg = matchImg;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getMatchStage() {
        return matchStage;
    }

    public void setMatchStage(String matchStage) {
        this.matchStage = matchStage;
    }

    public String getMatchid() {
        return matchid;
    }

    public void setMatchid(String matchid) {
        this.matchid = matchid;
    }

    public String getMatchName() {
        return matchName;
    }

    public void setMatchName(String matchName) {
        this.matchName = matchName;
    }

    public String getMatchDivision() {
        return matchDivision;
    }

    public void setMatchDivision(String matchDivision) {
        this.matchDivision = matchDivision;
    }

    public String getMatchWork() {
        return matchWork;
    }

    public void setMatchWork(String matchWork) {
        this.matchWork = matchWork;
    }

    public String getMatchStart() {
        return matchStart;
    }

    public void setMatchStart(String matchStart) {
        this.matchStart = matchStart;
    }

    public String getMatchCreat() {
        return matchCreat;
    }

    public void setMatchCreat(String matchCreat) {
        this.matchCreat = matchCreat;
    }

    public String getMatchSum() {
        return matchSum;
    }

    public void setMatchSum(String matchSum) {
        this.matchSum = matchSum;
    }
}
