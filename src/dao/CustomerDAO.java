package dao;

import model.Customer;
import java.util.List;

public interface CustomerDAO {
    void addCustomer(Customer customer);
    List<Customer> getAllCustomers();
    Customer findCustomerByEmail(String email);
    Customer findCustomerByID(int customer_id);
    Customer updateCustomerCity(int customer_id, String city);
    int deleteCustomer(int customer_id);
}
