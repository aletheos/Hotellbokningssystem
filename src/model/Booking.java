package model;

import java.time.LocalDate;
import java.util.Date;

public class Booking {
    private int bookingId;
    private LocalDate startDate;
    private LocalDate endDate;
    private int customerId;
    private int roomId;

    public Booking(LocalDate startDate, LocalDate endDate, int customerId, int roomId) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.customerId = customerId;
        this.roomId = roomId;
    }

    public Booking(int booking_id, LocalDate startDate, LocalDate endDate, int customerId, int roomId) {
        this.bookingId = booking_id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.customerId = customerId;
        this.roomId = roomId;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "booking_id=" + bookingId +
                ", start_date=" + startDate +
                ", end_date=" + endDate +
                ", customer_id=" + customerId +
                ", room_id=" + roomId +
                '}';
    }
}
