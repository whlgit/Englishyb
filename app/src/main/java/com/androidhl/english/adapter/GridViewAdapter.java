package com.androidhl.english.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.androidhl.english.bean.MenuComponent;
import com.androidhl.english.view.PhoneticView;

import java.util.List;

public class GridViewAdapter extends BaseAdapter{

    private List<MenuComponent> lists;
    private Context context;

    public GridViewAdapter(List<MenuComponent> lists,Context context){
        this.lists = lists;
        this.context = context;
    }
    @Override
    public int getCount() {
        if (lists!=null)
            return lists.size();
        else
            return 0;
    }

    public void setLists(List<MenuComponent> lists) {
        this.lists = lists;
    }

    @Override
    public Object getItem(int position) {
        return lists.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        PhoneticView phoneticView;
        if (convertView==null) {
            phoneticView = new PhoneticView(context);
            phoneticView.setTag(phoneticView);
        }else {
            phoneticView= (PhoneticView) convertView.getTag();
        }
        phoneticView.setMenuComponent(lists.get(position));
        return phoneticView;
    }
}
