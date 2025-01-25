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

    //=======================================

    public String viewStudent(String id, dbConnector conn){
        String sql = "SELECT * FROM students WHERE employee_id = ?;";
        StringBuilder result = new StringBuilder();
        try(PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
            preparedStatement.setString(1,id);
            ResultSet res = preparedStatement.executeQuery();

            if (res.next()){
                String empId = res.getString("employee_id");
                String name = res.getString("name");
                int age = res.getInt("age");
                String department = res.getString("department");
                return String.format("ID: %s, Name: %s, Age: %d, Department: %s\n", id, name, age, department);

            } else {
                return "employee records are empty!";
            }
        }
        catch (SQLException e){
            return "Retrieving employee is unsuccessful! Reason: "+ e.getSQLState();
        }
    }

    //=================================

    public String updateEmployee(String id, String attribute, Object value,Connection conn){
        String sql = "UPDATE employees SET " + attribute + " = ? WHERE employee_id = ?";
        try(PreparedStatement preparedStatement = conn.prepareStatement(sql);) {

            if(!attribute.equals("age")) {
                preparedStatement.setString(1, value.toString());
            }else{
                preparedStatement.setInt(1,Integer.parseInt(value.toString()));
            }
            preparedStatement.setString(2,id);

            int res = preparedStatement.executeUpdate(); // can use  preparedStatement.executeUpdate();
            if (res>0) {
                return "Successfully updated the record of the employee Id: " + id;
            } else {
                return "Updating employee is unsuccessful!";
            }
        }
        catch (SQLException e){
            return "Updating employee is unsuccessful! Reason: "+ e.getMessage();
        }
    }

    //========================================================

    public String deleteEmployee(String id, Connection conn){
        String sql = "DELETE FROM employees WHERE employee_id = ?";
        try(PreparedStatement preparedStatement = conn.prepareStatement(sql);) {

            preparedStatement.setString(1,id);

            int row = preparedStatement.executeUpdate();
            if (row > 0) {
                return "Successfully deleted the record of the employee Id: " + id;
            }
            else if (row == 0) {
                return "Given employee is not found!";
            }
            else{
                return "Deleting employee is unsuccessful!";
            }
        }
        catch (SQLException e){
            return "Deleting employee is unsuccessful! Reason: "+ e.getMessage();
        }
    }



    //public String removeStudent();


}
