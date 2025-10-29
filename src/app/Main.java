package app;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {

        try {
            Connection conn = Database.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Done");
    }
}
