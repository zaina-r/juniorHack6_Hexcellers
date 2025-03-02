package org.example.DAO;

import org.example.db.dbConnector;
import org.example.model.hostel;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class HostelDAO {

    private dbConnector dbConnector;
    private hostel hostel;

    public String addHostel(String hostelId, String hostelName, int numberofRooms){
        String query = "INSERT INTO Hostel (hostelId, hostelName,numberofRooms)VALUES (?,?,?)";
        try(PreparedStatement preparedStatement = org.example.db.dbConnector.getConnection().prepareStatement(query)) {

            preparedStatement.setLong(1,hostel.getHostelId());
            preparedStatement.setString(2,hostel.getHostelName());
            preparedStatement.setInt(3,hostel.getNumberofRooms());


            int res = preparedStatement.executeUpdate(); // can use  preparedStatement.executeUpdate();

            if (res>0) {
                return "Successfully added the record of the Hostel: " + hostelId;
            } else {
                return "Registering hostel is unsuccessful!";
            }
        }
        catch (SQLException e){
            return "Registering hostel is unsuccessful! Reason: "+ e.getMessage();
        }
    }

    public String viewHostel( hostelId, dbConnector conn){
        String sql = "SELECT * FROM hostel WHERE hostelId = ?;";
        StringBuilder result = new StringBuilder();
        try(PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
            preparedStatement.setString(1,hostelId);
            ResultSet res = preparedStatement.executeQuery();

            if (res.next()){
                string hostelId = res.getString("hostelId");
                String hostelName = res.getString("hostelName");
                int numberofRooms = res.getInt("numberofRooms");

                return String.format("ID: %s, Name: %s, Age: %d, Department: %s\n", hostelId, hostelName, numberofRooms);

            } else {
                return "hostel records are empty!";
            }
        }
        catch (SQLException e){
            return "Retrieving hostel is unsuccessful! Reason: "+ e.getSQLState();
        }
    }

    //=================================

    public String updateHostel(String hostelId, String attribute, Object value,Connection conn){
        String sql = "UPDATE hostel SET " + attribute + " = ? WHERE hostelId = ?";
        try(PreparedStatement preparedStatement = conn.prepareStatement(sql);) {

            if(!attribute.equals("hostelName")) {
                preparedStatement.setString(1, value.toString());
            }else{
                preparedStatement.setInt(1,Integer.parseInt(value.toString()));
            }
            preparedStatement.setString(2,hostelId);

            int res = preparedStatement.executeUpdate(); // can use  preparedStatement.executeUpdate();
            if (res>0) {
                return "Successfully updated the record of the hostel Id: " + id;
            } else {
                return "Updating hostel is unsuccessful!";
            }
        }
        catch (SQLException e){
            return "Updating hostel is unsuccessful! Reason: "+ e.getMessage();
        }
    }

    //========================================================

    public String deleteEmployee(String hostelId, Connection conn){
        String sql = "DELETE FROM hostels WHERE hostelId = ?";
        try(PreparedStatement preparedStatement = conn.prepareStatement(sql);) {

            preparedStatement.setString(1,id);

            int row = preparedStatement.executeUpdate();
            if (row > 0) {
                return "Successfully deleted the record of the employee Id: " + id;
            }
            else if (row == 0) {
                return "Given hostel is not found!";
            }
            else{
                return "Deleting hostel is unsuccessful!";
            }
        }
        catch (SQLException e){
            return "Deleting hostel is unsuccessful! Reason: "+ e.getMessage();
        }
    }




}
