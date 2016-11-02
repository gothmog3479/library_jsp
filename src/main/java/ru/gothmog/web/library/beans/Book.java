package ru.gothmog.webapp.library.beans;

import java.sql.Date;

/**
 * Created by gothmog on 21.09.2016.
 */
public class Book {
    private long id;
    private String bookName;
    private byte[] content;
    private int pageCount;
    private String isbn;
    private Author author;
    private Genre genre;
    private Publisher publisher;
    private Date publishDate;
    private byte[] image;
    private String description;
    private Date createDate;
    private Date lastEditedDate;
    private User createUserBook;
    private User lastEditedUserBook;

    public Book() {
    }

    public Book(String bookName, byte[] content, int pageCount, String isbn, Author author, Genre genre, Publisher publisher, Date publishDate, byte[] image, String description) {
        this.bookName = bookName;
        this.content = content;
        this.pageCount = pageCount;
        this.isbn = isbn;
        this.author = author;
        this.genre = genre;
        this.publisher = publisher;
        this.publishDate = publishDate;
        this.image = image;
        this.description = description;
    }

    public Book(String bookName, byte[] content, int pageCount, String isbn, Author author, Genre genre, Publisher publisher, Date publishDate, byte[] image, String description, Date createDate, User createUserBook) {
        this.bookName = bookName;
        this.content = content;
        this.pageCount = pageCount;
        this.isbn = isbn;
        this.author = author;
        this.genre = genre;
        this.publisher = publisher;
        this.publishDate = publishDate;
        this.image = image;
        this.description = description;
        this.createDate = createDate;
        this.createUserBook = createUserBook;
    }

    public Book(long id, String bookName, byte[] content, int pageCount, String isbn, Author author, Genre genre, Publisher publisher, Date publishDate, byte[] image, String description, Date createDate, Date lastEditedDate, User createUserBook, User lastEditedUserBook) {
        this.id = id;
        this.bookName = bookName;
        this.content = content;
        this.pageCount = pageCount;
        this.isbn = isbn;
        this.author = author;
        this.genre = genre;
        this.publisher = publisher;
        this.publishDate = publishDate;
        this.image = image;
        this.description = description;
        this.createDate = createDate;
        this.lastEditedDate = lastEditedDate;
        this.createUserBook = createUserBook;
        this.lastEditedUserBook = lastEditedUserBook;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
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

    public User getCreateUserBook() {
        return createUserBook;
    }

    public void setCreateUserBook(User createUserBook) {
        this.createUserBook = createUserBook;
    }

    public User getLastEditedUserBook() {
        return lastEditedUserBook;
    }

    public void setLastEditedUserBook(User lastEditedUserBook) {
        this.lastEditedUserBook = lastEditedUserBook;
    }
}
