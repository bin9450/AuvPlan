package com.auv.servicelmpl;

import com.auv.entity.User;
import com.auv.mapper.UserMapper;
import com.auv.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: Pan
 * @Date: 2019/7/2 20:41
 * @Description:
 **/
@Service
public class UserServicelmpl implements UserService{
   @Autowired
    UserMapper userMapper;
    @Override
    public User sel(int userID) {
        return userMapper.sel(userID);
    }

    @Override
    public User login(String loginName, String passWord) {
        return userMapper.login(loginName,passWord);
    }

    @Override
    public User isRepeat(String loginName) {
        return userMapper.isRepeat(loginName);
    }

    @Override
    public int register(User user) {
        return userMapper.register(user);
    }
}