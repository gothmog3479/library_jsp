package ru.gothmog.web.library.dao.settings;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by gothmog on 21.09.2016.
 */
public interface DaoSettings {
    Connection getConnection() throws SQLException, IOException;

}
