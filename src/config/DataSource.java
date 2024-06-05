package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataSource {
    private static final String url = "jdbc:mysql://139.162.6.19:16033/db_intern";
    private static final String user = "root";
    private static final String password = "Y2hpcG11bmtAMjAyMyE";

    public static Connection createConnection() throws SQLException{
        return DriverManager.getConnection(url, user, password);
    }

}
