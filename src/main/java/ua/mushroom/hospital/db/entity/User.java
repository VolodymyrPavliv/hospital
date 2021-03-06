package ua.mushroom.hospital.db.entity;

import ua.mushroom.hospital.db.dao.impl.DoctorInfoDAOImpl;

import java.sql.Date;

/**
 * User entity.
 *
 * @author Volodymyr Pavliv
 *
 */

public class User {
    private int id;
    private String name;
    private String surname;
    private String email;
    private String password;
    private Date birthday;
    private int role_id;

    public User() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /**
     * Gets the DoctorInfo object by userId from the DB
     *
     * @return DoctorInfo object
     *
     */
    public DoctorInfo getDoctorInfo() {
        return new DoctorInfoDAOImpl().findByUserId(id).orElse(new DoctorInfo());
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", birthday=" + birthday +
                ", role_id=" + role_id +
                '}';
    }
}
