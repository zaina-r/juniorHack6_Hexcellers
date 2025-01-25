package org.example.DAO;

import org.example.db.dbConnector;
import org.example.model.allocation;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AllocationDAO {

    private dbConnector dbConnector;
    private allocation alocation ;

    public String addAllocation(String allocation_id, String student_id, String room_id, String allocation_date){
        String query = "INSERT INTO allocation (allocation_id, student_id, room_id, allocation_date)VALUES (?,?,?,?)";
        try(PreparedStatement preparedStatement = org.example.db.dbConnector.getConnection().prepareStatement(query)) {

            preparedStatement.setString(1,alocation.getAllocationId());
            preparedStatement.setString(2,alocation.getStudentId());
            preparedStatement.setInt(3,alocation.getRoomId());
            preparedStatement.setString(4,alocation.getAllocationDate());

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

    public String viewAllocation(String allocation_id, dbConnector conn){
        String sql = "SELECT * FROM allocation WHERE allocation_id = ?;";
        StringBuilder result = new StringBuilder();
        try(PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
            preparedStatement.setString(1,allocation_id);
            ResultSet res = preparedStatement.executeQuery();

            if (res.next()){
                String allocationId = res.getString("allocation_id");
                String student_id= res.getString("student_id");
                String  room_id= res.getString("room_id");
                String allocation_date=res.getString("allocation_date")
                return String.format("allocation_id: %s, student_id: %s, room_id: %d, AllocationDate: %s\n", allocationId, student_id, room_id, allocation_date);

            } else {
                return "employee records are empty!";
            }
        }
        catch (SQLException e){
            return "Retrieving employee is unsuccessful! Reason: "+ e.getSQLState();
        }
    }

    //=================================

    public String updateAllocation(String allocation_id, String, Object value,Connection conn){
        String sql = "UPDATE alocation SET " + attribute + " = ? WHERE allocation_id = ?";
        try(PreparedStatement preparedStatement = conn.prepareStatement(sql);) {

            if(!attribute.equals("age")) {
                preparedStatement.setString(1, value.toString());
            }else{
                preparedStatement.setInt(1,Integer.parseInt(value.toString()));
            }
            preparedStatement.setString(2,id);

            int res = preparedStatement.executeUpdate(); // can use  preparedStatement.executeUpdate();
            if (res>0) {
                return "Successfully updated the record of the allocation_id: " + allocation_id;
            } else {
                return "Updating allocation is unsuccessful!";
            }
        }
        catch (SQLException e){
            return "Updating allocation is unsuccessful! Reason: "+ e.getMessage();
        }
    }

    //========================================================

    public String deleteAllocation(String allocation_id, Connection conn){
        String sql = "DELETE FROM allocation WHERE allocation_id = ?";
        try(PreparedStatement preparedStatement = conn.prepareStatement(sql);) {

            preparedStatement.setString(1,allocation_id);

            int row = preparedStatement.executeUpdate();
            if (row > 0) {
                return "Successfully deleted the record of the allocationid: " + alocation_id;
            }
            else if (row == 0) {
                return "Given allocation is not found!";
            }
            else{
                return "Deleting allocation is unsuccessful!";
            }
        }
        catch (SQLException e){
            return "Deleting allocation is unsuccessful! Reason: "+ e.getMessage();
        }
    }






}


}
