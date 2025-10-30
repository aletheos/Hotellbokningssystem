package dao;

import db.Database;
import model.Booking;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BookingDAOImpl implements BookingDAO {

    /*
    * CRUD
    * CREATE    -> addBooking()
    * READ      -> getAllBookings()
    * READ      -> getBooking()
    * UPDATE    -> updateBooking()
    * DELETE    -> deleteBooking()
    * */
    @Override
    public void addBooking(LocalDate start_date, LocalDate end_date, int customer_id, int room_id){

        String sql = "INSERT INTO bookings(start_date, end_date, customer_id, room_id) VALUES( ?, ?, ?, ? )";

        try(Connection conn = Database.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)){

            ps.setDate(1, Date.valueOf(start_date));
            ps.setDate(2, Date.valueOf(end_date));
            ps.setInt(3, customer_id);
            ps.setInt(4, room_id);
            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Add booking failed.\n" + e.getMessage());
        }
    }

    @Override
    public List<Booking> getAllBookings(){

        List<Booking> bookings = new ArrayList<>();
        String sql = "SELECT * FROM bookings";

        try( Connection conn = Database.getConnection();
             Statement stm = conn.createStatement();
             ResultSet rs = stm.executeQuery(sql)
          ){
            while(rs.next()){
                Booking booking = new Booking(
                    rs.getDate("start_date"),
                    rs.getDate("end_date"),
                    rs.getInt("customer_id"),
                    rs.getInt("room_id")
                );

                bookings.add(booking);
            }

        } catch(SQLException e){
            System.out.println("Get all bookings failed.\n" + e.getMessage());
        }

        return bookings;
    }

    @Override
    public Booking getBooking(int booking_id) {

        String sql = "SELECT * FROM bookings WHERE booking_id = ?";
        Booking booking;

        try( Connection conn = Database.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)){

            ps.setInt(1, booking_id);
            ResultSet rs = ps.executeQuery();

            booking = new Booking(
                    rs.getDate("start_date"),
                    rs.getDate("end_date"),
                    rs.getInt("customer_id"),
                    rs.getInt("room_id")
            );

        } catch(SQLException e){
            System.out.println("Get booking with id = " + booking_id + " failed.\n" + e.getMessage());
            return null;
        }

        return booking;
    }

    @Override
    public void updateBooking( int booking_id, LocalDate start_date, LocalDate end_date, int customer_id, int room_id) {

        String sql = "INSERT INTO bookings( start_date, end_date, customer_id, room_id) VALUES( ?, ?, ?, ?) WHERE booking_id = ?";

        try ( Connection conn = Database.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)){

            ps.setDate(1, Date.valueOf(start_date));
            ps.setDate(2, Date.valueOf(end_date));
            ps.setInt( 3, customer_id);
            ps.setInt(4, room_id);
            ps.setInt(5, booking_id);
            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Update booking with id = " + booking_id +" failed.\n" + e.getMessage());
        }
    }

    @Override
    public void deleteBooking(int booking_id) {

        String sql = "DELETE FROM bookings WHERE booking_id = ?";

        try (Connection conn = Database.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setInt(1, booking_id);
            ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("Delete booking with id = " + booking_id + " faild.\n" + e.getMessage());
        }
    }

}
