package ru.gothmog.web.library.beans;

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

    public Book(BuilderBook builderBook) {
        id = builderBook.id;
        bookName = builderBook.bookName;
        content = builderBook.content;
        pageCount = builderBook.pageCount;
        isbn = builderBook.isbn;
        author = builderBook.author;
        genre = builderBook.genre;
        publisher = builderBook.publisher;
        publishDate = builderBook.publishDate;
        image = builderBook.image;
        description = builderBook.description;
        createDate = builderBook.createDate;
        lastEditedDate = builderBook.lastEditedDate;
        createUserBook = builderBook.createUserBook;
        lastEditedUserBook = builderBook.lastEditedUserBook;
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

    public static class BuilderBook {
        //Required parameters
        private String bookName;
        private Author author;
        //Optional parameters - initialized to default values
        private long id = 0;
        private byte[] content = null;
        private int pageCount = 0;
        private String isbn = null;
        private Genre genre = null;
        private Publisher publisher = null;
        private Date publishDate = null;
        private byte[] image = null;
        private String description = null;
        private Date createDate = null;
        private Date lastEditedDate = null;
        private User createUserBook = null;
        private User lastEditedUserBook = null;

        public BuilderBook(String bookName, Author author) {
            this.bookName = bookName;
            this.author = author;
        }

        public BuilderBook id(long value) {
            id = value;
            return this;
        }

        public BuilderBook content(byte[] value) {
            content = value;
            return this;
        }

        public BuilderBook pageCount(int value) {
            pageCount = value;
            return this;
        }

        public BuilderBook isbn(String value) {
            isbn = value;
            return this;
        }

        public BuilderBook genre(Genre value) {
            genre = value;
            return this;
        }

        public BuilderBook publisher(Publisher value) {
            publisher = value;
            return this;
        }

        public BuilderBook publishDate(Date value) {
            publishDate = value;
            return this;
        }

        public BuilderBook image(byte[] value) {
            image = value;
            return this;
        }

        public BuilderBook description(String value) {
            description = value;
            return this;
        }

        public BuilderBook createDate(Date value) {
            createDate = value;
            return this;
        }

        public BuilderBook lastEditedDate(Date value) {
            lastEditedDate = value;
            return this;
        }

        public BuilderBook createUserBook(User value) {
            createUserBook = value;
            return this;
        }

        public BuilderBook lastEditedUserBook(User value) {
            lastEditedUserBook = value;
            return this;
        }

        public Book build() {
            return new Book(this);
        }
    }
}
