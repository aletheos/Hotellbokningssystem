package dao;

import db.Database;
import model.Customer;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAOImpl implements CustomerDAO {
    @Override
    public void addCustomer(Customer customer) {
        String sql = "INSERT INTO customers(name, email, city) VALUE(?, ?, ?)";
        try(
            Connection connection = Database.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)
        ) {
            statement.setString(1, customer.getName());
            statement.setString(2, customer.getEmail());
            statement.setString(3, customer.getCity());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Customer> getAllCustomers() {
        String sql = "SELECT * FROM customers";
        List<Customer> customers = new ArrayList<>();
        try(
            Connection connection = Database.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery()
        ){
            while (resultSet.next()) {
                int customer_id = resultSet.getInt(1);
                String customer_name = resultSet.getString(2);
                String customer_email = resultSet.getString(3);
                String customer_city = resultSet.getString(4);
                Customer customer = new Customer(
                    customer_id,
                    customer_name,
                    customer_email,
                    customer_city
                );
                customers.add(customer);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return customers;
    }

    @Override
    public Customer findCustomerByEmail(String email) {
        String sql = "SELECT * FROM customers WHERE email = ? LIMIT 1";
        Customer customer = null;
        try(
            Connection connection = Database.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)
        ) {
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                customer = new Customer(
                    resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4)
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return customer;
    }

    @Override
    public void updateCustomerCity(Customer customer, String city) {
        String sql = "UPDATE customers SET city = ? WHERE customer_id = ?";
        try(
            Connection connection = Database.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)
        ) {
            statement.setString(1, city);
            statement.setInt(2, customer.getCustomer_id());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteCustomer(Customer customer) {
        String sql = "DELETE FROM customers WHERE customer_id = ?";
        try(
            Connection connection = Database.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)
        ) {
            statement.setInt(1, customer.getCustomer_id());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
