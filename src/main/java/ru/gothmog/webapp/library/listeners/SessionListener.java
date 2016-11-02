package ru.gothmog.webapp.library.listeners;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.HashMap;

/**
 * Created by gothmog on 27.09.2016.
 */
public class SessionListener implements HttpSessionListener {
    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        HttpSession session = httpSessionEvent.getSession();
        ServletContext context = session.getServletContext();
        HashMap sessionMap = (HashMap) context.getAttribute("sessionMap");
        sessionMap.put(session.getId(), session);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        HttpSession session = httpSessionEvent.getSession();
        ServletContext context = session.getServletContext();
        HashMap sessionMap = (HashMap) context.getAttribute("sessionMap");
        sessionMap.remove(session.getId());
    }
}
