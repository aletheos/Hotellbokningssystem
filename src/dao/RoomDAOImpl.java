package dao;

import db.Database;
import model.Room;

import java.math.BigDecimal;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RoomDAOImpl implements RoomDAO {

    @Override
    public int addRoom(Room room){
        String sql = "INSERT INTO rooms (type, price) VALUES ( ?, ?) ";
        try(
                Connection conn = Database.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)
        ) {
                ps.setString(1, room.getType().name());
                ps.setBigDecimal(2, room.getPrice());
                return ps.executeUpdate();
            } catch(SQLException e){
                throw new RuntimeException(e);
            }
    }

    @Override
    public List<Room> getAllRooms(){
        List<Room> rooms = new ArrayList<>();
        String sql = "SELECT * FROM rooms";

        try( Connection conn = Database.getConnection();
             Statement stm = conn.createStatement();
             ResultSet rs = stm.executeQuery(sql);){
            while (rs.next()) {
                String typeStr = rs.getString("type");
                Room.RoomType type = Room.RoomType.valueOf(typeStr);
                BigDecimal price = rs.getBigDecimal("price");
                int id = rs.getInt("room_id");
                Room room = new Room(
                        id,
                        type,
                        price
                );
                rooms.add(room);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return rooms;
    }

    @Override
    public List<Room>  getAvailableRooms(LocalDate start, LocalDate end){
       List<Room> rooms = new ArrayList<>();
        String sql = """
        SELECT r.room_id, r.type, r.price
        FROM rooms r
        WHERE r.room_id NOT IN (
            SELECT b.room_id
            FROM bookings b
            WHERE NOT (b.end_date <= ? OR b.start_date >= ?)
        )
        """;

        try (Connection conn = Database.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setDate(1, Date.valueOf(start));
            ps.setDate(2, Date.valueOf(end));
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    String typeStr = rs.getString("type");
                    Room.RoomType type = Room.RoomType.valueOf(typeStr);
                    BigDecimal price = rs.getBigDecimal("price");
                    int id = rs.getInt("room_id");
                    rooms.add(new Room(id,type, price));
                }
            }
        } catch (SQLException e) {
           e.printStackTrace();
        }
        return rooms;
    }

    @Override
    public int updateRoomType(int roomId, Room.RoomType newType) {
        final String sql = "UPDATE rooms SET type = ? WHERE room_id = ?";
        try (Connection conn = Database.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, newType.name());
            ps.setInt(2, roomId);
            return ps.executeUpdate();
        } catch (SQLException e) {
           e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int updateRoomPrice(int roomId, BigDecimal price) {
        final String sql = "UPDATE rooms SET price = ? WHERE room_id = ?";
        try (Connection conn = Database.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setBigDecimal(1, price);
            ps.setInt(2, roomId);
            return ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }


    @Override
    public Optional<Room> findById(int roomId) {
        final String sql = "SELECT room_id, type, price FROM rooms WHERE room_id = ?";
        try (Connection conn = Database.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, roomId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Room.RoomType type = Room.RoomType.valueOf(rs.getString("type"));
                    BigDecimal price = rs.getBigDecimal("price");
                    return Optional.of(new Room(type, price));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }




}
