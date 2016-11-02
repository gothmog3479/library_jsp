package ru.gothmog.web.library.dao.impl;

import org.apache.log4j.Logger;
import ru.gothmog.web.library.beans.Author;
import ru.gothmog.web.library.dao.settings.ImplDaoSettings;
import ru.gothmog.web.library.dao.EntityDao;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by gothmog on 21.09.2016.
 */
public class AuthorDaoImpl implements EntityDao<Author> {
    private final static Logger log = Logger.getLogger(AuthorDaoImpl.class);
    private ImplDaoSettings daoSettings = new ImplDaoSettings();
    private List<Author> authorList = new ArrayList<>();

    @Override
    public boolean create(Author author) {
        log.info("Create new author");
        boolean result = false;
        String sql = "INSERT INTO library.author(surname, firstname, patronymic, fullname, birthday)"
                + " VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = daoSettings.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, author.getSurName());
            statement.setString(2, author.getFirstName());
            statement.setString(3, author.getPatronymic());
            statement.setString(4, author.getFullName());
            statement.setDate(5, author.getBirthDay());

            int rowsInsert = statement.executeUpdate();
            if (rowsInsert > 0) {
                log.info("A new author was created successfully!");
                result = true;
            }
        } catch (SQLException | IOException ex) {
            log.error("Error when creating and input new author", ex);
        }

        return result;
    }


    public boolean update(long id, String surName, String firstName, String patronymic, String fullName, Date birthDay) {
        log.info("Update author");
        boolean result = false;
        String sql = "UPDATE library.author SET surname = ?, firstname = ?,  patronymic = ?," +
                "  fullname = ? , birthday = ? WHERE library.author.id = ?";


        try (Connection connection = daoSettings.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, surName);
            statement.setString(2, firstName);
            statement.setString(3, patronymic);
            statement.setString(4, fullName);
            statement.setDate(5, birthDay);

            int rowsUpdate = statement.executeUpdate();
            if (rowsUpdate > 0) {
                log.info("An existing author was updated successfully!");
                result = true;
            }
        } catch (SQLException | IOException ex) {
            log.error("Error when update and input author data", ex);
        }
        return result;
    }

    @Override
    public void delete(long id) {
        log.info("Delete author");
        String sql = "DELETE FROM library.author WHERE library.author.id = ?";


        try (Connection connection = daoSettings.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setLong(1, id);

            int rowsDelete = statement.executeUpdate();
            if (rowsDelete > 0) {
                log.info("A user was deleted successfully!");
            }
        } catch (SQLException | IOException ex) {
            log.error("Error delete and input author", ex);
        }
    }

    @Override
    public Author read(long id) {
        log.info("Read author");
        Author author = new Author();
        String sql = "SELECT * FROM  library.author WHERE library.author.id = ?";


        try (Connection connection = daoSettings.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            author.setId(resultSet.getLong("id"));
            author.setSurName(resultSet.getString("surName"));
            author.setFirstName(resultSet.getString("firstName"));
            author.setPatronymic(resultSet.getString("patronymic"));
            author.setFullName(resultSet.getString("fullName"));
            author.setBirthDay(resultSet.getDate("birthDay"));
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException | IOException ex) {
            log.error("Error when reading and input author's data", ex);
        }
        return author;
    }

    @Override
    public List<Author> getAll() {
        log.info("Get all authors");
        List<Author> list = new ArrayList<>();
        String sql = "SELECT fullname, birthday FROM library.author ORDER BY fullname";


        try (Connection connection = daoSettings.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Author author = new Author();
                author.setFullName(resultSet.getString("fullName"));
                author.setBirthDay(resultSet.getDate("birthDay"));
                list.add(author);
            }
        } catch (SQLException | IOException ex) {
            log.error("Error when getting and input all users", ex);
        }
        return list;
    }

    public List<Author> getAuthorList() {
        if (!authorList.isEmpty()) {
            return authorList;
        } else {
            return getAll();
        }
    }
}
