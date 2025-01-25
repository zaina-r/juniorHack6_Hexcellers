package org.example.model;

public class hostel {


    private Long hostelId;
    private  int numberofRooms;
    private  String hostelName;

    public Long getHostelId() {
        return hostelId;
    }

    public void setHostelId(Long hostelId) {
        this.hostelId = hostelId;
    }

    public String getHostelName() {
        return hostelName;
    }

    public hostel(Long hostelId, int numberofRooms, String hostelName) {
        this.hostelId = hostelId;
        this.numberofRooms = numberofRooms;
        this.hostelName = hostelName;
    }

    public void setHostelName(String hostelName) {
        this.hostelName = hostelName;
    }

    public int getNumberofRooms() {
        return numberofRooms;
    }

    public void setNumberofRooms(int numberofRooms) {
        this.numberofRooms = numberofRooms;
    }

}
