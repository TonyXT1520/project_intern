import model.StudentInfo;
import service.StudentService;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        StudentService studentService = new StudentService();
        StudentInfo deleteStudent = new StudentInfo();
        StudentInfo addStudent = new StudentInfo();

        List<StudentInfo> studentInfoList = studentService.getAllStudents();
        for (StudentInfo studentInfo: studentInfoList){
            System.out.println("ID: " + studentInfo.getStudentId());
            System.out.println("FullName: " + studentInfo.getFullName());
            System.out.println("Date Of Birth: " + studentInfo.getDayofBirth());
            System.out.println("Gender: " + studentInfo.getGender());
            System.out.println("Address: " + studentInfo.getAddress());
            System.out.println("Phone: " + studentInfo.getPhone());
            System.out.println("Email: " + studentInfo.getEmail());
            System.out.println();
        }

        StudentInfo updateStudent = new StudentInfo();

        /*updateStudent.setFullName("T");
        updateStudent.setDayofBirth("2006-06-07");
        updateStudent.setGender("Male");
        updateStudent.setAddress("HaNoi");
        updateStudent.setPhone("09353432");
        updateStudent.setEmail("T@gmail.com");
        updateStudent.setStudentId(1);*/

        //studentService.updateStudent(updateStudent);

        Scanner input = new Scanner(System.in);
        System.out.println("1. add student");
        System.out.println("2. update student");
        System.out.println("3. delete student");
        System.out.println("4. search student");
        System.out.print("enter the number below to execute: ");
        int in = input.nextInt();


        switch (in){
            case 1:
                System.out.print("enter Name: ");
                String name = input.next();
                System.out.print("enter Date of Birth: ");
                String dateofbirth = input.next();
                System.out.print("enter Gender: ");
                String gender = input.next();
                System.out.print("enter Address: ");
                String address = input.next();
                System.out.print("enter Phone: ");
                String phone = input.next();
                System.out.print("enter Email: ");
                String email = input.next();
                for(StudentInfo studentInfo: studentInfoList){
                    studentInfo.setFullName(name);
                    studentInfo.setDayofBirth(dateofbirth);
                    studentInfo.setGender(gender);
                    studentInfo.setAddress(address);
                    studentInfo.setPhone(phone);
                    studentInfo.setEmail(email);
                    studentService.addStudent(studentInfo);
                    break;
                }
                System.out.println(" ");
                System.out.println("A Student add successfully");
            case 2:
                System.out.print("choose id you want to update: ");

                break;
            case 3:
                System.out.print("choose id you want to delete: ");
                int delete_id = input.nextInt();
                for (StudentInfo studentInfo: studentInfoList){
                    if (studentInfo.getStudentId() == delete_id){
                        studentService.deleteStudent(delete_id);
                    }
                }
                break;
            case 4:
                System.out.println("1. find by id");
                System.out.println("2. find by name");
                System.out.print("enter the number below to execute: ");
                int in_4 = input.nextInt();
                switch (in_4){
                    case 1:
                        System.out.print("enter number student_id you want to find: ");
                        int studentId = input.nextInt();
                        for(StudentInfo studentInfo: studentInfoList) {
                            if (studentInfo.getStudentId() == studentId) {
                                System.out.println(" ");
                                System.out.println("Student_id: " + studentInfo.getStudentId());
                                System.out.println("Full Name: " + studentInfo.getFullName());
                                System.out.println("Day of Birth: " + studentInfo.getDayofBirth());
                                System.out.println("Gender: " + studentInfo.getGender());
                                System.out.println("Address: " + studentInfo.getAddress());
                                System.out.println("Phone number: " + studentInfo.getPhone());
                                System.out.println("Email: " + studentInfo.getEmail());
                                break;
                            }
                        }
                    case 2:
                        System.out.print("enter name student you want to find: ");
                        String studentFullname = input.next();
                        for(StudentInfo studentInfo: studentInfoList) {
                            if (studentInfo.getFullName().equalsIgnoreCase(studentFullname)) {
                                System.out.println(" ");
                                System.out.println("Student_id: " + studentInfo.getStudentId());
                                System.out.println("Full Name: " + studentInfo.getFullName());
                                System.out.println("Day of Birth: " + studentInfo.getDayofBirth());
                                System.out.println("Gender: " + studentInfo.getGender());
                                System.out.println("Address: " + studentInfo.getAddress());
                                System.out.println("Phone number: " + studentInfo.getPhone());
                                System.out.println("Email: " + studentInfo.getEmail());
                                break;
                            }

                        }
                }

        }
    }
}