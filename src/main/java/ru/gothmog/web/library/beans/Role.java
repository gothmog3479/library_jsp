package ru.gothmog.web.library.beans;

import java.sql.Date;

/**
 * Created by gothmog on 21.09.2016.
 */
public class Role {
    private long id;
    private String roleName;
    private String description;
    private Date createDate;
    private Date lastEditedDate;
    private User createUserRole;
    private User lastEditedUserRole;

    public Role() {
    }

    public Role(String roleName) {
        this.roleName = roleName;
    }

    public Role(String roleName, String description) {
        this.roleName = roleName;
        this.description = description;
    }

    public Role(String roleName, String description, Date createDate, User createUserRole) {
        this.roleName = roleName;
        this.description = description;
        this.createDate = createDate;
        this.createUserRole = createUserRole;
    }

    public Role(long id, String roleName, String description, Date createDate, Date lastEditedDate, User createUserRole, User lastEditedUserRole) {
        this.id = id;
        this.roleName = roleName;
        this.description = description;
        this.createDate = createDate;
        this.lastEditedDate = lastEditedDate;
        this.createUserRole = createUserRole;
        this.lastEditedUserRole = lastEditedUserRole;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public User getCreateUserRole() {
        return createUserRole;
    }

    public void setCreateUserRole(User createUserRole) {
        this.createUserRole = createUserRole;
    }

    public User getLastEditedUserRole() {
        return lastEditedUserRole;
    }

    public void setLastEditedUserRole(User lastEditedUserRole) {
        this.lastEditedUserRole = lastEditedUserRole;
    }
}
