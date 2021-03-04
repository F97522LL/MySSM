package org.whlf.myspringproj.entity;

public class Menus {
    private String menusid;
    private String menusName;
    private String menusSort;
    private String menusFather;
    private String menusUrl;

    public String getMenusid() {
        return menusid;
    }

    public void setMenusid(String menusid) {
        this.menusid = menusid;
    }

    public String getMenusName() {
        return menusName;
    }

    public void setMenusName(String menusName) {
        this.menusName = menusName;
    }

    public String getMenusSort() {
        return menusSort;
    }

    public void setMenusSort(String menusSort) {
        this.menusSort = menusSort;
    }

    public String getMenusFather() {
        return menusFather;
    }

    public void setMenusFather(String menusFather) {
        this.menusFather = menusFather;
    }

    public String getMenusUrl() {
        return menusUrl;
    }

    public void setMenusUrl(String menusUrl) {
        this.menusUrl = menusUrl;
    }
}
