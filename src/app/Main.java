package app;

import dao.CustomerDAO;
import dao.CustomerDAOImpl;
import db.Database;
import model.Customer;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        // TEST-CODE! DELETE FROM HERE
        CustomerDAO dao = new CustomerDAOImpl();
        String email = "Boll@kråkfötter.nu";
        Customer customer = new Customer(100, "Grodan Boll", email, "Övik");
        dao.addCustomer(customer);
        customer = dao.findCustomerByEmail(email);
        dao.updateCustomerCity(customer.getCustomerId(), "Örnsköldsvik");
        System.out.println();
        System.out.println(dao.getAllCustomers());
        dao.deleteCustomer(customer.getCustomerId());
        customer = dao.findCustomerByEmail(email);
        System.out.println(customer);
        System.out.println();
        System.out.println(dao.getAllCustomers());
        // TEST-CODE! DELETE TO HERE

        try  (Connection conn = Database.getConnection()) {
            Hotel.getInstance().run();
        } catch (SQLException e) {
            throw new RuntimeException(e);
            System.out.println("Error connectin to Database: " + e.getMessage());
        }
        System.out.println("Done");
    }
}
