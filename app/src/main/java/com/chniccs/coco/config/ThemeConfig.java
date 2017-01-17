package com.chniccs.coco.config;

import android.support.annotation.ColorInt;

/**
 * Created by ccs on 17/1/6.
 *
 */

public enum  ThemeConfig {
    INSTANCE;
    private int mColorPrimary;
    public void setColor(@ColorInt int colorPrimary){
        mColorPrimary=colorPrimary;
    }
    public int getColor(){
        return mColorPrimary;
    }
}
