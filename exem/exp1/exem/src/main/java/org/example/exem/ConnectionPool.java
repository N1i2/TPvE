package org.example.exem;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionPool {
    private Connection connect = null;

    public Connection GetConnect() {
        if (connect == null) {
            String connectionString = "jdbc:sqlserver://localhost:1434;database=EXP1;encrypt=true;trustServerCertificate=true;";
            try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").getDeclaredConstructor().newInstance();
                connect = DriverManager.getConnection(connectionString, "niko", "hello");
            } catch (ClassNotFoundException | SQLException e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e);
            } catch (InstantiationException e) {
                throw new RuntimeException(e);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (NoSuchMethodException e) {
                throw new RuntimeException(e);
            }
        }
        return connect;
    }
}