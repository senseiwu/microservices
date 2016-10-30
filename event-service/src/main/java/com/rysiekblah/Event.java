package com.rysiekblah;

import com.google.common.base.MoreObjects;

/**
 * Created by tomek on 10/30/16.
 */
public class Event {
    private long id;
    private String name;
    private String description;
    private String organizer;
    private String where;
    private long admin;

    public Event() {

    }

    public Event(long id, String name, String description, String organizer, String where) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.organizer = organizer;
        this.where = where;
    }

    public Event update(Event event) {
        this.name = event.getName();
        this.description = event.getDescription();
        this.organizer = event.getOrganizer();
        this.where = event.getWhere();
        return this;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getOrganizer() {
        return organizer;
    }

    public String getWhere() {
        return where;
    }

    public long getAdmin() {
        return admin;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setOrganizer(String organizer) {
        this.organizer = organizer;
    }

    public void setWhere(String where) {
        this.where = where;
    }

    public void setAdmin(long admin) {
        this.admin = admin;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", id)
                .add("name", name)
                .add("description", description)
                .add("organizer", organizer)
                .add("where", where)
                .toString();
    }
}
