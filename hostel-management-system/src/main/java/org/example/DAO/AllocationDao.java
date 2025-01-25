package org.example.DAO;

import org.example.db.dbConnector;
import org.example.model.student;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AllocationDAO {

    private dbConnector dbConnector;
    private student student;

    public String addAllocation(String id, String name, String student student_id, String room_id,String allocation_date){
        String query = "INSERT INTO allocation (allocation_id, student_id, room_id, allocation_date)VALUES (?,?,?,?)";
        try(PreparedStatement preparedStatement = org.example.db.dbConnector.getConnection().prepareStatement(query)) {

            preparedStatement.setString(1,student.getAllocationId());
            preparedStatement.setString(2,student.getStudentId());
            preparedStatement.setInt(3,student.getRoomId());
            preparedStatement.setString(4,student.getAllocationDate());

            int res = preparedStatement.executeUpdate(); // can use  preparedStatement.executeUpdate();

            if (res>0) {
                return "Successfully added the record of the allocation Id: " + alocation_id;
            } else {
                return "Registering allocation is unsuccessful!";
            }
        }
        catch (SQLException e){
            return "Registering Allocation is unsuccessful! Reason: "+ e.getMessage();
        }
    }


}
