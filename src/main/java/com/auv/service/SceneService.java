package com.auv.service;

import com.auv.entity.Scene;

import java.util.HashMap;
import java.util.List;

/**
 * @Author: Pan
 * @Date: 2019/7/4 11:02
 * @Description:
 **/
public interface SceneService {
    List<Scene> getList(int page);
    Scene getScene(int sceneID);
    HashMap<String,Integer> getCount();
}
