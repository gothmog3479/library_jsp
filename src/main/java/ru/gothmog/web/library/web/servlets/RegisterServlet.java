package ru.gothmog.web.library.web.servlets;

import org.apache.log4j.Logger;
import ru.gothmog.web.library.dao.impl.UserDaoImpl;
import ru.gothmog.web.library.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by gothmog on 18.11.2016.
 */
@WebServlet(name = "Registration", urlPatterns = {"/registration"})
public class RegisterServlet extends HttpServlet {
    private static final Logger log = Logger.getLogger(RegisterServlet.class);

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDaoImpl userDao = new UserDaoImpl();
        User user = new User.BuilderUser(request.getParameter("loginName"), request.getParameter("password"), request.getParameter("fullName"), request.getParameter("email")).build();
        if (userDao.create(user)) {
            response.sendRedirect("/");
        } else {
            request.setAttribute("error", "<font color = red>The current user is exist</font>");
            getServletContext().getRequestDispatcher("/views/registration.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
