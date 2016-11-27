package com.rysiekblah;

import com.google.common.collect.Maps;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * Created by tomek on 10/30/16.
 */

@Repository
public class AccountDao {
    private static Map<Long, Account> accounts = Maps.newHashMap();

    @Autowired
    private AccountRepository repository;

    public Account getByAccountId(long accountId) throws AccountRepositoryException {
        //return accounts.get(accountId);
        return repository.findById(accountId);
    }

    static {
        accounts.put(1l, new Account(1, "Tomasz", AccountRoles.ADMIN.name()));
        accounts.put(2l, new Account(2, "Rysiek", AccountRoles.ORGANIZER.name()));
    }

    public void insert(Account account) {
//        accounts.put(account.getAccountId(), account);
//        System.out.println("ACCOUNTS: " + accounts);
        repository.insert(account);
    }
}
