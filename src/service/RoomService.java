package service;
/*
import dao.RoomDAO;
import model.Room;
import model.Room.RoomType;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class RoomService {

    private final RoomDAO dao;

    public RoomService(RoomDAO dao) {
        this.dao = Objects.requireNonNull(dao);
    }

    public List<Room> getAllRooms() {
        return dao.getAllRooms();
    }

    public boolean addRoom(RoomType type, BigDecimal price) {
        if (type == null || !isValidPrice(price)) return false;
        int rows = dao.addRoom(new Room(type, price));
        return rows > 0;
    }

    public Optional<Room> updateRoomPrice(int roomId, BigDecimal newPrice) {
        if (roomId <= 0 || !isValidPrice(newPrice)) return Optional.empty();
        int updated = dao.updateRoomPrice(roomId, newPrice);
        return updated > 0 ? dao.findById(roomId) : Optional.empty();
    }

    public Optional<Room> updateRoomType(int roomId, RoomType newType) {
        if (roomId <= 0 || newType == null) return Optional.empty();
        int updated = dao.updateRoomType(roomId, newType);
        return updated > 0 ? dao.findById(roomId) : Optional.empty();
    }

    public List<Room> getAvailableRooms() {
        LocalDate start = LocalDate.now();
        LocalDate end = start.plusDays(1);
        return dao.getAvailableRooms(start, end); }

    private static boolean isValidPrice(BigDecimal price) {
        return price != null && price.scale() <= 2 && price.compareTo(BigDecimal.ZERO) >= 0;
    }
}
*/