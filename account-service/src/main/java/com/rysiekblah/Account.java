package com.rysiekblah;

import com.google.common.base.Objects;

import java.util.Map;

/**
 * Created by tomek on 10/30/16.
 */
public class Account {
    private long accountId;
    private String name;
    private AccountRoles role;
    private Map<Integer, Integer> eventRoleMap;

    public Account(long accountId, String name, AccountRoles role, Map<Integer, Integer> eventRoleMap) {
        this.accountId = accountId;
        this.name = name;
        this.role = role;
        this.eventRoleMap = eventRoleMap;
    }

    public String getName() {
        return name;
    }

    public AccountRoles getRole() {
        return role;
    }

    public Map<Integer, Integer> getEventRoleMap() {
        return eventRoleMap;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return accountId == account.accountId;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(accountId);
    }
}
