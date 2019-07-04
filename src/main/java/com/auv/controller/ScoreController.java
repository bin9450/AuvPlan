package com.auv.controller;

import com.auv.entity.Score;
import com.auv.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/getRank")
    public List<Score> getRank() {
        return  scoreService.getRank();
    }

    @GetMapping("/getMyScore")
    public List<Score> getMyscore(@RequestParam int userID,@RequestParam int page) {
        return scoreService.getMyscore(userID,page);
    }

    @PostMapping("/upload")
    public HashMap<String,Object> upload(Score score) {
        return scoreService.upload(score);
    }

}
