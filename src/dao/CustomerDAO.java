package dao;

import model.Customer;
import java.util.List;

public interface CustomerDAO {
    void addCustomer(Customer customer);
    List<Customer> getAllCustomers();
    Customer findCustomerByEmail(String email);
    int updateCustomerCity(int id, String city);
    int deleteCustomer(int id);
}
