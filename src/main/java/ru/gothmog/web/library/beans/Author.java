package ru.gothmog.web.library.beans;

import java.sql.Date;

/**
 * Created by gothmog on 21.09.2016.
 */
public class Author {
    private long id;
    private String surName;
    private String firstName;
    private String patronymic;
    private String fullName;
    private Date birthDay;

    public Author() {
    }

    public Author(String fullName, Date birthDay) {
        this.fullName = fullName;
        this.birthDay = birthDay;
    }

    public Author(String surName, String firstName, String patronymic, String fullName, Date birthDay) {
        this.surName = surName;
        this.firstName = firstName;
        this.patronymic = patronymic;
        this.fullName = fullName;
        this.birthDay = birthDay;
    }

    public Author(long id, String surName, String firstName, String patronymic, String fullName, Date birthDay) {
        this.id = id;
        this.surName = surName;
        this.firstName = firstName;
        this.patronymic = patronymic;
        this.fullName = surName + " " + firstName + " " + patronymic;
        this.birthDay = birthDay;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getFullName() {
        return fullName = surName + " " + firstName + " " + patronymic;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }
}
