package com.yi.po;

import java.util.ArrayList;
import java.util.List;

public class Fenye {
    private int pageCount;  //一页显示多少条数据
    private int pageNow;    //从页面中获取
    private int totalCount; //数据库中一共有多少条数据
    private int page;       //总页面数
    private List<Restaurant> list=new ArrayList<Restaurant>();
    private String url;

    public Fenye(){}

    public Fenye(int pageCount, int pageNow, int totalCount, List<Restaurant> list) {
        this.pageCount = pageCount;
        this.pageNow = pageNow;
        this.totalCount = totalCount;
        this.list = list;
    }

    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public int getPage() {
        return page = totalCount%pageCount==0 ? (totalCount/pageCount):(totalCount/pageCount+1);
    }
    public void setPage(int page) {
        this.page = page;
    }
    public int getPageCount() {
        return pageCount;
    }
    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }
    public int getPageNow() {
        return pageNow;
    }
    public void setPageNow(int pageNow) {
        this.pageNow = pageNow;
    }
    public int getTotalCount() {
        return totalCount;
    }
    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }
    public List<Restaurant> getList() {
        return list;
    }
    public void setList(List<Restaurant> list) {
        this.list = list;
    }





}

