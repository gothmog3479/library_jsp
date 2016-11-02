package ru.gothmog.web.library.listeners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSession;
import java.util.HashMap;

/**
 * Created by gothmog on 27.09.2016.
 */
public class ContextListener implements ServletContextListener {

    private HashMap sessionMap = new HashMap<String, HttpSession>();

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        servletContextEvent.getServletContext().setAttribute("sessionMap", sessionMap);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        servletContextEvent.getServletContext().removeAttribute("sessionMap");
        sessionMap = null;
    }
}
