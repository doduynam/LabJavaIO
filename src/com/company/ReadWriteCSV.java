package com.company;

import java.io.*;
import java.util.ArrayList;

public class ReadWriteCSV {
    public static void writeCSV(ArrayList<Student> list, String fileName) {
        try {
            PrintWriter outFile = new PrintWriter(new File(fileName));
            for (Student s : list) {
                outFile.println(s);
            }

            outFile.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Student> readCSV(String fileName) {
        String buff;
        ArrayList<Student> result = new ArrayList<Student>();
        try {
            BufferedReader inFile = new BufferedReader(new FileReader(fileName));
            while ((buff = inFile.readLine()) != null) {
                String[] row = buff.split(", ");
                result.add(new Student(Integer.parseInt(row[0]), row[1], Double.parseDouble(row[2]), row[3], row[4], row[5]));
            }

            inFile.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }
}
