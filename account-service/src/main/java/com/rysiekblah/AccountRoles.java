package com.rysiekblah;

/**
 * Created by tomek on 10/30/16.
 */
public enum AccountRoles {
    ADMIN(1, "User can manage accounts"),
    ORGANIZER(2, "User can manage events"),
    VIEWER(3, "User can not manage enything");

    private final int code;
    private final String description;

    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    AccountRoles(int code, String description) {
        this.code = code;
        this.description = description;
    }
}
