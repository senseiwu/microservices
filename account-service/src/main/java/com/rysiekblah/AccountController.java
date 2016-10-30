package com.rysiekblah;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by tomek on 10/30/16.
 */

@RestController
public class AccountController {

    @Autowired
    private AccountDao accountDao;

    @RequestMapping("account/{accountId}")
    public String getAccountRole(@PathVariable("accountId") Integer accountId) {
        Account account = accountDao.getByAccountId(accountId);
        if (account == null) {
            return null;
        }
        return account.getRole().name();
    }
}
