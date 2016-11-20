package ru.gothmog.web.library.model;

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

    public Role(BuilderRole builderRole) {
        id = builderRole.id;
        roleName = builderRole.roleName;
        description = builderRole.description;
        createDate = builderRole.createDate;
        lastEditedDate = builderRole.lastEditedDate;
        createUserRole = builderRole.createUserRole;
        lastEditedUserRole = builderRole.lastEditedUserRole;
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

    public static class BuilderRole {
        //Required parameters
        private String roleName;
        private String description;
        //Optional parameters - initialized to default values
        private long id = 0;
        private Date createDate = null;
        private Date lastEditedDate = null;
        private User createUserRole = null;
        private User lastEditedUserRole = null;

        public BuilderRole(String roleName, String description) {
            this.roleName = roleName;
            this.description = description;
        }

        public BuilderRole id(long value) {
            id = value;
            return this;
        }

        public BuilderRole createDate(Date value) {
            createDate = value;
            return this;
        }

        public BuilderRole lastEditedDate(Date value) {
            lastEditedDate = value;
            return this;
        }

        public BuilderRole createUserRole(User value) {
            createUserRole = value;
            return this;
        }

        public BuilderRole lastEditedUserRole(User value) {
            lastEditedUserRole = value;
            return this;
        }

        public Role build() {
            return new Role(this);
        }
    }
}
