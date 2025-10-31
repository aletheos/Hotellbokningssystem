package controller;

import dao.BookingDAOImpl;
import model.Booking;
import model.Customer;
import service.BookingService;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class BookingController {

    private final BookingService service;

    private Scanner sc = new Scanner(System.in);

    public BookingController() {
        BookingDAOImpl dao = new BookingDAOImpl();
        this.service = new BookingService(dao);
    }

    public void runMenu(){

        while(true){
            System.out.println("=== MENU ===");
            System.out.println("1. Add booking");
            System.out.println("2. Show all bookings");
            System.out.println("3. Show booking");
            System.out.println("4. Update booking");
            System.out.println("5. Delete booking");
            System.out.println("0. Return");

            int input = getAnInt();

            switch(input){
                case 1 -> addBooking();
                case 2 -> getAllBookings();
                case 3 -> getBooking();
                case 4 -> updateBooking();
                case 5 -> deleteBooking();
                case 0 -> {
                    return;
                }
            }
        }

    }

    private void addBooking(){
        System.out.println("Enter start date: ");
        LocalDate start_date = LocalDate.parse(sc.nextLine());

        System.out.println("Enter end date: ");
        LocalDate end_date = LocalDate.parse(sc.nextLine());

        System.out.println("Enter customer id: ");
        int customer_id = getAnInt();

        System.out.println("Enter room id: ");
        int room_id = getAnInt();

        service.addBooking( start_date, end_date, customer_id, room_id);
    }

    private void getAllBookings(){

        for ( Booking b : service.getAllBookings()){
            System.out.println(b);
        }
    }

    private void getBooking(){

        System.out.println("Enter booking id: ");
        int booking_id = getAnInt();

        System.out.println(service.getBooking(booking_id));
    }

    private void updateBooking(){

        System.out.println("Enter booking id: ");
        int booking_id = getAnInt();

        System.out.println("Enter start date: ");
        LocalDate start_date = LocalDate.parse(sc.nextLine());

        System.out.println("Enter end date: ");
        LocalDate end_date = LocalDate.parse(sc.nextLine());

        System.out.println("Enter customer id: ");
        int customer_id = getAnInt();

        System.out.println("Enter room id: ");
        int room_id = getAnInt();

        service.updateBooking(booking_id, start_date, end_date, customer_id, room_id);
    }
    private void deleteBooking(){

        System.out.println("Enter booking id: ");
        int booking_id = getAnInt();

        service.deleteBooking(booking_id);
    }

    private int getAnInt(){
        while(!sc.hasNextInt()){
            System.out.println("enter a number");
            sc.nextLine();
        }
        int input = sc.nextInt();
        sc.nextLine();
        return  input;
    }
}