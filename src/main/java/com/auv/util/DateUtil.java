package com.auv.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: Pan
 * @Date: 2019/7/4 10:26
 * @Description:
 **/
public class DateUtil {

    @Override
    public String toString() {
        Date date = new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(date);
    }

}
