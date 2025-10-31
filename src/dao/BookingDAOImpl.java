package dao;

import db.Database;
import model.Booking;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BookingDAOImpl implements BookingDAO {

    @Override
    public void addBooking(Booking booking){

        String sql = "INSERT INTO bookings(start_date, end_date, customer_id, room_id) VALUES( ?, ?, ?, ? )";

        try(Connection conn = Database.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)){

            ps.setDate(1, Date.valueOf(booking.getStartDate()));
            ps.setDate(2, Date.valueOf(booking.getEndDate()));
            ps.setInt(3, booking.getCustomerId());
            ps.setInt(4, booking.getRoomId());
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
                int id = rs.getInt("booking_id");
                Booking booking = new Booking(
                        id,
                        rs.getDate("start_date").toLocalDate(),
                        rs.getDate("end_date").toLocalDate(),
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
        Booking booking = null;

        try( Connection conn = Database.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)){

            ps.setInt(1, booking_id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                booking = new Booking(
                        rs.getInt("booking_id"),
                        rs.getDate("start_date").toLocalDate(),
                        rs.getDate("end_date").toLocalDate(),
                        rs.getInt("customer_id"),
                        rs.getInt("room_id")
                );
            }

        } catch(SQLException e){
            System.out.println("Get booking with id = " + booking_id + " failed.\n" + e.getMessage());
        }

        return booking;
    }

    @Override
    public int updateBooking( Booking booking) {

        String sql = "INSERT INTO bookings( start_date, end_date, customer_id, room_id) VALUES( ?, ?, ?, ?) WHERE booking_id = ?";

        try ( Connection conn = Database.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)){

            ps.setDate(1, Date.valueOf( booking.getStartDate()));
            ps.setDate(2, Date.valueOf( booking.getEndDate()));
            ps.setInt( 3, booking.getCustomerId());
            ps.setInt(4, booking.getRoomId());
            ps.setInt(5, booking.getBookingId());
            return ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Update booking with id = " + booking.getBookingId() +" failed.\n" + e.getMessage());
        }
        return 0;
    }

    @Override
    public int deleteBooking(int booking_id) {

        String sql = "DELETE FROM bookings WHERE booking_id = ?";
        int response = -1;

        try (Connection conn = Database.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setInt(1, booking_id);
            response = ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("Delete booking with id = " + booking_id + " faild.\n" + e.getMessage());
        }
        return response;
    }
}
