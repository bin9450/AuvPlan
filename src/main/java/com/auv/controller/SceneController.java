package com.auv.controller;

import com.auv.entity.Scene;
import com.auv.service.SceneService;
import com.auv.util.DateUtil;
import com.auv.util.FileDownload;
import com.auv.util.FileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
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
        return fud.addFile(sceneFile,"/auvres/scene/");
    }

    @GetMapping("/download")
    public ResponseEntity<byte[]> downloadsEntity(HttpServletRequest request, @RequestParam String fileName) throws Exception {
        FileDownload fileDownload = new FileDownload();
        return  fileDownload.downloadsEntity(request,"D:/auvres/scene/",fileName);
    }

}
