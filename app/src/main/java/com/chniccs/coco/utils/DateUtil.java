package com.chniccs.coco.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateUtil
{
    public static String dateFormat(String paramString)
    {
        if (paramString == null) {
            return "unknown";
        }
        SimpleDateFormat localSimpleDateFormat1 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SS");
        SimpleDateFormat localSimpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd");
        try
        {
            String str = localSimpleDateFormat2.format(localSimpleDateFormat1.parse(paramString));
            return str;
        }
        catch (ParseException localParseException) {}
        return "unknown";
    }
}
