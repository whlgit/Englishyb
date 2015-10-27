package com.androidhl.english.bean;

/**
 * Created by Administrator on 2015-5-12.
 */
public class ConsonantMenuItem extends Menu{

    public ConsonantMenuItem(String name) {
        super(name, "辅音");
        init();
    }

    private void init() {
//        爆破音
        add(new MenuItem("consonant_2111","清辅音"));
        add(new MenuItem("consonant_2112","清辅音"));
        add(new MenuItem("consonant_2113","清辅音"));

        add(new MenuItem("consonant_2121","浊辅音"));
        add(new MenuItem("consonant_2122","浊辅音"));
        add(new MenuItem("consonant_2123","浊辅音"));
//        摩擦音
        add(new MenuItem("consonant_2211","清辅音"));
        add(new MenuItem("consonant_2212","清辅音"));
        add(new MenuItem("consonant_2213","清辅音"));
        add(new MenuItem("consonant_2214","清辅音"));
        add(new MenuItem("consonant_2215","清辅音"));

        add(new MenuItem("consonant_2221","浊辅音"));
        add(new MenuItem("consonant_2222","浊辅音"));
        add(new MenuItem("consonant_2223","浊辅音"));
        add(new MenuItem("consonant_2224","浊辅音"));
        add(new MenuItem("consonant_2225","浊辅音"));
//
        add(new MenuItem("consonant_2311","清辅音"));
        add(new MenuItem("consonant_2312","清辅音"));
        add(new MenuItem("consonant_2313","清辅音"));

        add(new MenuItem("consonant_2321","浊辅音"));
        add(new MenuItem("consonant_2322","浊辅音"));
        add(new MenuItem("consonant_2323","浊辅音"));

//
        add(new MenuItem("consonant_2511","浊辅音"));
        add(new MenuItem("consonant_2512","浊辅音"));
        add(new MenuItem("consonant_2513","浊辅音"));
        add(new MenuItem("consonant_2514","浊辅音"));
        add(new MenuItem("consonant_2515","浊辅音"));
        add(new MenuItem("consonant_2516","浊辅音"));

    }
}
