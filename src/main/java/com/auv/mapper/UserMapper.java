package com.auv.mapper;

import com.auv.entity.User;
import org.springframework.stereotype.Repository;

/**
 * @Author: Pan
 * @Date: 2019/7/2 20:35
 * @Description:
 **/
@Repository
public interface UserMapper {
    User sel(int userID);
    User login(String loginName,String passWord);
    User isRepeat(String loginName);
    int register(User user);
}
