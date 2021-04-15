package com.ami.activity.controller;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangchendong
 * @date 2021/04/15
 */
@RestController
@RequestMapping("/my")
public class MyController {

    @GetMapping("/statistics")
    public JSONObject statistics() {
        JSONObject result = JSONUtil.createObj();
        result.set("launch", 20);
        result.set("partake", 2873);
        return result;
    }
}
