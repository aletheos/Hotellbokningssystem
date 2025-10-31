package app;

import dao.CustomerDAO;
import dao.CustomerDAOImpl;
import db.Database;
import model.Customer;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        try  (Connection conn = Database.getConnection()) {
            Hotel.getInstance().run();
        } catch (SQLException e) {
            System.out.println("Error connectin to Database: " + e.getMessage());
            throw new RuntimeException(e);
        }
        System.out.println("Done");
    }
}
