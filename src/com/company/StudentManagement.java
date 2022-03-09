package com.company;

import java.util.ArrayList;

public class StudentManagement {
    private ArrayList<Student> _studentList;

    public StudentManagement() {
        _studentList = new ArrayList<Student>();
    }

    public void addStudent(Student std) {
        _studentList.add(std);
    }



}
