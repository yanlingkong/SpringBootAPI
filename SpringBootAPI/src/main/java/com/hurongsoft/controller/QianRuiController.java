package com.hurongsoft.controller;

import com.hurongsoft.configuration.properties.QianruiProperties;
import com.hurongsoft.configuration.properties.config.FtpConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/api/qianrui")
@Slf4j
public class QianRuiController {
    private final QianruiProperties qianruiProperties;

    @Autowired
    public QianRuiController(QianruiProperties qianruiProperties) {
        this.qianruiProperties = qianruiProperties;
    }

    @GetMapping("/test")
    @ResponseBody
    public FtpConfig test(){
        log.info("1231");
        return qianruiProperties.getFtp();
    }
}
