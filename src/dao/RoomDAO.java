package dao;

import db.Database;
import model.Room;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;

public interface RoomDAO {
    void addRoom(Room.RoomType type, BigDecimal price);
    List<Room> getAllRooms();
    Optional<Room> getAvailableRooms();
    void updateRoomPrice(int id, BigDecimal price);
}
