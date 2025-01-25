package org.example.DAO;

import org.example.db.dbConnector;
import org.example.model.student;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class HostelDAO {

    private dbConnector dbConnector;
    private hostel hostel;

    public String addHostel(Long hostelId, String hostelName, int numberofRooms){
        String query = "INSERT INTO Hostel (hostelId, hostelName,numberofRooms)VALUES (?,?,?)";
        try(PreparedStatement preparedStatement = org.example.db.dbConnector.getConnection().prepareStatement(query)) {

            preparedStatement.setLong(1,hostel.getHostelId());
            preparedStatement.setString(2,hostel.getHostelName());
            preparedStatement.setInt(3,hostel.getNumberofRooms());


            int res = preparedStatement.executeUpdate(); // can use  preparedStatement.executeUpdate();

            if (res>0) {
                return "Successfully added the record of the Hostel: " + id;
            } else {
                return "Registering hostel is unsuccessful!";
            }
        }
        catch (SQLException e){
            return "Registering hostel is unsuccessful! Reason: "+ e.getMessage();
        }
    }


}
