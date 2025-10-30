package dao;

import model.Customer;
import java.util.List;

public interface CustomerDAO {
    void addCustomer(Customer customer);
    List<Customer> getAllCustomers();
    Customer findCustomerByEmail(String email);
    void updateCustomerCity(Customer customer, String city);
    void deleteCustomer(Customer customer);
}
