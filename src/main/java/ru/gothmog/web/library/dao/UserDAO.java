package ru.gothmog.web.library.dao;

import ru.gothmog.web.library.model.User;

import java.util.List;

public interface UserDAO {

    void addUser(User user);

    void updateUser(User user);

    void deleteUser(User user);

    List<User> getAllUsers();

    User getuserById(long id);
}
