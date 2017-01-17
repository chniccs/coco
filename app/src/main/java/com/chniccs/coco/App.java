package com.chniccs.coco;

import android.app.Application;
import android.support.v4.content.ContextCompat;

import com.chniccs.coco.config.ThemeConfig;

/**
 * Created by ccs on 17/1/6.
 * application类
 */

public class App extends Application {
    private static App INSTANCE;

    @Override
    public void onCreate() {
        super.onCreate();
        INSTANCE=this;
        ThemeConfig.INSTANCE.setColor(ContextCompat.getColor(this,R.color.colorPrimary));
    }
    public static App getINSTANCE(){
        return INSTANCE;
    }
}
