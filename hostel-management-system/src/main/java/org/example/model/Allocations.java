package org.example.model;


public class Allocations {
    private String allocation_id;
    private String allocation_date;
    private String room_id;

    private String student_id;

    public Allocations(String allocation_id, String allocation_date, String room_id, String student_id) {
        this.allocation_id = allocation_id;
        this.allocation_date = allocation_date;
        this.room_id = room_id;
        this.student_id = student_id;
    }

    public String getAllocation_id() {
        return allocation_id;
    }

    public void setAllocation_id(String allocation_id) {
        this.allocation_id = allocation_id;
    }

    public String getAllocation_date() {
        return allocation_date;
    }

    public void setAllocation_date(String allocation_date) {
        this.allocation_date = allocation_date;
    }

    public String getRoom_id() {
        return room_id;
    }

    public void setRoom_id(String room_id) {
        this.room_id = room_id;
    }

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }
}
