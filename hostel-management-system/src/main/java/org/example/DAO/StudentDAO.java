package org.example.DAO;

import org.example.db.dbConnector;
import org.example.model.student;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentDAO {

    private final dbConnector dbConnector;
    private final student student;

    public StudentDAO(org.example.db.dbConnector dbConnector, org.example.model.student student) {
        this.dbConnector = dbConnector;
        this.student = student;
    }

    public String addStudent(String id, String name, int age, String department){
        String sql = "INSERT INTO students (student_id, name, age, department)VALUES (?,?,?,?)";
        try(PreparedStatement preparedStatement = org.example.db.dbConnector.getConnection().prepareStatement(sql)) {

            preparedStatement.setString(1,student.getStudentId());
            preparedStatement.setString(2,student.getStudentName());
            preparedStatement.setInt(3,student.getStudentAge());
            preparedStatement.setString(4,student.getDepartment());

            int res = preparedStatement.executeUpdate(); // can use  preparedStatement.executeUpdate();

            if (res>0) {
                return "Successfully added the record of the student Id: " + id;
            } else {
                return "Registering employee is unsuccessful!";
            }
        }
        catch (SQLException e){
            return "Registering student is unsuccessful! Reason: "+ e.getMessage();
        }
    }

    //=======================================

    public String viewStudent(String id){
        String sql = "SELECT * FROM students WHERE student_id = ?;";
        StringBuilder result = new StringBuilder();
        try(PreparedStatement preparedStatement = org.example.db.dbConnector.getConnection().prepareStatement(sql)) {
            preparedStatement.setString(1,student.getStudentId());
            ResultSet res = preparedStatement.executeQuery();

            if (res.next()){
                String student_id = res.getString("student_id");
                String name = res.getString("name");
                int age = res.getInt("age");
                String department = res.getString("department");
                return String.format("ID: %s, Name: %s, Age: %d, Department: %s\n", student_id, name, age, department);

            } else {
                return "student records are empty!";
            }
        }
        catch (SQLException e){
            return "Retrieving student is unsuccessful! Reason: "+ e.getSQLState();
        }
    }

    //=================================

    public String updateStudent(String id, String attribute, Object value){
        String sql = "UPDATE students SET " + attribute + " = ? WHERE student_id = ?";
        try(PreparedStatement preparedStatement = org.example.db.dbConnector.getConnection().prepareStatement(sql)) {

            if(!attribute.equals("age")) {
                preparedStatement.setString(1, value.toString());
            }else{
                preparedStatement.setInt(1,Integer.parseInt(value.toString()));
            }
            preparedStatement.setString(2,id);

            int res = preparedStatement.executeUpdate(); // can use  preparedStatement.executeUpdate();
            if (res>0) {
                return "Successfully updated the record of the student Id: " + id;
            } else {
                return "Updating student is unsuccessful!";
            }
        }
        catch (SQLException e){
            return "Updating student is unsuccessful! Reason: "+ e.getMessage();
        }
    }

    //========================================================

    public String deleteEmployee(String id){
        String sql = "DELETE FROM employees WHERE employee_id = ?";
        try(PreparedStatement preparedStatement = org.example.db.dbConnector.getConnection().prepareStatement(sql)) {

            preparedStatement.setString(1,student.getStudentId());

            int row = preparedStatement.executeUpdate();
            if (row > 0) {
                return "Successfully deleted the record of the student Id: " + student.getStudentId();
            }
            else if (row == 0) {
                return "Given student is not found!";
            }
            else{
                return "Deleting student is unsuccessful!";
            }
        }
        catch (SQLException e){
            return "Deleting student is unsuccessful! Reason: "+ e.getMessage();
        }
    }




}
