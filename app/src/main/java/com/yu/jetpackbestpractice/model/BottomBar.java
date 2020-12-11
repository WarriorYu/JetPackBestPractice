package com.yu.jetpackbestpractice.model;

import java.util.List;

/**
 * @author :   yuxibing
 * @date :   2020/12/10
 * Describe :
 */
public class BottomBar {

    /**
     * activeColor : #333333
     * inActiveColor : #666666
     * selectTab : 0
     * tabs : [{"size":24,"enable":true,"index":0,"pageUrl":"main/tabs/home","title":"首页"}]
     */

    public String activeColor;
    public String inActiveColor;
    public int selectTab;//底部导航栏默认选中项
    public List<Tab> tabs;

    public static class Tab {
        /**
         * size : 24
         * enable : true
         * index : 0
         * pageUrl : main/tabs/home
         * title : 首页
         */

        public int size;
        public boolean enable;
        public int index;
        public String pageUrl;
        public String title;
        public String tintColor;
    }
}
