package com.auv.mapper;

import com.auv.entity.Score;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: Pan
 * @Date: 2019/7/4 8:34
 * @Description:
 **/
@Repository
public interface ScoreMapper {
    List<Score> getMyscore(@Param("userID") int userID,
                    @Param("limits") int limits,
                    @Param("limite") int limite);
    int upload(@Param("userID") int userID,
               @Param("localScore") int localScore);
    int getCount(@Param("userID") int userID);
    List<Score> getRank();
}
