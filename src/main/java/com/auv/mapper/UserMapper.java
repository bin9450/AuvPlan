package com.auv.mapper;

import com.auv.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: Pan
 * @Date: 2019/7/2 20:35
 * @Description:
 **/
@Repository
public interface UserMapper {
    User sel(int userID);
    User login(@Param("loginName") String loginName,@Param("passWord") String passWord);
    User isRepeat(String loginName);
    int register(User user);
    int changePSW(@Param("userID") int userID,@Param("passWord") String passWord,@Param("newPassWord") String newPassWord);
    int changeInfo(@Param("userID") int userID,@Param("headUrl") String headUrl,@Param("nickName") String nickName);
    User getInfo(int userID);
    List<User> getList(@Param("start") int start,@Param("num") int num);
    int getCount();
    int changeScore(@Param("userID") int userID,@Param("totalScore") int totalScore);
    int changeBestScore(@Param("userID") int userID,@Param("bestScore") int bestScore);
    List<User> getTotalRank();
}
