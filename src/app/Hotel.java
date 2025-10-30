package app;

import controller.BookingController;
import controller.CustomerController;
import controller.RoomController;
import dao.*;
import db.Database;
import service.BookingService;
import service.CustomerService;
import service.RoomService;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class Hotel {
    // Singleton
    private static final Hotel Instance = new Hotel();
    public static Hotel getInstance() {return Instance;}
    private Hotel() {}

    private final CustomerController customerController = new CustomerController();
    private final RoomController     roomController     = new RoomController();
    private final BookingController  bookingController  = new BookingController();

    public void run() {
        try (Scanner input = new Scanner(System.in)) {
            boolean running = true;
            while (running) {
                mainMenu();
                String choice = input.nextLine();
                switch (choice) {
                    case "1" -> customerController.runMenu();
                    case "2" -> roomController.runMenu();
                    case "3" -> bookingController.runMenu();
                    case "4" -> {
                        System.out.println("Exiting...");
                        running = false;
                    }
                    default -> System.out.println("Invalid choice");
                    }
                }
            }
        }

    private void mainMenu() {
        System.out.println("Welcome to the Hotel");
        System.out.println("1. Customer menu");
        System.out.println("2. Room menu");
        System.out.println("3. Booking menu");
        System.out.println("4. Exit");
        System.out.println("Please select an option:");
    }
}
