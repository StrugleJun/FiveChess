package com.seem.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtils {

    public static Connection getConnection() {
        try {
            Class.forName(PropertiesUtils.getProperties(Constant.JDBC_DRIVER));
            return DriverManager.getConnection(PropertiesUtils.getProperties(Constant.JDBC_URL), PropertiesUtils.getProperties(Constant.JDBC_USERNAME),PropertiesUtils.getProperties( Constant.JDBC_PASSWORD));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
