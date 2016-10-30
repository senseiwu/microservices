package com.rysiekblah;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by tomek on 10/30/16.
 */

@Service
public class AccountServiceClient {

    @LoadBalanced
    @Autowired
    private RestTemplate restTemplate;

    private String serviceUrl = "http://ACCOUNT-SERVICE";

    public String getRoleForEvent(Long accountId, Long eventId) {
        String role = restTemplate.getForObject(serviceUrl + "/accout/{accountId}/event/{eventId}", String.class, accountId, eventId);
        if (role == null) {
            throw new AccountNotFoundException("Account with id: " + accountId + " not found");
        }
        return role;
    }
}
