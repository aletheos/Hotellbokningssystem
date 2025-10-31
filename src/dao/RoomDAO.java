package dao;

import model.Room;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface RoomDAO {
    int addRoom(Room room);
    List<Room> getAllRooms();
    List<Room> getAvailableRooms(LocalDate start, LocalDate end);
    int updateRoomPrice(int roomId, BigDecimal price);
    int  updateRoomType(int roomId, Room.RoomType newType);
    Optional<Room> findById(int roomId);
}
