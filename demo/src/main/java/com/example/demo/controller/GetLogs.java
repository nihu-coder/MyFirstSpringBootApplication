package com.example.demo.controller;

import com.example.demo.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class GetLogs {

    @Autowired
    LogService logService;
    @GetMapping(value = "/example",produces = MediaType.APPLICATION_JSON_VALUE)
    public String getExample() {
        return logService.collectLogsFromFile();

    }


}
