package com.me.study.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangchendong
 * @date 2021/03/26
 */
@RestController
@RequestMapping("/data")
public class DataController {

    @GetMapping("/getData")
    public String getData() {
        return "{\"deviceID\":\"84f3eb4bb9100000\",\"date\":\"2021-03-23\",\"index\":{\"hr\":0,\"br\":0,\"movment\":0,\"snore\":0,\"snorecount\":0,\"fallinsleep\":null,\"lightsleep\":0,\"deepsleep\":0,\"remsleep\":0,\"dursleep\":0,\"durwake\":4,\"onbedtime\":\"2021-03-23 13:06:28\",\"offbedtime\":\"2021-03-23 13:07:36\",\"sleeptime\":\"\",\"waketime\":\"\",\"score\":28,\"strength\":null,\"brain\":null},\"timeline\":{\"status\":[{\"stime\":\"2021-03-23 13:06:28\",\"etime\":\"2021-03-23 13:06:28\"},{\"stime\":\"2021-03-23 13:07:36\",\"etime\":\"2021-03-23 13:07:36\"}]},\"items\":[{\"time\":\"2021-03-23 13:06:28\",\"hr\":0,\"br\":0,\"cmov\":1,\"sta\":3,\"snore\":0},{\"time\":\"2021-03-23 13:07:36\",\"hr\":0,\"br\":0,\"cmov\":1,\"sta\":3,\"snore\":0}],\"info\":{\"uploadTime\":\"2021-03-23 05:08:12\",\"power\":255,\"ip\":\"113.132.11.98\",\"status\":\"1F\",\"version\":\"09000001\"}}";
    }
}
