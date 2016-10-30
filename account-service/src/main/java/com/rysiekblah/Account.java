package com.rysiekblah;

import java.util.Map;

/**
 * Created by tomek on 10/30/16.
 */
public class Account {
    private String name;
    private Map<Integer, Integer> eventRoleMap;

    public Account(String name, Map<Integer, Integer> eventRoleMap) {
        this.name = name;
        this.eventRoleMap = eventRoleMap;
    }

    public String getName() {
        return name;
    }

    public Map<Integer, Integer> getEventRoleMap() {
        return eventRoleMap;
    }
}
