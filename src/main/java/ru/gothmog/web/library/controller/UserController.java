package ru.gothmog.web.library.controller;

import ru.gothmog.web.library.dao.impl.UserDaoImpl;
import ru.gothmog.web.library.model.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gothmog on 19.11.2016.
 */
public class UserController {
    private User user = new User();
    private List<User> userArrayList = new ArrayList<>();
    private UserDaoImpl userDao = new UserDaoImpl();

    public List<User> getUserArrayList() {

        userArrayList = userDao.getAll();
        return userArrayList;
    }

    public void setUserArrayList(List<User> userArrayList) {
        this.userArrayList = userArrayList;
    }

//    public String createUser(){
//        boolean createUser = userDao.create(user);
//        if (createUser){
//            HttpSession session = SessionBean.getSession();
//        }
//    }
}
