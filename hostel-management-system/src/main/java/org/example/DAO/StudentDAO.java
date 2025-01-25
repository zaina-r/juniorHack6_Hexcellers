package org.example.DAO;

import org.example.db.dbConnector;
import org.example.model.student;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StudentDAO {

    private dbConnector dbConnector;
    private student student;

    public String addStudent(String id, String name, int age, String department){
        String query = "INSERT INTO students (student_id, name, age, department)VALUES (?,?,?,?)";
        try(PreparedStatement preparedStatement = org.example.db.dbConnector.getConnection().prepareStatement(query)) {

            preparedStatement.setString(1,student.getStudentId());
            preparedStatement.setString(2,student.getStudentName());
            preparedStatement.setInt(3,student.getStudentAge());
            preparedStatement.setString(4,student.getDepartment());

            int res = preparedStatement.executeUpdate(); // can use  preparedStatement.executeUpdate();

            if (res>0) {
                return "Successfully added the record of the employee Id: " + id;
            } else {
                return "Registering employee is unsuccessful!";
            }
        }
        catch (SQLException e){
            return "Registering student is unsuccessful! Reason: "+ e.getMessage();
        }
    }


}
