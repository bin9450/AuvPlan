package com.auv.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @Author: Pan
 * @Date: 2019/7/4 10:42
 * @Description:
 **/
@Getter
@Setter
public class Scene {
    private int sceneID;
    private String sceneName;
    private String sceneFileUrl;
    private String description;
    private Date lastUpdateTime;
}
