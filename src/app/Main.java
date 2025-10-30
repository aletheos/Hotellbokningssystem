package app;

import db.Database;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {

        try  (Connection conn = Database.getConnection()) {
            Hotel.getInstance().run();
        } catch (SQLException e) {
            throw new RuntimeException(e);
            System.out.println("Error connectin to Database: " + e.getMessage());
        }
        System.out.println("Done");
    }
}
