package dao;

import model.Room;

import java.util.List;

public interface RoomDAO {

    String sql = """
            CREATE TABLE IF NOT EXISTS rooms(
            room_id INTEGER AUTO_INCREMENT PRIMARY KEY,
            type ENUM('DOUBLE_ROOM', 'SINGLE_ROOM', 'FAMILY_ROOM') NOT NULL,
            price DECIMAL(10,2))
            """;
}
