package com.auv.controller;

import com.auv.entity.User;
import com.auv.service.UserService;
import com.auv.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;

/**
 * @Author: Pan
 * @Date: 2019/7/2 20:43
 * @Description:
 **/
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    private static final String key = "wasd";

    @PostMapping("/login")
    public  HashMap<String,Object> loginCheck(User user, HttpServletRequest request,String sign){
        HashMap<String,Object> hm = new HashMap<>();
        if (!key.equals(sign)){
            hm.put("code",-1);
            return  hm;
        }
        String loginName = user.getLoginName();
        String password = MD5Util.md5(user.getPassWord());
        User chuser = userService.login(loginName,password);
        if(chuser == null ){
            hm.put("code",0);
            return  hm;
        }else {
            HttpSession session = request.getSession();
            session.setAttribute("session_user",chuser);
            session.setMaxInactiveInterval(-1);
            hm.put("code",1);
            hm.put("user",chuser);
            return  hm;
        }
    }

    @PostMapping("/resgister")
    public  HashMap<String,Object> resgister(User user, String sign){
        HashMap<String,Object> hm = new HashMap<>();
        if (!key.equals(sign)){
            hm.put("code",-1);
            return  hm;
        }
        if(user.getLoginName() == null
                ||user.getPassWord() == null
                ||userService.isRepeat(user.getLoginName()) != null ){
            hm.put("code",0);
            return  hm;
        }else{
            user.setPassWord(MD5Util.md5(user.getPassWord()));
            int u = userService.register(user);
            hm.put("code",1);
            hm.put("user",user);
            return  hm;
        }
    }

    @PostMapping("/outLogin")
    public int outLogin (HttpServletRequest request, String sign){
        if (!key.equals(sign)){
            return  -1;
        }
        request.getSession().removeAttribute("session_user");
        return 1;
    }

    @PostMapping("/ChangePSW")
    public HashMap<String,Integer> changePSW(int UserID,String LastPassWord,String NewPassWord){
        int result = userService.changePSW(UserID,MD5Util.md5(LastPassWord),MD5Util.md5(NewPassWord));
        HashMap<String,Integer> hm = new HashMap<>();
        hm.put("code",result);
        return hm;
    }

    @PostMapping("/changeInfo")
    public HashMap<String,Integer> changeInfo(int UserID,String HeadUrl,String NickName){
        int result = userService.changeInfo(UserID,HeadUrl,NickName);
        HashMap<String,Integer> hm = new HashMap<>();
        hm.put("code",result);
        return hm;
    }

    @PostMapping("/Info")
    public HashMap<String,Object> getInfo(int UserID) {
        User result = userService.getInfo(UserID);
        HashMap<String,Object> hm = new HashMap<>();
        if (result == null){
            hm.put("code",0);
        }else {
            hm.put("code",1);
            hm.put("user",result);
        }
        return hm;
    }

    @PostMapping("uploadHeadImg")
    public HashMap<String,Object> upload(MultipartFile fileUpload){
        HashMap<String,Object> hm = new HashMap<>();
        //获取文件名
        String fileName = fileUpload.getOriginalFilename();
        //获取文件后缀名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        //重新生成文件名
        fileName = "1"+suffixName;
        //指定本地文件夹存储图片
        String filePath = "E:/Administrator/Downloads/userimg/";
        try {
            //将图片保存到static文件夹里
            fileUpload.transferTo(new File(filePath+fileName));
            hm.put("code",1);
            hm.put("HeadUrl","211.87.227.223/"+filePath+fileName);
            return hm;
        } catch (Exception e) {
            e.printStackTrace();
            hm.put("code",0);
            return  hm;
        }
    }

}
