package ru.gothmog.web.library.web.servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by gothmog on 18.11.2016.
 */
@WebServlet(name = "Dispatcher")
public class Dispatcher extends HttpServlet {
    protected void forward(String URL, HttpServletRequest request, HttpServletResponse response)

            throws ServletException, IOException {

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(URL);

        dispatcher.forward(request, response);

    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
