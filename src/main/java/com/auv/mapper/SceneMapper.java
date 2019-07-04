package com.auv.mapper;

import com.auv.entity.Scene;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: Pan
 * @Date: 2019/7/4 10:47
 * @Description:
 **/
@Repository
public interface SceneMapper {
    int adminUpload(Scene scene);
    int addScene(Scene scene);
    int getCount();
    List<Scene> getList();
    Scene getScene(int sceneID);
    List<Scene> getHistory(int sceneID);
}
