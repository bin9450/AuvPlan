package com.auv.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 * @Author: Pan
 * @Date: 2019/7/4 10:26
 * @Description:
 **/
public class DateUtil {

    public String toName()  {
        Date date = new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
        return sdf.format(date);
    }

    public Date toTime() throws ParseException {
        java.util.Locale locale=java.util.Locale.CHINA;
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MMdd-HH:mm:ss",locale);
        Date date = new Date();
        String d= sdf.format(date);
      //  System.out.println(sdf.parse(d));
        return sdf.parse(d);
    }
}
