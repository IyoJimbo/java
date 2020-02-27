package com.commute;

public class User extends MainCourse {
    private String password;
    private String date;
    private String type;
    private String route;
    private String bd_time;
    private String bd_st;
    private String drop_time;
    private String drop_st;
    private String rc_time;

    public User(int id, String name, String date, String type, String route,String bd_time,String bd_st,String drop_time,String drop_st,String rc_time,String password) {
        super(id, name);
        this.password=password;
        this.date = date;
        this.type = type;
        this.route = route;
        this.bd_time = bd_time;
        this.bd_st = bd_st;
        this.drop_time = drop_time;
        this.drop_st = drop_st;
        this.rc_time = rc_time;
    }


    public User() {
        super();
    }



    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public String getBd_time() {
        return bd_time;
    }

    public void setBd_time(String bd_time) {
        this.bd_time = bd_time;
    }

    public String getBd_st() {
        return bd_st;
    }

    public void setBd_st(String bd_st) {
        this.bd_st = bd_st;
    }

    public String getDrop_time() {
        return drop_time;
    }

    public void setDrop_time(String drop_time) {
        this.drop_time = drop_time;
    }

    public String getDrop_st() {
        return drop_st;
    }

    public void setDrop_st(String drop_st) {
        this.drop_st = drop_st;
    }

    public String getRc_time() {
        return rc_time;
    }

    public void setRc_time(String rc_time) {
        this.rc_time = rc_time;
    }

}
