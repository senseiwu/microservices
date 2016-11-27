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
    private String role;

    public Account() {

    }

    public Account(long accountId, String name, String role) {
        this.accountId = accountId;
        this.name = name;
        this.role = role;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
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
