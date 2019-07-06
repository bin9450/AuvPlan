package com.auv.servicelmpl;

import com.auv.entity.Apk;
import com.auv.mapper.ApkMapper;
import com.auv.service.ApkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * @Author: Pan
 * @Date: 2019/7/5 15:31
 * @Description:
 **/
@Service
public class ApkServicelmpl implements ApkService{
    @Autowired
    ApkMapper apkMapper;
    private static final int pageCount = 10;
    @Override
    public HashMap<String, Integer> getCount() {
        HashMap<String, Integer> hm = new HashMap<>();
        int count = apkMapper.getCount();
        if (count != 0){
            hm.put("code",0);
            hm.put("count",count);
        }else{
            hm.put("code",0);
        }
        return hm;
    }

    @Override
    public List<Apk> getList(int page) {
        int limits = (page-1)*pageCount;
        int limite = pageCount;
        return apkMapper.getList(limits,limite);
    }

    @Override
    public int insertNew(Apk apk) {
        apk.setUpdateTime(new Date());
        return apkMapper.insertNew(apk);
    }

}
