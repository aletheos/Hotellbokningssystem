package controller;


import model.Customer;
import service.CustomerService;

import java.util.Optional;
import java.util.Scanner;

public class CustomerController {

    private final CustomerService service;

    Scanner sc = new Scanner(System.in);
    public CustomerController(CustomerService service) {
        this.service = service;
    }

    public void runMenu(){

        while(true) {
            System.out.println("=== MENU ===");
            System.out.println("1. Add customer");
            System.out.println("2. Show all customers");
            System.out.println("3. Find customer (by email)");
            System.out.println("4. Change customer city (by email)");
            System.out.println("5. Delete customer (by email)");
            System.out.println("0. Return");

            int input = getAnInt();

            switch (input) {
                case 1 -> addCustomer();
                case 2 -> getAllCustomers();
                case 3 -> findCustomerByEmail();
                case 4 -> updateCustomerCity();
                case 5 -> deleteCustomer();
                case 0 -> {
                    return;
                }
            }
        }
    }

    private void addCustomer(){
        System.out.println("Name: ");
        String name = sc.nextLine();
        System.out.println("Email: ");
        String email = sc.nextLine();
        System.out.println("City: ");
        String city = sc.nextLine();


        service.addCustomer(name,email,city);
        System.out.println("Customer added successfully: " + name + ", " + email + ", " + city);
    }

    private void getAllCustomers(){
        for (Customer p: service.getAllCustomers()){
            System.out.println(p);
        }
    }

    private void findCustomerByEmail() {
        System.out.println("Find customer by writing their email :");
        String email = sc.nextLine();

        Optional<Customer> customerOptional = service.findCustomerByEmail(email);
        if (customerOptional.isPresent()){
            System.out.println("Found: " + customerOptional.get());
        } else {
            System.out.println("No customer with the email " + email + " was found.");
        }
    }

    private void deleteCustomer() {
        System.out.println("Write the email of the customer you want to delete: ");
        String email = sc.nextLine();

        if (service.deleteCustomer(email) > 0){
            System.out.println("Successfully deleted customer with email: " + email);
        } else System.out.println("No customer with the email " + email + " was found.");

    }

    private void updateCustomerCity() {
        System.out.println("Enter customer email: ");
        String email = sc.nextLine();
        System.out.println("New city:");
        String city = sc.nextLine();

        Optional<Customer> result = service.updateCustomerCity(email,city);

        result.ifPresent(p -> System.out.println("Updated: "+ p));
        if(result.isEmpty()){
            System.out.println("No customer with the email " + email + " was found.");
        }
    }



    private int getAnInt() {
        while(!sc.hasNextInt()){
            System.out.println("Write a number");
            sc.nextLine();
        }
        int input = sc.nextInt();
        sc.nextLine();
        return input;
    }



}