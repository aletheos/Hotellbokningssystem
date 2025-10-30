package dao;

import db.Database;
import model.Room;

import java.sql.Connection;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;

public interface RoomDAO {
    void addRoom();
    List<Room> getAllRooms();
    List<Room> getAvailableRooms();

}
