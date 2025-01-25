package org.example;
import org.example.service.AppService;
import org.example.service.allocationService;
import org.example.service.hostelService;
import org.example.service.studentService;

import java.util.Scanner;

import static java.lang.System.exit;


public class Main {
    public static void main(String[] args) {

        System.out.println("-----------------WELCOME HOSTEL MANAGEMENT SYSTEM----------------\n");
        System.out.println("--------------------------ABC University--------------------------\n");

        System.out.println("PLEASE ENTER THE NUMBER OF THE ACTION YOU WANT OT PROCEED");
        System.out.println("[1]Manage Hostels");
        System.out.println("[2]Manage Students");
        System.out.println("[3]Manage Student Allocations");
        System.out.println("[0]Exit");

        int output = AppService.selectOption();

        if(output == 1){

            System.out.println("Hostel Management\n");
            System.out.println("[1]Add Hostel");
            System.out.println("[2]Update Hostel");
            System.out.println("[3]View Hostel Details");
            System.out.println("[4]Rooms Management");
            System.out.println("[0]Main menu");


            hostelService.selectOption();

        } else if (output == 2) {

            System.out.println("Student Management\n");
            System.out.println("[1]Add Student");
            System.out.println("[2]Remove Student");
            System.out.println("[3]Update Student");
            System.out.println("[4]View Student Details");
            System.out.println("[0]Main Menu");

            studentService.selectOption();

        } else if (output == 3){
            System.out.println("Student Allocation");

            allocationService.selectOption();
        } else if (output == 0) {
            exit(1);
        }


    }
}