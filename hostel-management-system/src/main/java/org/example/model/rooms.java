package org.example.model;

public class rooms {
    private String room_id;
    private String hostel_id;
    private int room_number;
    private int capacity;
    private int available_capacity;

    public rooms(String room_id, String hostel_id, int room_number, int capacity, int available_capacity) {
        this.room_id = room_id;
        this.hostel_id = hostel_id;
        this.room_number = room_number;
        this.capacity = capacity;
        this.available_capacity = available_capacity;
    }

    public String getRoom_id() {
        return room_id;
    }

    public void setRoom_id(String room_id) {
        this.room_id = room_id;
    }

    public String getHostel_id() {
        return hostel_id;
    }

    public void setHostel_id(String hostel_id) {
        this.hostel_id = hostel_id;
    }

    public int getRoom_number() {
        return room_number;
    }

    public void setRoom_number(int room_number) {
        this.room_number = room_number;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getAvailable_capacity() {
        return available_capacity;
    }

    public void setAvailable_capacity(int available_capacity) {
        this.available_capacity = available_capacity;
    }
}
