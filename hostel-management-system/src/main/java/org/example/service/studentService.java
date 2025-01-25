package org.example.service;

import org.example.DAO.StudentDAO;

import java.util.Scanner;

public class studentService {

    public static int selectOption(){

        Scanner scan = new Scanner(System.in);

        int input = scan.nextInt();

        if(input == 1){
            System.out.println("Student Name:");
            String name = scan.nextLine();
            System.out.println("Student ID:");
            String ID = scan.nextLine();
            System.out.println("Student Age:");
            int age = scan.nextInt();
            System.out.println("Student Dept:");
            String dept = scan.nextLine();

            StudentDAO.addStudent(ID, name, age, dept);
        }

        return input;
    }
}
