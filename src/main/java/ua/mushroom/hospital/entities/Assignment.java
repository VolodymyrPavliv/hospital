package ua.mushroom.hospital.entities;

import ua.mushroom.hospital.dao.impl.UserDAOImpl;

import java.sql.Date;

public class Assignment {
    private int id;
    private String type;
    private String description;
    private int userId;
    private User user;
    private Date date;
    private int recordId;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getRecordId() {
        return recordId;
    }

    public void setRecordId(int recordId) {
        this.recordId = recordId;
    }

    public User getUser() {
        return new UserDAOImpl().findById(userId).get();
    }
}
