package controller;

import dao.RoomDAOImpl;
import model.Room;
import service.RoomService;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class RoomController {
   private final RoomService service;

    Scanner sc = new Scanner(System.in);

    public RoomController() {
        RoomDAOImpl dao = new RoomDAOImpl();
        this.service = new RoomService(dao);
    }

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

        System.out.println("Room type: ");
        Room.RoomType type = Room.RoomType.valueOf(sc.nextLine().toUpperCase());

        System.out.println("Price: ");
        BigDecimal price = sc.nextBigDecimal();

        service.addRoom(type, price);
    }
    private List<Room> getAllRooms(){
        for (Room r: service.getAllRooms()){
            System.out.println(r);
        }
    }

    private Optional<Room> getAvailableRooms(){
        for (Room r: service.getAvailableRooms()){
            System.out.println(r);
        }
    }

    private void updateRoomPrice (){
        System.out.println("Enter room id: ");
        int id = sc.nextInt();
        System.out.println("Enter new price: ");
        BigDecimal price = sc.nextBigDecimal();

        Optional<Room> result = service.updateRoomPrice(id, price);

        result.ifPresent(r-> System.out.println("updated: " + r));
        if ( result.isEmpty()){
            System.out.println("No room with this id " + id + " was found. ");
        }
    }

    private void updateRoomType(){
        System.out.println("Enter room id: ");
        int id = sc.nextInt();
        System.out.println("Enter new type: ");
        Room.RoomType type = Room.RoomType.valueOf(sc.nextLine().toUpperCase());
        Optional<Room> result = service.updateRoomType(id, type );

        result.ifPresent(r -> System.out.println("Updated: " + r));
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
