package ru.gothmog.web.library.dao;

import java.util.List;

public interface ITypeDAO<T> {

    void create(T type);

    void update(T type);

    void delete(T type);

    List<T> getAll();

    T getById(long id);
}
