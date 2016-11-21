package ru.gothmog.web.library.dao;

import java.util.List;

/**
 * Created by gothmog on 22.09.2016.
 */
public interface IEntityDao<T> {
    boolean create(T type);

    void delete(long id);

    T read(long id);

    List<T> getAll();
}
