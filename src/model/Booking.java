package model;

import java.util.Date;

public class Booking {
    private int booking_id;
    private Date start_date;
    private Date end_date;
    private int customer_id;
    private int room_id;

    public Booking(Date start_date, Date end_date, int customer_id, int room_id) {
        this.start_date = start_date;
        this.end_date = end_date;
        this.customer_id = customer_id;
        this.room_id = room_id;
    }

    public int getBooking_id() {
        return booking_id;
    }

    public void setBooking_id(int booking_id) {
        this.booking_id = booking_id;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public int getRoom_id() {
        return room_id;
    }

    public void setRoom_id(int room_id) {
        this.room_id = room_id;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "booking_id=" + booking_id +
                ", start_date=" + start_date +
                ", end_date=" + end_date +
                ", customer_id=" + customer_id +
                ", room_id=" + room_id +
                '}';
    }
}
