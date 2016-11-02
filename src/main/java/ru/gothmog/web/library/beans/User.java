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

    public User() {
    }

    public User(Role role, String loginName, String password, Date lastEditedDate, User lastEditedUser, String fullName) {
        this.role = role;
        this.loginName = loginName;
        this.password = password;
        this.lastEditedDate = lastEditedDate;
        this.lastEditedUser = lastEditedUser;
        this.fullName = fullName;
    }

    public User(long id, Role role, String loginName, String password, Date createDate, User createUser, String fullName) {
        this.id = id;
        this.role = role;
        this.loginName = loginName;
        this.password = password;
        this.createDate = createDate;
        this.createUser = createUser;
        this.fullName = fullName;
    }

    public User(String loginName, String password, Date createDate, String fullName, String email, String phone) {
        this.loginName = loginName;
        this.password = password;
        this.createDate = createDate;
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
    }

    public User(Role role, String loginName, String password, Date createDate, User createUser, String surName, String firstName, String patronymic, String fullName) {
        this.role = role;
        this.loginName = loginName;
        this.password = password;
        this.createDate = createDate;
        this.createUser = createUser;
        this.surName = surName;
        this.firstName = firstName;
        this.patronymic = patronymic;
        this.fullName = fullName;
    }

    public User(long id, Role role, String loginName, String password, Date createDate, Date lastEditedDate, User createUser, User lastEditedUser, String surName, String firstName, String patronymic, String fullName, String email, String phone) {
        this.id = id;
        this.role = role;
        this.loginName = loginName;
        this.password = password;
        this.createDate = createDate;
        this.lastEditedDate = lastEditedDate;
        this.createUser = createUser;
        this.lastEditedUser = lastEditedUser;
        this.surName = surName;
        this.firstName = firstName;
        this.patronymic = patronymic;
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
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
