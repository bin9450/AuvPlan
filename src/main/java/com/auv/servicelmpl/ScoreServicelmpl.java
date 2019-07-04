package com.auv.servicelmpl;

import com.auv.entity.Score;
import com.auv.mapper.ScoreMapper;
import com.auv.service.ScoreService;;
import com.auv.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * @Author: Pan
 * @Date: 2019/7/4 8:41
 * @Description:
 **/
@Service
public class ScoreServicelmpl implements ScoreService {
    @Autowired
    ScoreMapper scoreMapper;

    DateUtil dateUtil = new DateUtil();
    private static final int pageCount = 10;    //每页的数量

    @Override
    public List<Score> getMyscore(int userID, int page) {
        int limits = pageCount * (page-1);
        int limite =pageCount;
        List<Score> result = scoreMapper.getMyscore(userID,limits,limite);
        return result;
    }

    @Override
    public HashMap<String,Object> upload(Score score) {
        score.setCreateTime(new Date());
        int result = scoreMapper.upload(score);
        Integer i = new Integer(result);
        HashMap<String,Object> hashResult = new HashMap<>();
        hashResult.put("code",i);
        return hashResult;
    }

    @Override
    public int getCount(int userID) {
        return scoreMapper.getCount(userID);
    }

    @Override
    public List<Score> getRank() {
        List<Score> result = scoreMapper.getRank();
        return  result;
    }
}
