package ru.gothmog.web.library.dao.impl;

import org.apache.log4j.Logger;
import ru.gothmog.web.library.model.Genre;
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
 * Класс для работы с таблицей genre
 * группа методов CRUD(создание, чтение, обновление, удаление названия жанров)
 * Created by gothmog on 21.09.2016.
 */
public class GenreDaoImpl implements IObjectDao<Genre> {
    private static final Logger log = Logger.getLogger(GenreDaoImpl.class);
    private ImplDaoSettings daoSettings = new ImplDaoSettings();
    private List<Genre> genreList = new ArrayList<>();

    @Override
    /**
     * Метод позволяет создать название жанра в таблице genre
     * */
    public void create(Genre genre) {
        log.info("Create new genre");
        String sql = "INSERT INTO library.genre(names) VALUES (?)";


        try (Connection connection = daoSettings.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, genre.getName());

            int rowsInsert = statement.executeUpdate();
            if (rowsInsert > 0) {
                log.info("A new genre was created successfully!");
            }

        } catch (SQLException | IOException ex) {
            log.error("Error when creating and input new genre", ex);
        }
    }

    @Override
    /**
     * Метод позволяет обновить имеющийся жанр либо заменить название на другой в таблице genre
     * */
    public void update(long id, String fullName) {
        log.info("Update genre");
        String sql = "UPDATE library.genre SET names = ? WHERE id = ?";


        try (Connection connection = daoSettings.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, fullName);
            statement.setLong(2, id);

            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                log.info("An existing genre was updated successfully!");
            }
        } catch (SQLException | IOException ex) {
            log.error("Error when update and input genre", ex);
        }
    }

    @Override
    /**
     * Метод позволяет удалить жанр из таблицы genre
     * */
    public void delete(long id) {
        log.info("Delete genre");
        String sql = "DELETE FROM library.genre WHERE id = ?";


        try (Connection connection = daoSettings.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setLong(1, id);

            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                log.info("A genre was deleted successfully!");
            }
        } catch (SQLException | IOException ex) {
            log.error("Error when delete and input genre", ex);
        }
    }

    @Override
    /**
     * Метод позволяет прочесть нужный жанр из таблицы genre
     * */
    public Genre read(long id) {
        log.info("Read genre");
        String sql = "SELECT * FROM library.genre WHERE id = ?";
        Genre genre = new Genre();


        try (Connection connection = daoSettings.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setLong(1, id);

            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            genre.setId(resultSet.getLong("id"));
            genre.setName(resultSet.getString("name"));
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException | IOException ex) {
            log.error("Error when reading and input genre data", ex);
        }
        return genre;
    }

    @Override
    /**
     * Метод выводит полный список жанров
     * */
    public List<Genre> getAll() {
        log.info("Get all genre");
        List<Genre> list = new ArrayList<>();
        String sql = "SELECT * FROM library.genre ORDER BY library.genre.names";


        try (Connection connection = daoSettings.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Genre genre = new Genre();
                genre.setId(resultSet.getLong("id"));
                genre.setName(resultSet.getString("name"));
                list.add(genre);
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException | IOException ex) {
            log.error("Error when getting and input all genre genre's", ex);
        }
        return list;
    }

    public List<Genre> getGenreList() {
        if (!genreList.isEmpty()) {
            return genreList;
        } else {
            return getAll();
        }
    }
}
