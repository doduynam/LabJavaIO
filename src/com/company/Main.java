package com.company;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Main {

    public static void main(String[] args) {

        Student std = new Student();

        try {
            ObjectOutputStream outfile = new ObjectOutputStream(new FileOutputStream("student.bin"));
            outfile.writeObject(std);
            outfile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Done");


    }
}
