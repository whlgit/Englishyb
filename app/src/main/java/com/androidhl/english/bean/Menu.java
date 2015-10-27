package com.androidhl.english.bean;

import java.util.ArrayList;

/**
 * Created by Administrator on 2015-5-12.
 */
public class Menu extends MenuComponent {
    ArrayList<MenuComponent> menuComponent = new ArrayList<MenuComponent>();
    boolean isMenu=true;
    String name, description;

    public Menu(String name, String description) {
        this.name = name;
        this.description = description;

    }
    public void setMenu(boolean isMenu) {
        this.isMenu = isMenu;
    }

    @Override
    public boolean isMenu() {
        return isMenu;
    }

    @Override
    public void add(MenuComponent component) {
        menuComponent.add(component);
    }

    @Override
    public void remove(MenuComponent component) {
        menuComponent.remove(component);
    }

    public MenuComponent getChild(int i) {
        return menuComponent.get(i);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    public ArrayList<MenuComponent> getChilds() {
        return menuComponent;
    }
}
