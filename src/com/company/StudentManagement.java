package com.company;

import java.util.*;

public class StudentManagement {
    private ArrayList<Student> _studentList;

    public StudentManagement() {
        _studentList = new ArrayList<Student>();
    }

    // Add student in list
    public void addStudent(Student std) {
        _studentList.add(std);
    }

    public boolean updateID(int oldID, int newID) {
        for (Student std : _studentList) {
            if (std.get_ID() == oldID) {
                std.set_ID(newID);
                return true;
            }
        }
        return false;
    }

    // Update infomation of stident with ID
    public boolean updateName(int ID, String newName) {
        for (Student std : _studentList) {
            if (std.get_ID() == ID) {
                std.set_name(newName);
                return true;
            }
        }
        return false;
    }

    public boolean updateScores(int ID, double newScores) {
        for (Student std : _studentList) {
            if (std.get_ID() == ID) {
                std.set_scores(newScores);
                return true;
            }
        }
        return false;
    }

    public  boolean updateAvatar(int ID, String newAvatar) {
        for (Student std : _studentList) {
            if (std.get_ID() == ID) {
                std.set_avatar(newAvatar);
                return true;
            }
        }
        return false;
    }

    public boolean updateAddress(int ID, String newAddress) {
        for (Student std : _studentList) {
            if (std.get_ID() == ID) {
                std.set_address(newAddress);
                return true;
            }
        }
        return false;
    }

    public boolean updateNote(int ID, String newNote) {
        for (Student std : _studentList) {
            if (std.get_ID() == ID) {
                std.set_note(newNote);
                return true;
            }
        }
        return false;
    }

    // Remove student in list
    public boolean removeStudent(int ID) {
        for (Student std : _studentList) {
            if (std.get_ID() == ID) {
                _studentList.remove(std);
                return true;
            }
        }
        return false;
    }

    // View list student with sortOrder
    public void printList(ComparatorClass sortOrder) {
        ArrayList<Student> sortList = new ArrayList<>(_studentList);
        Collections.sort(sortList, new sortOrder);

    }


}
