package ua.mushroom.hospital.entities;

import java.sql.Date;

public class Assignment {
    private int id;
    private String description;
    private int type_id;
    private int user_id;
    private Date date;
    private int hospital_card_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getType_id() {
        return type_id;
    }

    public void setType_id(int type_id) {
        this.type_id = type_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getHospital_card_id() {
        return hospital_card_id;
    }

    public void setHospital_card_id(int hospital_card_id) {
        this.hospital_card_id = hospital_card_id;
    }
}
