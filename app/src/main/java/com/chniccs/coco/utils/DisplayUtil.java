package com.chniccs.coco.utils;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

public class DisplayUtil
{
    public static int dp2px(float paramFloat, Context paramContext)
    {
        return (int)(paramFloat * (getMetrics(paramContext).densityDpi / 160.0F));
    }

    private static DisplayMetrics getMetrics(Context paramContext)
    {
        DisplayMetrics localDisplayMetrics = new DisplayMetrics();
        ((WindowManager)paramContext.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay().getMetrics(localDisplayMetrics);
        return localDisplayMetrics;
    }

    public static int getScreenHeight(Context paramContext)
    {
        return getMetrics(paramContext).heightPixels;
    }

    public static int getScreenWidth(Context paramContext)
    {
        return getMetrics(paramContext).widthPixels;
    }

    public static int getStatusBarHeight(Context paramContext)
    {
        int i = 38;
        int j = paramContext.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (j > 0) {
            i = paramContext.getResources().getDimensionPixelSize(j);
        }
        return i;
    }

    public static float px2dp(float paramFloat, Context paramContext)
    {
        return paramFloat / (getMetrics(paramContext).densityDpi / 160.0F);
    }
}
