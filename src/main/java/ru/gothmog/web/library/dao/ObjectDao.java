package ru.gothmog.web.library.dao;

import java.io.IOException;
import java.util.List;

/**
 * Created by gothmog on 22.09.2016.
 */
public interface ObjectDao<E> {
    void create(E e) throws IOException;

    void update(long id, String fullName) throws IOException;

    void delete(long id) throws IOException;

    E read(long id) throws IOException;

    List<E> getAll();
}
