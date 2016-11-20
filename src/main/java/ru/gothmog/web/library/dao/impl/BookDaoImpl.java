package ru.gothmog.web.library.dao.impl;

import org.apache.log4j.Logger;
import ru.gothmog.web.library.model.*;
import ru.gothmog.web.library.dao.EntityDao;
import ru.gothmog.web.library.dao.settings.ImplDaoSettings;
import ru.gothmog.web.library.enums.SearchType;

import java.io.IOException;
import java.sql.*;
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
        log.info("Delete book");
        String sql = "DELETE FROM library.book WHERE id = ?";
        try (Connection connection = daoSettings.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setLong(1, id);

            int rowsDelete = statement.executeUpdate();
            if (rowsDelete > 0) {
                log.info("A book was deleted successfully!");
            }
        } catch (SQLException | IOException ex) {
            log.error("Error delete and input book data", ex);
        }
    }

    @Override
    public Book read(long id) {
        log.info("Read book");
        Book book = new Book();
        String sql = "SELECT * FROM  library.book WHERE id = ?";
        try (Connection connection = daoSettings.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            book.setId(resultSet.getLong("id"));
            book.setBookName(resultSet.getString("bookName"));
            book.setContent(resultSet.getBytes("content"));
            book.setPageCount(resultSet.getInt("pageCount"));
            book.setIsbn(resultSet.getString("isbn"));
            book.setAuthor((Author) resultSet.getObject("author"));
            book.setGenre((Genre) resultSet.getObject("genre"));
            book.setPublisher((Publisher) resultSet.getObject("publisher"));
            book.setPublishDate(resultSet.getDate("publishDate"));
            book.setImage(resultSet.getBytes("image"));
            book.setDescription(resultSet.getString("description"));
            book.setCreateDate(resultSet.getDate("createDate"));
            book.setLastEditedDate(resultSet.getDate("lastEditedDate"));
            book.setCreateUserBook((User) resultSet.getObject("createUserBook"));
            book.setLastEditedUserBook((User) resultSet.getObject("lastEditedUserBook"));
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException | IOException ex) {
            log.error("Error when reading and input book's data", ex);
        }
        return book;
    }

    private List<Book> getBooks(String sql) {
        log.info("Get books ");
        try (Connection connection = daoSettings.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Book book = new Book();
                book.setId(resultSet.getLong("id"));
                book.setBookName(resultSet.getString("bookName"));
                book.setContent(resultSet.getBytes("content"));
                book.setPageCount(resultSet.getInt("pageCount"));
                book.setIsbn(resultSet.getString("isbn"));
                book.setAuthor((Author) resultSet.getObject("author"));
                book.setGenre((Genre) resultSet.getObject("genre"));
                book.setPublisher((Publisher) resultSet.getObject("publisher"));
                book.setPublishDate(resultSet.getDate("publishDate"));
                book.setImage(resultSet.getBytes("image"));
                book.setDescription(resultSet.getString("description"));
                book.setCreateDate(resultSet.getDate("createDate"));
                book.setLastEditedDate(resultSet.getDate("lastEditedDate"));
                book.setCreateUserBook((User) resultSet.getObject("createUserBook"));
                book.setLastEditedUserBook((User) resultSet.getObject("lastEditedUserBook"));
                bookList.add(book);
            }
            resultSet.close();
            statement.close();
            connection.close();

        } catch (SQLException | IOException ex) {
            log.error("Error when getting books by genre input data");
        }
        return bookList;

    }

    @Override
    public List<Book> getAll() {
        log.info("Get all books");
        String sql = "SELECT b.id,b.bookname,b.isbn,b.pagecount,b.publisherdate, p.fullname AS publisher, " +
                "a.fullname AS author, g.names AS genre, b.image FROM library.book b " +
                "INNER JOIN library.author a ON b.authorid = a.id " +
                "INNER JOIN library.genre g ON b.genreid = g.id " +
                "INNER JOIN library.publisher p ON b.publisherid = p.id ORDER BY b.bookname";
        return getBooks(sql);
    }


    public List<Book> getBooksByGenre(long id) {
        log.info("Get Books By Genre");
        String sql = "SELECT b.id,b.bookname,b.isbn,b.pagecount,b.publisherdate, p.fullname AS publisher, " +
                "a.fullname AS author, g.names AS genre, b.image FROM library.book b " +
                "INNER JOIN library.author a ON b.authorid = a.id " +
                "INNER JOIN library.genre g ON b.genreid = g.id " +
                "INNER JOIN library.publisher p ON b.publisherid = p.id " +
                "WHERE genreid = " + id + " ORDER BY b.bookname LIMIT 0 OFFSET 5";
        if (id == 0) {
            return getAll();
        } else {
            return getBooks(sql);
        }
    }

    public List<Book> getBooksByLetter(String letter) {
        log.info("Get books by letter");
        String sql = "SELECT b.id,b.bookname,b.isbn,b.pagecount,b.publisherdate, p.fullname AS publisher, " +
                "a.fullname AS author, g.names AS genre, b.image FROM library.book b " +
                "INNER JOIN library.author a ON b.authorid = a.id " +
                "INNER JOIN library.genre g ON b.genreid = g.id " +
                "INNER JOIN library.publisher p ON b.publisherid = p.id " +
                "WHERE substr(b.bookname,1,1) = '" + letter + "' order by b.bookname";
        return getBooks(sql);
    }

    public List<Book> getBooksBySearch(String searchStr, SearchType searchType) {
        log.info("Get books by search");
        StringBuilder sql = new StringBuilder("SELECT b.id,b.bookname,b.isbn,b.pagecount,b.publisherdate, p.fullname AS publisher, a.fullname AS author, g.names AS genre, b.image FROM library.book b "
                + "INNER JOIN library.author a ON b.authorid = a.id "
                + "INNER JOIN library.genre g ON b.genreid = g.id "
                + "INNER JOIN library.publisher p ON b.publisherid = p.id ");

        if (searchType == SearchType.AUTHOR) {
            sql.append("WHERE lower(a.fullname) LIKE '%" + searchStr.toLowerCase() + "%' order by b.bookname ");
        } else if (searchType == SearchType.TITLE) {
            sql.append("WHERE lower(b.bookname) LIKE '%" + searchStr.toLowerCase() + "%' order by b.bookname ");
        }
        sql.append("LIMIT 0 OFFSET 5");
        return getBooks(sql.toString());
    }

    public Book getBooksByPdfContent(){
        log.info("pdf файла загружаем в это поле только в нужный момент (для просмотра)");
        Book book = new Book();
        String sql = "SELECT library.book.content FROM library.book WHERE id =" + book.getId();
        try(Connection connection = daoSettings.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                book.setContent(resultSet.getBytes("content"));
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException | IOException ex){
            log.error("Error input data content pdf");
        }
        return book;
    }

    public List<Book> getBookList() {
        if (!bookList.isEmpty()) {
            return bookList;
        } else {
            return getAll();
        }
    }


}
