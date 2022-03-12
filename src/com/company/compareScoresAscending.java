package com.company;

import java.util.Comparator;

public class compareScoresAscending implements Comparator<Student> {
    public int compare(Student s1, Student s2) {
        if (s1.get_scores() == s2.get_scores()) {
            return 0;
        }
        else if (s1.get_scores() > s2.get_scores()) {
            return 1;
        }
        else {
            return -1;
        }
    }
}
