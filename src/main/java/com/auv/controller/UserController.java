package com.auv.controller;

import com.auv.entity.User;
import com.auv.service.UserService;
import com.auv.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

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

    @PostMapping("/loginCheck")
    public int loginCheck(User user, HttpServletRequest request,String sign){
        if (!key.equals(sign)){
            return  -1;
        }
        String loginName = user.getLoginName();
        String password = MD5Util.md5(user.getPassWord());
        User chuser = userService.login(loginName,password);
        if(chuser == null ){
            return 0;
        }else {
            HttpSession session = request.getSession();
            session.setAttribute("session_user",chuser);
            session.setMaxInactiveInterval(-1);
            return 1;
        }
    }

    @PostMapping("/resgister")
    public int resgister(User user, String sign){
        if (!key.equals(sign)){
            return  -1;
        }
        if(user.getLoginName() == null
                ||user.getPassWord() == null
                ||userService.isRepeat(user.getLoginName()) != null ){
            return 0;
        }else{
            user.setPassWord(MD5Util.md5(user.getPassWord()));
            int u = userService.register(user);
            return u;
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
}
