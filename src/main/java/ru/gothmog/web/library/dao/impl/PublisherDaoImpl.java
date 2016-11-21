package ru.gothmog.web.library.dao.impl;

import org.apache.log4j.Logger;
import ru.gothmog.web.library.model.Publisher;
import ru.gothmog.web.library.dao.IObjectDao;
import ru.gothmog.web.library.dao.settings.ImplDaoSettings;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Класс для работы с таблицей publisher
 * группа методов CRUD(создание, чтение, обновление, удаление названия издательства)
 * Created by gothmog on 22.09.2016.
 */
public class PublisherDaoImpl implements IObjectDao<Publisher> {
    private static final Logger log = Logger.getLogger(PublisherDaoImpl.class);
    private ImplDaoSettings daoSettings = new ImplDaoSettings();
    private List<Publisher> publisherList = new ArrayList<>();

    @Override
    /**
     * Метод позволяет создать название издательства в таблице publisher
     * */
    public void create(Publisher publisher) {
        log.info("Create new publisher");
        String sql = "INSERT INTO library.publisher(fullname) VALUES (?)";
        try (Connection connection = daoSettings.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, publisher.getFullName());

            int rowsInsert = statement.executeUpdate();
            if (rowsInsert > 0) {
                log.info("A new publisher was created successfully!");
            }
        } catch (SQLException | IOException ex) {
            log.error("Error when creating and input new publisher", ex);
        }
    }

    @Override
    /**
     * Метод позволяет обновить имеющийся издательства либо заменить название на другое в таблице publisher
     * */
    public void update(long id, String fullName) {
        log.info("Update publisher");
        String sql = "UPDATE library.publisher SET fullname = ? WHERE id = ?";
        try (Connection connection = daoSettings.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, fullName);
            statement.setLong(2, id);

            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                log.info("An existing publisher was updated successfully!");
            }
        } catch (SQLException | IOException ex) {
            log.error("Error when update and input publisher", ex);
        }
    }

    @Override
    /**
     * Метод позволяет удалить издательство из таблицы publisher
     * */
    public void delete(long id) {
        log.info("Delete publisher");
        String sql = "DELETE FROM library.publisher WHERE id = ?";
        try (Connection connection = daoSettings.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setLong(1, id);

            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                log.info("A publisher was deleted successfully!");
            }
        } catch (SQLException | IOException ex) {
            log.error("Error when delete and input publisher", ex);
        }
    }

    @Override
    /**
     * Метод позволяет прочесть требуемое издательство из таблицы publisher
     * */
    public Publisher read(long id) {
        log.info("Read publisher");
        String sql = "SELECT * FROM library.publisher WHERE id = ?";
        Publisher publisher = new Publisher();
        try (Connection connection = daoSettings.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setLong(1, id);

            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            publisher.setId(resultSet.getLong("id"));
            publisher.setFullName(resultSet.getString("fullName"));
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException | IOException ex) {
            log.error("Error when reading and input publisher data", ex);
        }
        return publisher;
    }

    @Override
    /**
     * Метод выводит полный список издательств
     * */
    public List<Publisher> getAll() {
        log.info("Get all publisher");
        List<Publisher> list = new ArrayList<>();
        String sql = "SELECT * FROM library.publisher ORDER BY library.publisher.fullname";
        try (Connection connection = daoSettings.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Publisher publisher = new Publisher();
                publisher.setId(resultSet.getLong("id"));
                publisher.setFullName(resultSet.getString("fullName"));
                list.add(publisher);
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException | IOException ex) {
            log.error("Error when getting and input all publisher publisher's", ex);
        }
        return list;
    }

    public List<Publisher> getPublisherList() {
        if (!publisherList.isEmpty()) {
            return publisherList;
        } else {
            return getAll();
        }

    }
}
