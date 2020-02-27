package com.commute;

public class MainCourse{
    private int id;
    private String Name;

    public MainCourse(int id, String name) {
        this.id = id;
        Name = name;
    }
    public MainCourse(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

}
