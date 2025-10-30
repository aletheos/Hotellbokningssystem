package dao;

import model.Customer;
import java.util.List;

public interface CustomerDAO {
    public void addCustomer(Customer customer);
    public List<Customer> getAllCustomers();
    public Customer findCustomerByEmail(String email);
    public void updateCustomerCity(Customer customer, String city);
    public void deleteCustomer(Customer customer);
}
