package com.company;

import java.io.*;
import java.util.ArrayList;

public class ReadWriteBin {
    public static ArrayList<Student> readData(String fileName) {
        ArrayList<Student> studentList = new ArrayList<Student>();

        try {
            ObjectInputStream inFile = new ObjectInputStream(new FileInputStream(fileName));
            int lengthList = inFile.readInt();
            for (int i = 0; i < lengthList; i++) {
                Student buf = (Student) inFile.readObject();
                studentList.add(buf);
            }
            inFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return studentList;
    }

    public static void writeData(ArrayList<Student> studentList, String fileName) {
        try {
            ObjectOutputStream outFile = new ObjectOutputStream(new FileOutputStream(fileName));
            outFile.writeInt(studentList.size());
            for (Student s : studentList) {
                outFile.writeObject(s);
            }
            outFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
