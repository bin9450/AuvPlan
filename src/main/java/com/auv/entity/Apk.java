package com.auv.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @Author: Pan
 * @Date: 2019/7/5 15:19
 * @Description:
 **/
@Getter
@Setter
public class Apk {
    private int versionID;
    private String apkFileURL;
    private String versionNo;
    private String detail;
    private int fileLength;
    private Date updateTime;

}
