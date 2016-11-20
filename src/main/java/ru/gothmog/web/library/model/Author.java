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

    public Author(BuilderAuthor builderAuthor) {
        id = builderAuthor.id;
        surName = builderAuthor.surName;
        firstName = builderAuthor.firstName;
        patronymic = builderAuthor.patronymic;
        fullName = builderAuthor.fullName;
        birthDay = builderAuthor.birthDay;
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

    public static class BuilderAuthor {
        //Required parameters
        private String fullName;
        private Date birthDay;
        //Optional parameters - initialized to default values
        private long id = 0;
        private String surName = null;
        private String firstName = null;
        private String patronymic = null;

        public BuilderAuthor(String fullName, Date birthDay) {
            this.fullName = fullName;
            this.birthDay = birthDay;
        }

        public BuilderAuthor id(long value) {
            id = value;
            return this;
        }

        public BuilderAuthor surName(String value) {
            surName = value;
            return this;
        }

        public BuilderAuthor firstName(String value) {
            firstName = value;
            return this;
        }

        public BuilderAuthor patronymic(String value) {
            patronymic = value;
            return this;
        }

        public Author build() {
            return new Author(this);
        }
    }
}
