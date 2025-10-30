package service;

import dao.CustomerDAO;
import model.Customer;

import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.regex.Pattern;

public class CustomerService {

    private static final Pattern SIMPLE_EMAIL =
            Pattern.compile("^[^@\\s]+@[^@\\s]+\\.[^@\\s]+$");

    private final CustomerDAO dao;

    public CustomerService(CustomerDAO dao) {
        this.dao = dao;
    }

    public List<Customer> getAllCustomers() {
        return dao.getAllCustomers();
    }

    public Optional<Customer> findCustomerByEmail(String email) {
        if (email == null || email.isBlank()) return Optional.empty();
        String norm = normalizeEmail(email);
        return Optional.ofNullable(dao.findCustomerByEmail(norm));
    }

    public void addCustomer(String name, String email, String city) {
        if (name == null || name.isBlank()) {
            System.out.println("Name cannot be empty");
            return;
        }
        if (city == null || city.isBlank()) {
            System.out.println("City cannot be empty");
            return;
        }
        if (!isValidEmail(email)) {
            System.out.println("Email is not valid");
            return;
        }
        String normEmail = normalizeEmail(email);
        if (dao.findCustomerByEmail(normEmail) != null) {
            System.out.println("Customer with this email already exists");
            return;
        }

        dao.addCustomer(new Customer(name.trim(), normEmail, city.trim()));
    }

    public int deleteCustomer(String email) {
        if (!isValidEmail(email)) return 0;
        String norm = normalizeEmail(email);
        return dao.deleteCustomer(norm);
    }

    public Optional<Customer> updateCustomerCity(String email, String city) {
        if (!isValidEmail(email) || city == null || city.isBlank()) {
            return Optional.empty();
        }
        String norm = normalizeEmail(email);
        int updated = dao.updateCustomerCity(norm, city.trim());
        if (updated > 0) {
            return Optional.ofNullable(dao.findCustomerByEmail(norm));
        }
        return Optional.empty();
    }

    private static boolean isValidEmail(String email) {
        if (email == null) return false;
        String s = email.trim();
        return !s.isEmpty() && SIMPLE_EMAIL.matcher(s).matches();
    }

    private static String normalizeEmail(String email) {
        return email.trim().toLowerCase(Locale.ROOT);
    }
}
