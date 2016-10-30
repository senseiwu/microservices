package com.rysiekblah;

import com.google.common.collect.Maps;

import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * Created by tomek on 10/30/16.
 */

@Repository
public class AccountDao {
    private static Map<Long, Account> accounts = Maps.newHashMap();

    public Account getByAccountId(long accountId) {
        return accounts.get(accountId);
    }

    static {
        accounts.put(1l, new Account(1, "Tomasz", AccountRoles.ADMIN, null));
        accounts.put(2l, new Account(2, "Rysiek", AccountRoles.ORGANIZER, null));
    }
}
