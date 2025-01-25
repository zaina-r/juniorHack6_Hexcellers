package org.example.DAO;

import org.example.db.dbConnector;
import org.example.model.student;

import java.sql.PreparedStatement;
import java.sql.SQLException;

class AllocationDAO {

    private dbConnector dbConnector;
    private student student;

    public String addAllocation(String id, String name, String room_id,String allocation_date){
        String query = "INSERT INTO allocation (allocation_id, student_id, room_id, allocation_date)VALUES (?,?,?,?)";
        try(PreparedStatement preparedStatement = org.example.db.dbConnector.getConnection().prepareStatement(query)) {

            preparedStatement.setString(1,id);
            preparedStatement.setString(2,name);
            preparedStatement.setInt(3, Integer.parseInt(room_id));
            preparedStatement.setString(4,allocation_date);

            int res = preparedStatement.executeUpdate(); // can use  preparedStatement.executeUpdate();

            if (res>0) {
                return "Successfully added the record of the allocation Id: " + id;
            } else {
                return "Registering allocation is unsuccessful!";
            }
        }
        catch (SQLException e){
            return "Registering Allocation is unsuccessful! Reason: "+ e.getMessage();
        }
    }


}
