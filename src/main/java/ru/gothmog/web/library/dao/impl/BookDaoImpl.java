package ru.gothmog.web.library.dao.impl;

import org.apache.log4j.Logger;
import ru.gothmog.web.library.beans.*;
import ru.gothmog.web.library.dao.EntityDao;
import ru.gothmog.web.library.dao.settings.ImplDaoSettings;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by gothmog on 23.09.2016.
 */
public class BookDaoImpl implements EntityDao<Book> {
    private static final Logger log = Logger.getLogger(BookDaoImpl.class);
    private ImplDaoSettings daoSettings = new ImplDaoSettings();
    private List<Book> bookList = new ArrayList<>();

    @Override
    public boolean create(Book book) {
        log.info("Create new book");
        boolean result = false;
        String sql = "INSERT INTO library.book" +
                "(bookname, content, pagecount, " +
                "isbn, authorid, genreid, publisherid, " +
                "publisherdate, image, description, createdate, " +
                "lastediteddate, createuserlb, lastediteduserlb)" + "VALUES  " +
                "( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = daoSettings.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, book.getBookName());
            statement.setBytes(2, book.getContent());
            statement.setInt(3, book.getPageCount());
            statement.setString(4, book.getIsbn());
            statement.setObject(5, book.getAuthor());
            statement.setObject(6, book.getGenre());
            statement.setObject(7, book.getPublisher());
            statement.setDate(8, book.getPublishDate());
            statement.setBytes(9, book.getImage());
            statement.setString(10, book.getDescription());
            statement.setDate(11, book.getCreateDate());
            statement.setDate(12, book.getLastEditedDate());
            statement.setObject(13, book.getCreateUserBook());
            statement.setObject(14, book.getLastEditedUserBook());

            int rowsInsert = statement.executeUpdate();
            if (rowsInsert > 0) {
                log.info("A new book was created successfully!");
                result = true;
            }
        } catch (SQLException | IOException ex) {
            log.error("Error when creating and input new book", ex);
        }
        return result;
    }

    public boolean update(long id, String bookName, byte[] content, int pageCount,
                          String isbn, Author author, Genre genre, Publisher publisher,
                          Date publishDate, byte[] image, String description, Date createDate,
                          Date lastEditedDate, User createUserBook, User lastEditedUserBook) {
        log.info("update book");
        boolean result = false;
        String sql = "UPDATE library.book SET bookname = ?, content = ?, pagecount = ?, isbn = ?, authorid = ?, genreid = ?, publisherid = ?," +
                " publisherdate = ?, image = ?, description = ?, createdate = ?, lastediteddate = ?, createuserlb = ?, lastediteduserlb = ?" +
                " WHERE id = ?";
        try (Connection connection = daoSettings.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setLong(1, id);
            statement.setString(2, bookName);
            statement.setBytes(3, content);
            statement.setInt(4, pageCount);
            statement.setString(5, isbn);
            statement.setObject(6, author);
            statement.setObject(7, genre);
            statement.setObject(8, publisher);
            statement.setDate(9, publishDate);
            statement.setBytes(10, image);
            statement.setString(11, description);
            statement.setDate(12, createDate);
            statement.setDate(13, lastEditedDate);
            statement.setObject(14, createUserBook);
            statement.setObject(15, lastEditedUserBook);

            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                log.info("An existing book was updated successfully!");
                result = true;
            }
        } catch (SQLException | IOException ex) {
            log.error("Error when update and input book data", ex);
        }
        return result;
    }
    @Override
    public void delete(long id) {

    }
    @Override
    public Book read(long id) {
        return null;
    }

    @Override
    public List<Book> getAll() {
        return null;
    }

    public List<Book> getBookList() {
        if (!bookList.isEmpty()) {
            return bookList;
        } else {
            return getAll();
        }
    }
}
