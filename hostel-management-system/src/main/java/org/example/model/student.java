package org.example.model;

public class student {
    private static String studentId;
    private static  String studentName;
    private static int studentAge;
    private static String department;

    public static String getStudentId() {
        return studentId;
    }

    public static void setStudentId(String studentId) {
        student.studentId = studentId;
    }

    public static String getStudentName() {
        return studentName;
    }

    public static void setStudentName(String studentName) {
        student.studentName = studentName;
    }

    public static int getStudentAge() {
        return studentAge;
    }

    public static void setStudentAge(int studentAge) {
        student.studentAge = studentAge;
    }

    public static String getDepartment() {
        return department;
    }

    public static void setDepartment(String department) {
        student.department = department;
    }

}
