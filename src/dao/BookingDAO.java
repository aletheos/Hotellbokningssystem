package dao;

import model.Booking;

import java.time.LocalDate;
import java.util.List;

public interface BookingDAO {

    /*
     * CRUD:
     * CREATE    -> addBooking()
     * READ      -> getAllBookings()
     * READ      -> getBooking()
     * UPDATE    -> updateBooking()
     * DELETE    -> deleteBooking()
     * */

    public void addBooking(LocalDate start_date, LocalDate end_date, int customer_id, int room_id);

    public List<Booking> getAllBookings();

    public Booking getBooking( int booking_id);

    public void updateBooking( int booking_id, LocalDate start_date, LocalDate end_date, int customer_id, int room_id);

    public void deleteBooking(int booking_id);
}