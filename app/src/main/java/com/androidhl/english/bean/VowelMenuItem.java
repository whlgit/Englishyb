package com.androidhl.english.bean;

/**
 * Created by Administrator on 2015-5-12.
 */
public class VowelMenuItem extends Menu {
    public VowelMenuItem(String name) {
        super(name, "元音");
        init();
    }

    private void init() {
        add(new MenuItem("Vowel_1111","长元音"));
        add(new MenuItem("Vowel_1112","长元音"));
        add(new MenuItem("Vowel_1113","长元音"));
        add(new MenuItem("Vowel_1114","长元音"));
        add(new MenuItem("Vowel_1115","长元音"));

        add(new MenuItem("Vowel_1121","短元音"));
        add(new MenuItem("Vowel_1122","短元音"));
        add(new MenuItem("Vowel_1123","短元音"));
        add(new MenuItem("Vowel_1124","短元音"));
        add(new MenuItem("Vowel_1125","短元音"));
        add(new MenuItem("Vowel_1126","短元音"));
        add(new MenuItem("Vowel_1127","短元音"));

        add(new MenuItem("Vowel_1211","双元音"));
        add(new MenuItem("Vowel_1212","双元音"));
        add(new MenuItem("Vowel_1213","双元音"));
        add(new MenuItem("Vowel_1214","双元音"));
        add(new MenuItem("Vowel_1215","双元音"));
        add(new MenuItem("Vowel_1216","双元音"));
        add(new MenuItem("Vowel_1217","双元音"));
        add(new MenuItem("Vowel_1218","双元音"));
    }
}
