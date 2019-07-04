package com.auv.service;

import com.auv.entity.User;

/**
 * @Author: Pan
 * @Date: 2019/7/2 20:39
 * @Description:
 **/
public interface UserService {
    User sel(int userID);
    User login(String loginName,String passWord);
    User isRepeat(String loginName);
    int register(User user);
    int changePSW(int userID,String newPassWord, String passWord);
    int changeInfo(int userID,String headUrl, String nickName);
    User getInfo(int userID);
}
