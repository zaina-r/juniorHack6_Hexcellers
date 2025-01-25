package org.example.model;

public class student {
    private String studentId;
    private String studentName;
    private int studentAge;
    private String department;

    public student(String studentId, String studentName, int studentAge, String department) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentAge = studentAge;
        this.department = department;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getStudentAge() {
        return studentAge;
    }

    public void setStudentAge(int studentAge) {
        this.studentAge = studentAge;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
//    @Override
//    public String toString() {
//        return "student{}";
//    }
}
