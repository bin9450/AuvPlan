package com.auv.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @Author: Pan
 * @Date: 2019/7/2 20:24
 * @Description:
 **/

@Getter
@Setter
public class User {

    private int userID;
    private String nickName;
    private String loginName;
    private String passWord;
    private String headUrl;
    private Integer totalScore;
    private Integer bestScore;
    private Date time;
}
