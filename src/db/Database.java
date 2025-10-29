package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {

    private static final String URL_ROOT = "jdbc:mysql://localhost:3306/";

    private static final String USER = "root";

    private static final String PASSWORD = System.getenv("MYSQL_PASSWORD");

    private static final String DB_NAME= "hoteldb";

    static {
        try(
                Connection conn = DriverManager.getConnection(URL_ROOT, USER, PASSWORD);
                Statement statement = conn.createStatement()){
            statement.executeUpdate("CREATE DATABASE IF NOT EXISTS " + DB_NAME);
            System.out.println("databas "+DB_NAME+ " redo");

        } catch (SQLException e){
            System.out.println("kunde inte skapa databas:" + e.getMessage());
        }
    }

    public static Connection getConnection() throws SQLException {
        String url_db = URL_ROOT+DB_NAME;
        return DriverManager.getConnection(url_db,USER,PASSWORD);
    }
}
