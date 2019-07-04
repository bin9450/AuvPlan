package com.auv.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @Author: Pan
 * @Date: 2019/7/4 8:32
 * @Description:
 **/
@Getter
@Setter
public class Score {

    private int scoreID;
    private int userID;
    private int score;
    private int rank;
    private Date createTime;

}
