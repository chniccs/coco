package com.chniccs.coco.utils;

import android.widget.Toast;
import com.chniccs.coco.App;

public class ToastUtil
{
    public static void show(int paramInt)
    {
        Toast.makeText(App.getINSTANCE(), paramInt, Toast.LENGTH_SHORT).show();
    }

    public static void show(String paramString)
    {
        Toast.makeText(App.getINSTANCE(), paramString, Toast.LENGTH_SHORT).show();
    }
}
