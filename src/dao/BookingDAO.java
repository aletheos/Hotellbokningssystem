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

    public void addBooking(Booking booking);

    public List<Booking> getAllBookings();

    public Booking getBooking( int booking_id);

    public int updateBooking( Booking booking);

    public int deleteBooking(int booking_id);
}