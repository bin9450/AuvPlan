package com.auv.service;

import com.auv.entity.Score;
import com.auv.entity.User;

import java.util.HashMap;
import java.util.List;

/**
 * @Author: Pan
 * @Date: 2019/7/4 8:40
 * @Description:
 **/
public interface ScoreService {
    List<Score> getMyscore(int userID, int page);
    HashMap<String,Object> upload(Score score,int userID);
    int getCount(int userID);
    List<Score> getRank();
    List<User> getTotalRank();
}
