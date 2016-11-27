package com.rysiekblah;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * Created by tomek on 10/30/16.
 */

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountDao accountDao;

    @RequestMapping("/role/{accountId}")
    public String getAccountRole(@PathVariable("accountId") Integer accountId) throws AccountRepositoryException {
        Account account = accountDao.getByAccountId(accountId);
        if (account == null) {
            return null;
        }
        return account.getRole();
    }

    @RequestMapping("/{accountId}")
    public String getAccountObject(@PathVariable("accountId") Integer accountId) throws AccountRepositoryException {
        System.out.println("CALL GET ACCOUNT");
        Account account =  accountDao.getByAccountId(accountId);
        System.out.println("Obtained ACCOUNT: " + account.toJson());
        return account.toJson();
    }

    @RequestMapping(value = "add", method = RequestMethod.POST, consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public void addAccount(@RequestBody Account account) {
        System.out.println("ACCOUNT : " + account.toJson());
        accountDao.insert(account);
    }

//    @RequestMapping("/{accountId}/event/{eventId}")
//    public String getEventRole(@PathVariable Long accountId, @PathVariable Long eventId) {
//        Account account = accountDao.getByAccountId(accountId);
//        return account.getEventRoleMap().get(eventId).toString();
//    }
}
