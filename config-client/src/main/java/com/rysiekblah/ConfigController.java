package com.rysiekblah;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Tomasz_Kozlowski on 12/4/2016.
 */
@RestController
@RefreshScope
public class ConfigController {

    @Value("${info.description}") private String appDescription;
    @Value("${info.url}") private String appUrl;

    @RequestMapping("/info")
    public String info() {
        return "Application " + appDescription + " hosted " + appUrl;
    }
}
