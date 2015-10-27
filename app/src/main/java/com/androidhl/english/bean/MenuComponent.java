package com.androidhl.english.bean;

public abstract class MenuComponent {
    public void add(MenuComponent component){
        throw new RuntimeException("connot add");
    }
    public void remove(MenuComponent component){
        throw new RuntimeException("connot remove");
    }
    public String getName(){
        throw new RuntimeException("not have name");
    }
    public String getDescription(){
        throw new RuntimeException("not have 描述：");
    }
    public boolean isMenu(){
        throw new RuntimeException("not vegetarian");
    }
}
