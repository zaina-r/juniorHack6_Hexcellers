package org.example.service;

import org.example.DAO.StudentDAO;

import java.util.Scanner;

public class studentService {

    StudentDAO studentDAO;
    public static int selectOption(){

        Scanner scan = new Scanner(System.in);

        int input = scan.nextInt();

        switch (input){
            case 1:

        }
        return input;
    }
}
