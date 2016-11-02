package ru.gothmog.webapp.library.dao;

import java.util.List;

/**
 * Created by gothmog on 22.09.2016.
 */
public interface EntityDao<E> {
    boolean create(E e);

    void delete(long id);

    E read(long id);

    List<E> getAll();
}
