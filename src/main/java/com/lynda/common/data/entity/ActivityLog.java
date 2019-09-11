package com.lynda.common.data.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "activity_Log")
public class ActivityLog {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "user")
    private String user;
    @Column(name = "action")
    private String action;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "activity_time")
    private Date date;


    public ActivityLog() {
        super();
    }

    public ActivityLog(String user, String action) {
        this.id = UUID.randomUUID().toString();
        this.user = user;
        this.action = action;
        this.date= new Date();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("user", user)
                .append("action", action)
                .toString();
    }
}
