package ru.gothmog.web.library.dao.impl;

import org.apache.log4j.Logger;
import ru.gothmog.web.library.model.Role;
import ru.gothmog.web.library.model.User;
import ru.gothmog.web.library.dao.EntityDao;
import ru.gothmog.web.library.dao.settings.ImplDaoSettings;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by gothmog on 22.09.2016.
 */
public class RoleDaoImpl implements EntityDao<Role> {
    private static final Logger log = Logger.getLogger(RoleDaoImpl.class);
    private ImplDaoSettings daoSettings = new ImplDaoSettings();
    private List<Role> roleList = new ArrayList<>();

    @Override
    public boolean create(Role role) {
        log.info("Create new role");
        boolean result = false;
        String sql = "INSERT INTO library.roles(rolename, description, createdate, lastediteddate, createuserlb, lastediteduserlb)" +
                "VALUES ( ?, ?, ?, ?, ?, ?)";
        try (Connection connection = daoSettings.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, role.getRoleName());
            statement.setString(2, role.getDescription());
            statement.setDate(3, role.getCreateDate());
            statement.setDate(4, role.getLastEditedDate());
            statement.setObject(5, role.getCreateUserRole());
            statement.setObject(6, role.getLastEditedUserRole());

            int rowsInsert = statement.executeUpdate();
            if (rowsInsert > 0) {
                log.info("A new role was created successfully!");
                result = true;
            }
        } catch (SQLException | IOException ex) {
            log.error("Error when creating and input new role");
        }
        return result;
    }

    public boolean update(long id, String roleName, String description, Date createDate, Date lastEditedDate, User createUserRole, User lastEditedUserRole) {
        log.info("Update role");
        boolean result = false;
        String sql = "UPDATE library.roles SET  rolename = ?, description = ?, createdate = ?," +
                "  lastediteddate = ?, createuserlb = ?, lastediteduserlb = ? WHERE id = ?";
        try (Connection connection = daoSettings.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setLong(1, id);
            statement.setString(2, roleName);
            statement.setString(3, description);
            statement.setDate(4, createDate);
            statement.setDate(5, lastEditedDate);
            statement.setObject(6, createUserRole);
            statement.setObject(7, lastEditedUserRole);

            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                log.info("An existing role was updated successfully!");
                result = true;
            }
        } catch (SQLException | IOException ex) {
            log.error("Error when update and input role data", ex);
        }
        return result;
    }

    @Override
    public void delete(long id) {
        log.info("Delete role");
        String sql = "DELETE  FROM library.roles WHERE id = ?";
        try (Connection connection = daoSettings.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setLong(1, id);

            int rowsDelete = statement.executeUpdate();
            if (rowsDelete > 0) {
                log.info("A role was deleted successfully!");
            }
        } catch (SQLException | IOException ex) {
            log.error("Error delete and input role", ex);
        }
    }

    @Override
    public Role read(long id) {
        log.info("Read role");
        Role role = new Role();
        String sql = "SELECT * FROM library.roles WHERE id = ?";
        try (Connection connection = daoSettings.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            role.setId(resultSet.getLong("id"));
            role.setRoleName(resultSet.getString("roleName"));
            role.setDescription(resultSet.getString("description"));
            role.setCreateDate(resultSet.getDate("createDate"));
            role.setLastEditedDate(resultSet.getDate("lastEditedDate"));
            role.setCreateUserRole((User) resultSet.getObject("createUserRole"));
            role.setLastEditedUserRole((User) resultSet.getObject("lastEditedUserRole"));
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException | IOException ex) {
            log.error("Error when reading and input role's data", ex);
        }
        return role;
    }

    @Override
    public List<Role> getAll() {
        log.info("Get all roles");
        List<Role> list = new ArrayList<>();
        String sql = " SELECT rolename, description, createdate, lastediteddate, createuserlb, lastediteduserlb " +
                "FROM library.roles ORDER BY library.roles.rolename";
        try (Connection connection = daoSettings.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Role role = new Role();
                role.setRoleName(resultSet.getString("roleName"));
                role.setDescription(resultSet.getString("description"));
                role.setCreateDate(resultSet.getDate("createDate"));
                role.setLastEditedDate(resultSet.getDate("lastEditedDate"));
                role.setCreateUserRole((User) resultSet.getObject("createUserRole"));
                role.setLastEditedUserRole((User) resultSet.getObject("lastEditedUserRole"));
                list.add(role);
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException | IOException ex) {
            log.error("Error when getting and  input all roles", ex);
        }
        return list;
    }

    public List<Role> getRoleList() {
        if (!roleList.isEmpty()) {
            return roleList;
        } else {
            return getAll();
        }
    }

}
