package com.yi.po;

/**
 *城市实体类
 * @author yisy
 */
public class City {
    private int id;
    private String cityname;
    private int pid;

    public City(){}

    public City(int id, String cityname, int pid) {
        this.id = id;
        this.cityname = cityname;
        this.pid = pid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCityname() {
        return cityname;
    }

    public void setCityname(String cityname) {
        this.cityname = cityname;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", cityname='" + cityname + '\'' +
                ", pid=" + pid +
                '}';
    }
}
