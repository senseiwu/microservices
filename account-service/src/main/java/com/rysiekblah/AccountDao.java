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
        Map roles1 = Maps.newHashMap();
        roles1.put(1l, AccountRoles.ORGANIZER.getCode());
        roles1.put(2l, AccountRoles.VIEWER.getCode());
        accounts.put(1l, new Account(1, "Tomasz", AccountRoles.ADMIN, roles1));

        Map roles2 = Maps.newHashMap();
        roles2.put(1l, AccountRoles.VIEWER.getCode());
        roles2.put(2l, AccountRoles.ORGANIZER.getCode());
        accounts.put(2l, new Account(2, "Rysiek", AccountRoles.ORGANIZER, roles2));
    }
}
