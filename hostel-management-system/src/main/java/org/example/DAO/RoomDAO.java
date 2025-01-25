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
    public String viewRoom(String room_id, dbConnector conn){
        String sql = "SELECT * FROM students WHERE room_id = ?;";
        StringBuilder result = new StringBuilder();
        try(PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
            preparedStatement.setString(1,id);
            ResultSet res = preparedStatement.executeQuery();

            if (res.next()){
                String empId = res.getString("room_id");
                String name = res.getInt("room_number");
                int age = res.getInt("capacity");
                String department = res.getString("available_capacity");
                return String.format("ID: %s, Name: %s, Age: %d, Department: %s\n", room_id, room_number, capacity, available_capacity);

            } else {
                return "room records are empty!";
            }
        }
        catch (SQLException e){
            return "Retrieving room is unsuccessful! Reason: "+ e.getSQLState();
        }
    }
    public String updateRoom(String room_id, String attribute, Object value,Connection conn){
        String sql = "UPDATE rooms SET " + attribute + " = ? WHERE room_id = ?";
        try(PreparedStatement preparedStatement = conn.prepareStatement(sql);) {

            if(!attribute.equals("room_number")) {
                preparedStatement.setString(1, value.toString());
            }else{
                preparedStatement.setInt(1,Integer.parseInt(value.toString()));
            }
            preparedStatement.setString(2,id);

            int res = preparedStatement.executeUpdate(); // can use  preparedStatement.executeUpdate();
            if (res>0) {
                return "Successfully updated the record of the room Id: " + id;
            } else {
                return "Updating employee is unsuccessful!";
            }
        }
        catch (SQLException e){
            return "Updating employee is unsuccessful! Reason: "+ e.getMessage();
        }
    }

}
