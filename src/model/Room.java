package model;

import java.math.BigDecimal;

public class Room {
    private int room_id;
    private RoomType type;
    private BigDecimal price;

    public enum RoomType {
        DOUBLE_ROOM,
        SINGLE_ROOM,
        FAMILY_ROOM
    }

    public Room(RoomType type, BigDecimal price) {
        this.type = type;
        this.price = price;
    }

    public Room(int room_id, RoomType type, BigDecimal price) {
        this.room_id = room_id;
        this.type = type;
        this.price = price;
    }

    public int getRoom_id() {
        return room_id;
    }

    public void setRoom_id(int room_id) {
        this.room_id = room_id;
    }

    public RoomType getType() {
        return type;
    }

    public void setType(RoomType type) {
        this.type = type;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Room{" +
                "room_id=" + room_id +
                ", type=" + type +
                ", price=" + price +
                '}';
    }
}


