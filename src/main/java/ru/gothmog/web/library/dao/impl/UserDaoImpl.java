package ru.gothmog.webapp.library.dao.impl;

import org.apache.log4j.Logger;
import ru.gothmog.webapp.library.beans.Role;
import ru.gothmog.webapp.library.beans.User;
import ru.gothmog.webapp.library.dao.EntityDao;
import ru.gothmog.webapp.library.dao.settings.ImplDaoSettings;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by gothmog on 22.09.2016.
 */
public class UserDaoImpl implements EntityDao<User> {
    private static final Logger log = Logger.getLogger(UserDaoImpl.class);
    private ImplDaoSettings daoSettings = new ImplDaoSettings();
    private List<User> userList = new ArrayList<>();

    @Override
    public boolean create(User user) {
        log.info("Create new user");
        boolean result = false;
        String sql = "INSERT  INTO library.users(roleid, loginname, passwd, createdate, lastediteddate, " +
                "createuserlb, lastediteduserlb, surname, firstname, patronymic, completefullname, email, phone)" +
                " VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";


        try (Connection connection = daoSettings.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setObject(1, user.getRole());
            statement.setString(2, user.getLoginName());
            statement.setString(3, user.getPassword());
            statement.setDate(4, user.getCreateDate());
            statement.setDate(5, user.getLastEditedDate());
            statement.setObject(6, user.getCreateUser());
            statement.setObject(7, user.getLastEditedUser());
            statement.setString(8, user.getSurName());
            statement.setString(9, user.getFirstName());
            statement.setString(10, user.getPatronymic());
            statement.setString(11, user.getFullname());
            statement.setString(12, user.getEmail());
            statement.setString(13, user.getPhone());

            int rowsInsert = statement.executeUpdate();
            if (rowsInsert > 0) {
                log.info("A new user was created successfully!");
                result = true;
            }
        } catch (SQLException | IOException ex) {
            log.error("Error when creating and input new user", ex);
        }

        return result;
    }

    public boolean update(long id, Role role, String loginName, String password, Date createDate, Date lastEditedDate, User createUser, User lastEditedUser, String surName, String firstName, String patronymic, String fullName, String email, String phone) {
        log.info("Update user");
        boolean result = false;
        String sql = "UPDATE  library.users SET roleid = ?, loginname = ?, passwd = ?," +
                "  createdate = ?, lastediteddate = ?, createuserlb = ?, lastediteduserlb = ?," +
                "  surname = ?, firstname = ?, patronymic = ?, completefullname = ?, email = ?, phone = ? WHERE id = ?";


        try (Connection connection = daoSettings.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setLong(1, id);
            statement.setObject(2, role);
            statement.setString(3, loginName);
            statement.setString(4, password);
            statement.setDate(5, createDate);
            statement.setDate(6, lastEditedDate);
            statement.setObject(7, createUser);
            statement.setObject(8, lastEditedUser);
            statement.setString(9, surName);
            statement.setString(10, firstName);
            statement.setString(11, patronymic);
            statement.setString(12, fullName);
            statement.setString(13, email);
            statement.setString(14, phone);

            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                log.info("An existing user was updated successfully!");
                result = true;
            }
        } catch (SQLException | IOException ex) {
            log.error("Error when update and input user data", ex);
        }
        return result;
    }

    @Override
    public void delete(long id) {
        log.info("Delete user");
        String sql = "DELETE  FROM library.users WHERE id = ?";
        try (Connection connection = daoSettings.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setLong(1, id);

            int rowsDelete = statement.executeUpdate();
            if (rowsDelete > 0) {
                log.info("A user was deleted successfully!");
            }
        } catch (SQLException | IOException ex) {
            log.error("Error delete and input user", ex);
        }

    }

    @Override
    public User read(long id) {
        log.info("Read user");
        User user = new User();
        String sql = "SELECT * FROM library.users WHERE id = ?";
        try (Connection connection = daoSettings.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            user.setId(resultSet.getLong("id"));
            user.setRole((Role) resultSet.getObject("role"));
            user.setLoginName(resultSet.getString("loginName"));
            user.setPassword(resultSet.getString("password"));
            user.setCreateDate(resultSet.getDate("createDate"));
            user.setLastEditedDate(resultSet.getDate("lastEditedDate"));
            user.setCreateUser((User) resultSet.getObject("createUser"));
            user.setLastEditedUser((User) resultSet.getObject("lastEditedUser"));
            user.setSurName(resultSet.getString("surName"));
            user.setFirstName(resultSet.getString("firstName"));
            user.setPatronymic(resultSet.getString("patronymic"));
            user.setFullname(resultSet.getString("fullName"));
            user.setEmail(resultSet.getString("email"));
            user.setPhone(resultSet.getString("phone"));
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException | IOException ex) {
            log.error("Error when reading and input user's data", ex);
        }
        return user;
    }

    @Override
    public List<User> getAll() {
        log.info("Get all users");
        List<User> list = new ArrayList<>();
        String sql = "SELECT loginname, passwd, createdate, completefullname, email, phone " +
                "FROM library.users ORDER BY loginname";
        try (Connection connection = daoSettings.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                User user = new User();
                user.setLoginName(resultSet.getString("loginName"));
                user.setPassword(resultSet.getString("password"));
                user.setCreateDate(resultSet.getDate("createDate"));
                user.setFullname(resultSet.getString("fullName"));
                user.setEmail(resultSet.getString("email"));
                user.setPhone(resultSet.getString("phone"));
                list.add(user);
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException | IOException ex) {
            log.error("Error when getting and  input all users");
        }
        return list;
    }

    public List<User> getUserList() {
        if (!userList.isEmpty()) {
            return userList;
        } else {
            return getAll();
        }

    }

}
