package org.example.DAO;

import org.example.db.dbConnector;
import org.example.model.student;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RoomDAO {

    private dbConnector dbConnector;
    private RoomDAO roomDAO;

    public String addRoom(String room_id, String hostel_id,int room_number, int capacity, int available_capacity){
        String query = "INSERT INTO students (room_id, room_number,capacity, available_capacity)VALUES (?,?,?,?)";
        try(PreparedStatement preparedStatement = org.example.db.dbConnector.getConnection().prepareStatement(query)) {

            preparedStatement.setString(1, roomDAO.getRoom_id());
            preparedStatement.setString(2, roomDAO.getHostel_id());
            preparedStatement.setInt(3, roomDAO.getRoom_number());
            preparedStatement.setString(4, roomDAO.getCapacity());
            preparedStatement.setString(5, roomDAO. getAvailable_capacity());


            int res = preparedStatement.executeUpdate(); // can use  preparedStatement.executeUpdate();

            if (res>0) {
                return "Successfully added the record of the room Id: " + id;
            } else {
                return "Registering employee is unsuccessful!";
            }
        }
        catch (SQLException e){
            return "Registering student is unsuccessful! Reason: "+ e.getMessage();
        }
    }


}
