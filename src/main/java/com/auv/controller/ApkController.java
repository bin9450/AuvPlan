package com.auv.controller;

import com.auv.entity.Apk;
import com.auv.service.ApkService;
import com.auv.util.FileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;

/**
 * @Author: Pan
 * @Date: 2019/7/5 16:09
 * @Description:
 **/
@RestController
@RequestMapping("/apk")
public class ApkController {
    @Autowired
    ApkService apkService;

    @GetMapping("/getCount")
    public HashMap<String,Integer> getCount(){
        return apkService.getCount();
    }

    @GetMapping("/getList")
    public List<Apk> getList(@RequestParam int page){
        return apkService.getList(page);
    }

    @PostMapping ("/upload")
    public HashMap<String,Object> addApk(MultipartFile apkFile){
        FileUpload fud = new FileUpload();
        return fud.addFile(apkFile,"/auvres/apk/");
    }

    @PostMapping("/update")
    public HashMap<String,Integer> insertNew(Apk apk) {
        HashMap<String,Integer> hm = new HashMap<>();
        int result = apkService.insertNew(apk);
        if (result != 0){
            hm.put("code",1);
        }else {
            hm.put("code",0);
        }
        return hm;
    }

}
