package com.rysiekblah;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by tomek on 10/30/16.
 */

@RestController
public class EventController {

    protected Logger logger = Logger.getLogger(EventController.class.getName());

    @Autowired
    private AccountServiceClient accountServiceClient;

    @RequestMapping("event/{accountId}")
    public String getRole(@PathVariable("accountId") String accountId) {
        String role = accountServiceClient.getRoleForEvent(accountId);
        logger.info("Account: " + accountId + " has Role: " + role);
        return role;
    }
}
