package com.androidhl.english;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;


import com.androidhl.english.adapter.GridViewAdapter;
import com.androidhl.english.bean.Menu;
import com.androidhl.english.bean.MenuComponent;
import com.androidhl.english.bean.MenuItem;
import com.androidhl.english.utils.AssetsUtils;
import com.androidhl.english.utils.MediaPlayerUtils;
import com.androidhl.english.view.TestView;

import java.io.FileDescriptor;


public class HomeActivity extends ActionBarActivity {

    GridView gridView;
    RadioGroup titleRG;
    Menu voewlMenu = null;
    Menu consonantMenu = null;
    GridViewAdapter gridViewAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_hl);
        gridView = (GridView) findViewById(R.id.gridView_home_hl);
        titleRG = (RadioGroup) findViewById(R.id.title_layout_hl);
        titleRG.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId==R.id.title_vowel_hl){
                    gridViewAdapter.setLists(voewlMenu.getChilds());
                    gridViewAdapter.notifyDataSetInvalidated();
                }else {
                    gridViewAdapter.setLists(consonantMenu.getChilds());
                    gridViewAdapter.notifyDataSetInvalidated();
                }
            }
        });
        init();
    }

    private void init() {

        voewlMenu = new Menu("vowel",getResources().getString(R.string.vowel_name_hl));
        consonantMenu = new Menu("consonant",getResources().getString(R.string.consonant_name_hl));
        String[] vowels1 = getResources().getStringArray(R.array.vowel_1_lists_hl);
        String[] vowels2 = getResources().getStringArray(R.array.vowel_2_lists_hl);
        String[] vowels3 = getResources().getStringArray(R.array.vowel_3_lists_hl);

        String[] consonant1 = getResources().getStringArray(R.array.consonant_1_lists_hl);
        String[] consonant2 = getResources().getStringArray(R.array.consonant_2_lists_hl);

        addMenu(voewlMenu,vowels1, getResources().getString(R.string.vowel_type_1_hl));
        addMenu(voewlMenu,vowels2, getResources().getString(R.string.vowel_type_2_hl));
        addMenu(voewlMenu,vowels3, getResources().getString(R.string.vowel_type_3_hl));

        addMenu(consonantMenu,consonant1, getResources().getString(R.string.consonant_type_1_hl));
        addMenu(consonantMenu,consonant2, getResources().getString(R.string.consonant_type_2_hl));
        gridViewAdapter = new GridViewAdapter(voewlMenu.getChilds(), this);
        gridView.setAdapter(gridViewAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                MenuComponent item = (MenuComponent) gridViewAdapter.getItem(position);
                if(item!=null){
                    MediaPlayerUtils.start(AssetsUtils.getAssetsMusicPath(item.getName(), HomeActivity.this));
//                    Toast.makeText(HomeActivity.this,item.getName(),Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void addMenu(Menu menu, String[] menuItems, String description) {
        if (menuItems!=null&&menuItems.length>0){
            for (String name : menuItems) {
                menu.add(new MenuItem(name,description));
            }
        }
    }


}
