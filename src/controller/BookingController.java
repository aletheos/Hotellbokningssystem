package controller;

import dao.BookingDAOImpl;
import service.BookingService;

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
            System.out.println("1. Add room");
            System.out.println("2. Show all rooms");
            System.out.println("3. Show only available room");
            System.out.println("4. Update room's price");
            System.out.println("5. Update room's type");
            System.out.println("6. Return");

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