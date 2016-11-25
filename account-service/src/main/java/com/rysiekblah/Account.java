package com.rysiekblah;

import com.google.common.base.Objects;
import com.google.gson.Gson;

import java.util.Map;

/**
 * Created by tomek on 10/30/16.
 */
public class Account {
    private long accountId;
    private String name;
    private AccountRoles role;
    private Map<Long, Integer> eventRoleMap;

    public Account() {

    }

    public Account(long accountId, String name, AccountRoles role, Map<Long, Integer> eventRoleMap) {
        this.accountId = accountId;
        this.name = name;
        this.role = role;
        this.eventRoleMap = eventRoleMap;
    }

    public long getAccountId() {
        return accountId;
    }

    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AccountRoles getRole() {
        return role;
    }

    public void setRole(AccountRoles role) {
        this.role = role;
    }

    public Map<Long, Integer> getEventRoleMap() {
        return eventRoleMap;
    }

    public void setEventRoleMap(Map<Long, Integer> eventRoleMap) {
        this.eventRoleMap = eventRoleMap;
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

    public String toJson() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}
