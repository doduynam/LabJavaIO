package com.company;

import com.sun.source.tree.DoWhileLoopTree;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        MENU();
    }

    private static void feature() {
        System.out.println("\t1. Thêm học sinh.");
        System.out.println("\t2. Cập nhật thông tin học sinh.");
        System.out.println("\t3. Xóa học sinh.");
        System.out.println("\t4. Xem danh sách học sinh.");
        System.out.println("\t5. Import/Export danh sách học sinh (CSV)");
        System.out.println("\t0. Thoát chương trình");

    }

    public static void MENU() {
        Scanner scan = new Scanner(System.in);
        StudentManagement listStudent = new StudentManagement();
        int choice = 0;
        int ID;
        String name;
        double scores;
        String avatar;
        String address;
        String notes;

        while (true) {
            feature();
            System.out.print("Nhập chức năng muốn thực hiện: ");
            choice = Integer.parseInt(scan.nextLine());

            switch (choice) {
                case 0:
                {
                    ReadWriteBin.writeData(listStudent.get_studentList(), "data.bin");
                    return;
                }
                case 1:
                {
                    System.out.println("Thêm học sinh.");
                    System.out.print("Mã học sinh: ");
                    ID = Integer.parseInt(scan.nextLine());

                    while (!listStudent.isValidID(ID)) {
                        System.out.println("Mã học sinh đã có trong danh sách.");
                        System.out.print("Nhập lại Mã học sinh: ");
                        ID = Integer.parseInt(scan.nextLine());
                    }

                    System.out.print("Tên học sinh: ");
                    name = scan.nextLine();
                    System.out.print("Điểm: ");
                    scores = Double.parseDouble(scan.nextLine());
                    System.out.print("Đường dẫn hình ảnh: ");
                    avatar = scan.nextLine();
                    System.out.print("Địa chỉ: ");
                    address = scan.nextLine();
                    System.out.print("Ghi chú: ");
                    notes = scan.nextLine();

                    listStudent.addStudent(new Student(ID, name, scores, avatar, address, notes));
                    System.out.println("Thêm học sinh thành công.");

                    System.out.println("Nhấn enter để tiếp tục!");
                    scan.nextLine();
                    ReadWriteBin.writeData(listStudent.get_studentList(), "data.bin");
                    break;
                }
                case 2:
                {
                    System.out.println("Cập nhật thông tin học sinh.");
                    System.out.print("Nhập Mã học sinh cần cập nhật thông tin: ");
                    ID = Integer.parseInt(scan.nextLine());

                    while (listStudent.isValidID(ID)) {
                        System.out.println("Mã học sinh không có trong danh sách.");
                        System.out.print("Nhập lại mã học sinh: ");
                        ID = Integer.parseInt(scan.nextLine());
                    }

                    System.out.print("Thông tin học sinh cần sửa: ");
                    listStudent.printStudent(ID);

                    System.out.println("\t1. Sửa Mã học sinh.");
                    System.out.println("\t2. Sửa tên học sinh.");
                    System.out.println("\t3. Sửa điểm");
                    System.out.println("\t4. Sửa đường dẫn hình ảnh");
                    System.out.println("\t5. Sửa địa chỉ");
                    System.out.println("\t6. Sửa ghi chú");

                    System.out.print("Nhập chức năng muốn thực hiện: ");
                    choice = Integer.parseInt(scan.nextLine());

                    switch (choice) {
                        case 1:
                        {
                            System.out.println("1. Sửa Mã học sinh.");
                            System.out.print("Nhập Mã học sinh mới: ");
                            int newID = Integer.parseInt(scan.nextLine());

                            while (!listStudent.isValidID(newID)) {
                                System.out.println("Mã học đã có trong danh sách.");
                                System.out.print("Nhập lại mã học sinh: ");
                                newID = Integer.parseInt(scan.nextLine());
                            }

                            if(listStudent.updateID(ID, newID)) {
                                System.out.println("Cập nhật mã học sinh thành công.");
                            }
                            else {
                                System.out.println("Cập nhật mã học sinh thất bại.");
                            }

                            break;
                        }
                        case 2:
                        {
                            System.out.println("2. Sửa tên học sinh.");
                            System.out.print("Tên học sinh: ");
                            name = scan.nextLine();

                            if(listStudent.updateName(ID, name)) {
                                System.out.println("Cập nhật tên học sinh thành công.");
                            }
                            else {
                                System.out.println("Cập nhật tên học sinh thất bại.");
                            }

                            break;
                        }
                        case 3:
                        {
                            System.out.println("3. Sửa điểm");
                            System.out.print("Điểm: ");
                            scores = Double.parseDouble(scan.nextLine());

                            if(listStudent.updateScores(ID, scores)) {
                                System.out.println("Cập nhật điểm thành công.");
                            }
                            else {
                                System.out.println("Cập nhật điểm thất bại.");
                            }

                            break;
                        }
                        case 4:
                        {
                            System.out.println("4. Sửa đường dẫn hình ảnh");
                            System.out.print("Đường dẫn hình ảnh: ");
                            avatar = scan.nextLine();

                            if(listStudent.updateAvatar(ID, avatar)) {
                                System.out.println("Cập nhật đường dẫn hình ảnh thành công.");
                            }
                            else {
                                System.out.println("Cập nhật đường dẫn hình ảnh thất bại.");
                            }

                            break;
                        }
                        case 5:
                        {
                            System.out.println("5. Sửa địa chỉ");
                            System.out.print("Địa chỉ: ");
                            address = scan.nextLine();

                            if(listStudent.updateAddress(ID, address)) {
                                System.out.println("Cập nhật địa chỉ thành công.");
                            }
                            else {
                                System.out.println("Cập nhật địa chỉ thất bại.");
                            }
                            break;
                        }
                        case 6:
                        {
                            System.out.println("6. Sửa ghi chú");
                            System.out.print("Ghi chú: ");
                            notes = scan.nextLine();

                            if(listStudent.updateNote(ID, notes)) {
                                System.out.println("Cập nhật ghi chú thành công.");
                            }
                            else {
                                System.out.println("Cập nhật ghi chú thất bại.");
                            }

                            break;
                        }
                        default:
                            break;
                    }

                    System.out.println("Nhấn enter để tiếp tục!");
                    scan.nextLine();
                    ReadWriteBin.writeData(listStudent.get_studentList(), "data.bin");
                    break;
                }
                case 3:
                {
                    System.out.println("Xóa học sinh.");
                    System.out.print("Nhập Mã học sinh cần xóa: ");
                    ID = Integer.parseInt(scan.nextLine());

                    while (listStudent.isValidID(ID)) {
                        System.out.println("Mã học sinh không có trong danh sách.");
                        System.out.print("Nhập lại mã học sinh: ");
                        ID = Integer.parseInt(scan.nextLine());
                    }

                    System.out.print("Thông tin học sinh muốn xóa: ");
                    listStudent.printStudent(ID);

                    System.out.print("Bạn có muốn xóa học sinh này ra khỏi danh sách? (Y/N): ");
                    String check = scan.nextLine();
                    if (check.equals("Y") || check.equals("y")) {
                        if (listStudent.removeStudent(ID)) {
                            System.out.println("Xóa học sinh thành công.");
                        }
                        else {
                            System.out.println("Xóa học sinh thất bại.");
                        }
                    }
                    else {
                        System.out.println("Không xóa học sinh khỏi danh sách");
                    }

                    System.out.println("Nhấn enter để tiếp tục!");
                    scan.nextLine();
                    ReadWriteBin.writeData(listStudent.get_studentList(), "data.bin");
                    break;
                }
                case 4:
                {
                    System.out.println("Xem danh sách học sinh.");

                    System.out.println("\t1. Xem danh sách theo mã học sinh tăng dần.");
                    System.out.println("\t2. Xem danh sách theo mã học sinh giảm dần.");
                    System.out.println("\t3. Xem danh sách theo điểm tăng dần.");
                    System.out.println("\t4. Xem danh sách theo điểm giảm dần.");

                    System.out.print("Chọn cách hiển thị danh sách: ");
                    int sortOrder = Integer.parseInt(scan.nextLine());

                    listStudent.printList(sortOrder);

                    System.out.println("Nhấn enter để tiếp tục!");
                    scan.nextLine();
                    break;
                }
                case 5:
                {
                    System.out.println("Import/Export danh sách học sinh (CSV)");
                    System.out.println("\t1. Import danh sách học sinh từ file CSV");
                    System.out.println("\t2. Export danh sách học sinh ra file CSV");

                    System.out.print("Nhập chức năng muốn thực hiện: ");
                    choice = Integer.parseInt(scan.nextLine());

                    switch (choice) {
                        case 1:
                        {
                            System.out.println("1. Import danh sách học sinh từ file CSV");
                            System.out.print("Nhập tên file cần import (không bao gồm đuôi .csv): ");
                            String filename = scan.nextLine();

                            ReadWriteCSV.readCSV(filename + ".csv");
                            System.out.println("Import thành công");
                            break;
                        }
                        case 2:
                        {
                            System.out.println("2. Export danh sách học sinh ra file CSV");
                            System.out.print("Nhập tên file cần export (không bao gồm đuôi .csv): ");
                            String filename = scan.nextLine();

                            ReadWriteCSV.writeCSV(listStudent.get_studentList(), filename + ".csv");
                            System.out.println("Export thành công");
                            break;
                        }
                        default:
                            break;
                    }

                    System.out.println("Nhấn enter để tiếp tục!");
                    scan.nextLine();
                    ReadWriteBin.writeData(listStudent.get_studentList(), "data.bin");
                    break;
                }
                default:
                {
                    break;
                }
            }

        }
    }
}
