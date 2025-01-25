package org.example;
import org.example.service.AppService;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        System.out.println("-----------------WELCOME HOSTEL MANAGEMENT SYSTEM----------------");
        System.out.println("--------------------------ABC Universiy--------------------------");

        System.out.println("PLEASE ENTER THE NUMBER OF THE ACTION YOU WANT OT PROCEED");
        System.out.println("[1]Manage Hostels");
        System.out.println("[2]Manage Students");
        System.out.println("[3]Manage Student Allocations");
        System.out.println("[0]Exit");

        int output = AppService.selectOption();

    }
}