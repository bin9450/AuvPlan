package com.auv.service;

import com.auv.entity.Apk;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

/**
 * @Author: Pan
 * @Date: 2019/7/5 15:30
 * @Description:
 **/
public interface ApkService {
    HashMap<String,Integer> getCount();
    List<Apk> getList(int page);
    int insertNew(Apk apk);
}
