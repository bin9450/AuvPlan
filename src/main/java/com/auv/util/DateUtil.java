package com.auv.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: Pan
 * @Date: 2019/7/4 10:26
 * @Description:
 **/
public class DateUtil {

    public String toName() {
        Date date = new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
        return sdf.format(date);
    }

}
