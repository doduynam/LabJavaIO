package com.company;

import java.util.Comparator;

public class compareIDAscending implements Comparator<Student> {
    public int compare(Student s1, Student s2) {
        if (s1.get_ID() == s2.get_ID()) {
            return 0;
        }
        else if (s1.get_ID() > s2.get_ID()) {
            return 1;
        }
        else {
            return -1;
        }
    }
}
