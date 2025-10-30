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
        Customer customer = new Customer(100, "Grodan Boll", null, "Övik");
        dao.addCustomer(customer);
        dao.updateCustomerCity(customer, "Örnsköldsvik"); // den här kommer att ha fel customer_id
        dao.deleteCustomer(customer);
        customer = dao.findCustomerByEmail("aletheos@outlook.com");
        System.out.println(customer);
        System.out.println();
        System.out.println(dao.getAllCustomers());
        // TEST-CODE! DELETE TO HERE

        try {
            Connection conn = Database.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Done");
    }
}
