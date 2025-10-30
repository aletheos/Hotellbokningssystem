package model;

import java.math.BigDecimal;

public class Room {
    private int roomId;
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

    public Room(int roomId, RoomType type, BigDecimal price) {
        this.roomId = roomId;
        this.type = type;
        this.price = price;
    }

    public int getRoom_id() {
        return roomId;
    }

    public void setRoom_id(int room_id) {
        this.roomId = room_id;
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
                "room_id=" + roomId +
                ", type=" + type +
                ", price=" + price +
                '}';
    }
}


