package com.auv.mapper;

import com.auv.entity.Scene;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: Pan
 * @Date: 2019/7/4 10:47
 * @Description:
 **/
@Repository
public interface SceneMapper {
    List<Scene> getList(@Param("limits") int limits,@Param("limite") int limite);
    Scene getScene(@Param("sceneID") int sceneID);
    int getCount();
}
