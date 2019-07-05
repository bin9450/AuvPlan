package com.auv.servicelmpl;

import com.auv.entity.Scene;
import com.auv.mapper.SceneMapper;
import com.auv.service.SceneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * @Author: Pan
 * @Date: 2019/7/4 11:03
 * @Description:
 **/
@Service
public class SceneServicelmpl implements SceneService{
    @Autowired
    SceneMapper sceneMapper;

    private final static  int pageCount = 10;

    @Override
    public List<Scene> getList(int page) {
        int limits = pageCount * (page-1);
        int limite = pageCount;
        List<Scene> result = sceneMapper.getList(limits,limite);
        return result;
    }

    @Override
    public Scene getScene(int sceneID) {
        return sceneMapper.getScene(sceneID);
    }

    @Override
    public HashMap<String, Integer> getCount() {
        int count = sceneMapper.getCount();
        HashMap<String, Integer> hm = new HashMap<>();
        if (count != 0){
            hm.put("code",1);
            hm.put("count",count);
        }else {
            hm.put("code",0);
            hm.put("count",0);
        }
        return hm;
    }

}
