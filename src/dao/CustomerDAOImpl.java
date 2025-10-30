package dao;

import db.Database;
import model.Customer;
import java.sql.*;
import java.util.List;

public class CustomerDAOImpl implements CustomerDAO {
    @Override
    public void addCustomer(Customer customer) {
        String sql = "INSERT INTO customers(name, email, city) VALUE(?, ?, ?)";
        try(
            Connection connection = Database.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
        ) {
            statement.setString(1, customer.getName());
            statement.setString(2, customer.getEmail());
            statement.setString(3, customer.getCity());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Customer> getAllCustomers() {
        return List.of();
    }

    @Override
    public Customer findCustomerByEmail(String email) {
        return null;
    }

    @Override
    public void updateCustomerCity(Customer customer, String city) {

    }

    @Override
    public void deleteCustomer(Customer customer) {

    }
}
