package service;

import dao.BookingDAO;
import dao.BookingDAOImpl;
import model.Booking;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class BookingService {

    private final BookingDAO dao;

    public BookingService(BookingDAO dao) {
        this.dao = dao;
    }

    public void addBooking(LocalDate start_date, LocalDate end_date, int customer_id, int room_id){

        if (start_date == null || end_date == null){
            System.out.println("Datum kan inte vara tomt när man skapar en bokning.");
            return;
        }

        if (customer_id <= 0){
            System.out.println("Ogiltigt kund-id. Kan inte skapa en ny bokning.");
            return;
        }

        if (room_id <= 0){
            System.out.println("Ogiltigt rums-id. Kan inte skapa en ny bokning.");
            return;
        }
        dao.addBooking( new Booking( start_date, end_date, customer_id, room_id));
    }

    public List<Booking> getAllBookings(){

        return dao.getAllBookings();
    }

    public Booking getBooking(int booking_id){

        return dao.getBooking(booking_id);
    }

    public Optional<Booking> updateBooking(int booking_id, LocalDate start_date, LocalDate end_date, int customer_id, int room_id){

        Booking booking =  new Booking(booking_id, start_date, end_date, customer_id, room_id);

        if (dao.updateBooking(booking) > 0) {
            return Optional.of(booking);
        } else {
            System.out.println("Uppdatering av bokning (" + booking_id +") kunde inte genomföras.");
            return Optional.empty();
        }
    }

    public int deleteBooking(int booking_id){

        if ( booking_id <= 0 ){
            System.out.println("Ogiltigt boknings-id. Kan inte radera bokningen.");
            return -1;
        }
        return dao.deleteBooking(booking_id);
    }
}
