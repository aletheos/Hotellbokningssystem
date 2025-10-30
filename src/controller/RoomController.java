package controller;

import model.Room;
import service.RoomService;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.Scanner;

public class RoomController {
    RoomService service = new RoomService();
    Scanner sc = new Scanner(System.in);

    public void runMenu (){
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
                case 1 -> addRoom();
                case 2 -> getAllRooms();
                case 3 -> getAvailableRooms();
                case 4 -> updateRoomPrice();
                case 5 -> updateRoomType();
                case 0 -> {
                    return;
                }
            }
        }
    }


    private void addRoom(){
        System.out.println("Name: ");
        String name = sc.nextLine();
        System.out.println("Room type: ");
        String type= sc.nextLine();
        System.out.println("Price: ");
        BigDecimal price = sc.nextBigDecimal();

        service.addRoom(name, type, price);
    }
    private void getAllRooms(){
        for (Room r: service.getAllRooms()){
            System.out.println(r);
        }
    }

    private void getAvailableRooms(){
        for (Room r: service.getAvailableRooms()){
            System.out.println(r);
        }
    }

    private void updateRoomPrice (){
        System.out.println("Enter room id: ");
        int id = sc.nextInt();
        Optional<Room> result = service.updateRoomPrice(id);

        result.ifPresent(r-> System.out.println("updated: " + r));
        if ( result.isEmpty()){
            System.out.println("No room with this id " + id + " was found. ");
        }
    }

    private void updateRoomType(){
        System.out.println("Enter room id: ");
        int id = sc.nextInt();
        Optional<Room> result = service.updateRoomType(id);

        result.ifPresent(r -> System.out.println("Updated: " + id));
        if(result.isEmpty()){
            System.out.println("No room with the id: " + id + " is found. ");
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
