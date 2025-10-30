package dao;

import db.Database;
import model.Room;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class RoomDAOImpl implements RoomDAO {
    public void addRoom (Room.RoomType type, BigDecimal price){
        String sql = "INSERT INTO rooms (type, price) VALUES ( ?, ?) ";

        try(
                Connection conn = Database.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql))
            {
                ps.setString(1, type.name());
                ps.setBigDecimal(2, price);

            } catch(SQLException e){
                e.printStackTrace();
            }
    }

    public List<Room> getAllRooms(){

    }
}
