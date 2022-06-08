package jdbc.conf;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionProvider {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/spyur";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "davodavo";
    private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
    private volatile static DBConnectionProvider instance;
    private static Connection connection;

    private DBConnectionProvider() {
        try {
            Class.forName(DB_DRIVER);
        } catch (ClassNotFoundException e) {
            System.out.println("Driver class not found");
        }
    }

    public static DBConnectionProvider getInstance() {
        if (instance == null) {
            synchronized (DBConnectionProvider.class) {
                if (instance == null) {
                    instance = new DBConnectionProvider();
                }
            }
        }
        return instance;
    }

    public Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
