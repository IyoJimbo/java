package com.commute;

public class ChoseCourse extends MainCourse{
    private String item;

    public ChoseCourse(int id, String name, String item) {
        super(id, name);
        this.item = item;
    }
    public ChoseCourse(){

    }

    public ChoseCourse(String item) {
        this.item = item;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

}
