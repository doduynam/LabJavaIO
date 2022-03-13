package com.company;

import java.util.*;

public class StudentManagement {
    private ArrayList<Student> _studentList;

    public StudentManagement() {
        _studentList = ReadWriteBin.readData("data.bin");
    }

    // Check ID available
    public boolean isValidID(int ID) {
        for(Student s : _studentList) {
            if (s.get_ID() == ID) {
                return false;
            }
        }
        return true;
    }

    // Print infomation of student with ID
    public void printStudent(int ID) {
        for (Student s : _studentList) {
            if (s.get_ID() == ID) {
                System.out.println(s);
                return;
            }
        }
    }

    // Get list student
    public ArrayList<Student> get_studentList() {
        return _studentList;
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
    // sortOrder = 1 when sort ascending ID
    // sortOrder = 2 when sort descending ID
    // sortOrder = 3 when sort ascending scores
    // sortOrder = 4 when sort descending scores
    public void printList(int sortOrder) {
        ArrayList<Student> sortList = new ArrayList<>(_studentList);

        switch (sortOrder) {
            case 1:
            {
                Collections.sort(sortList, new compareIDAscending());
                break;
            }
            case 2:
            {
                Collections.sort(sortList, new compareIDDescending());
                break;
            }
            case 3:
            {
                Collections.sort(sortList, new compareScoresAscending());
                break;
            }
            case 4:
            {
                Collections.sort(sortList, new compareScoresDescending());
                break;
            }
        }

        for (Student std : sortList) {
            System.out.println(std);
        }

        
    }



}
