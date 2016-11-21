package ru.gothmog.web.library.dao;

import java.io.IOException;
import java.util.List;

/**
 * Created by gothmog on 22.09.2016.
 */
public interface IObjectDao<T> {
    void create(T type) throws IOException;

    void update(long id, String fullName) throws IOException;

    void delete(long id) throws IOException;

    T read(long id) throws IOException;

    List<T> getAll();
}
