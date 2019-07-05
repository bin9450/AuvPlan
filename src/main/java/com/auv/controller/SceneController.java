package com.auv.controller;

import com.auv.entity.Scene;
import com.auv.service.SceneService;
import com.auv.util.DateUtil;
import com.auv.util.FileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.HashMap;
import java.util.List;

/**
 * @Author: Pan
 * @Date: 2019/7/4 11:04
 * @Description:
 **/
@RestController
@RequestMapping("/scene")
public class SceneController {

    @Autowired
    SceneService sceneService;

    @GetMapping("/getList")
    public List<Scene> getList(@RequestParam int page) {
        return sceneService.getList(page);
    }

    @GetMapping("/getScene")
    public Scene getScene(@RequestParam int sceneID){
        return sceneService.getScene(sceneID);
    }

    @GetMapping("/getCount")
    public HashMap<String, Integer> getCount() {
        return  sceneService.getCount();
    }

    @PostMapping("/add")
    public HashMap<String,Object> addScene(MultipartFile sceneFile){
        FileUpload fud = new FileUpload();
        return fud.addFile(sceneFile,"E:/auvres/scene/");
    }
}
