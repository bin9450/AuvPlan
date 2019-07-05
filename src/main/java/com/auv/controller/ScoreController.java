package com.auv.controller;

import com.auv.entity.Score;
import com.auv.entity.User;
import com.auv.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

/**
 * @Author: Pan
 * @Date: 2019/7/4 9:32
 * @Description:
 **/
@RestController
@RequestMapping("/score")
public class ScoreController {
    @Autowired
    ScoreService scoreService;

    @GetMapping("/getRank2")
    public List<Score> getRank() {
        return  scoreService.getRank();
    }

    @GetMapping("/getMyScore")
    public List<Score> getMyscore(@RequestParam int page,  HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("session_user");
        return scoreService.getMyscore(user.getUserID(),page);
    }

    @PostMapping("/upload")
    public HashMap<String,Object> upload(Score score , HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("session_user");
        return scoreService.upload(score,user.getUserID());
    }

    @GetMapping("/getRank")
    public List<User> getTotalRank() {
        return scoreService.getTotalRank();
    }

}
