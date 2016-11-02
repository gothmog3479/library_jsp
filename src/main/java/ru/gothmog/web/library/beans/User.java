package ru.gothmog.web.library.beans;

import java.sql.Date;

/**
 * Created by gothmog on 21.09.2016.
 */
public class User {
    private long id;
    private Role role;
    private String loginName;
    private String password;
    private Date createDate;
    private Date lastEditedDate;
    private User createUser;
    private User lastEditedUser;
    private String surName;
    private String firstName;
    private String patronymic;
    private String fullName;
    private String email;
    private String phone;

//    public User(){
//    }

    public User(Builder builder){
        id = builder.id;
        role = builder.role;
        loginName = builder.loginName;
        password = builder.password;
        createDate = builder.createDate;
        lastEditedDate = builder.lastEditedDate;
        createUser = builder.createUser;
        lastEditedUser = builder.lastEditedUser;
        surName = builder.surName;
        firstName = builder.firstName;
        patronymic = builder.patronymic;
        fullName = builder.fullName;
        email = builder.email;
        phone = builder.phone;
    }


    public static class Builder{
        //Required parameters
        private final String loginName;
        private final String password;
        private final String fullName;
        private final String email;
        //Optional parameters - initialized to default values
        private long id = 0;
        private Role role = null;
        private Date createDate = null;
        private Date lastEditedDate = null;
        private User createUser = null;
        private User lastEditedUser = null;
        private String surName = null;
        private String firstName = null;
        private String patronymic = null;
        private String phone = null;

        public Builder (String loginName, String password, String fullName, String email){
            this.loginName = loginName;
            this.password = password;
            this.fullName = fullName;
            this.email = email;
        }
        public Builder id(long value) {
            id = value;
            return this;
        }
        public Builder role(Role value) {
            role = value;
            return this;
        }
        public Builder createDate(Date value) {
            createDate = value;
            return this;
        }
        public Builder lastEditedDate(Date value){
            lastEditedDate = value;
            return this;
        }
        public Builder createUser(User value){
            createUser = value;
            return this;
        }
        public Builder lastEditedUser(User value){
            lastEditedUser = value;
            return this;
        }
        public Builder surName(String value){
            surName = value;
            return this;
        }
        public Builder firstName(String value){
            firstName = value;
            return this;
        }
        public Builder patronymic(String value) {
            patronymic = value;
            return this;
        }
        public Builder phone(String value){
            phone = value;
            return this;
        }
        public User build(){
            return new User(this);
        }
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getLastEditedDate() {
        return lastEditedDate;
    }

    public void setLastEditedDate(Date lastEditedDate) {
        this.lastEditedDate = lastEditedDate;
    }

    public User getCreateUser() {
        return createUser;
    }

    public void setCreateUser(User createUser) {
        this.createUser = createUser;
    }

    public User getLastEditedUser() {
        return lastEditedUser;
    }

    public void setLastEditedUser(User lastEditedUser) {
        this.lastEditedUser = lastEditedUser;
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

    public String getFullname() {
        return fullName;
    }

    public void setFullname(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
