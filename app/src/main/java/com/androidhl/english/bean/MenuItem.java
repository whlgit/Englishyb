package com.androidhl.english.bean;

public class MenuItem extends MenuComponent {
    String name;
    String description;
    boolean isMenu;

    public MenuItem(String name, String description) {
        this.name = name;
        this.description = description;

    }
    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean isMenu() {
        return isMenu;
    }

    @Override
    public String getDescription() {
        return description;
    }

}
