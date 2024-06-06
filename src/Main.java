import model.StudentInfo;
import service.StudentService;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        StudentService studentService = new StudentService();
        StudentInfo searchStudent = new StudentInfo();

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

        StudentInfo deleteStudent = new StudentInfo();

        Scanner input = new Scanner(System.in);
        System.out.println("1. add student");
        System.out.println("2. update student");
        System.out.println("3. delete student");
        System.out.println("4. search student");
        System.out.print("enter the number below to execute: ");
        int in = input.nextInt();


        switch (in){
            case 1:
                System.out.print("choose id you want to add: ");
                break;
            case 2:
                System.out.print("choose id you want to update: ");
                break;
            case 3:
                System.out.print("choose id you want to delete: ");
                break;
            case 4:
                System.out.print("enter number student_id you want to find: ");
                int studentId = input.nextInt();

                    System.out.println("Student_id: " + searchStudent.getStudentId());
                    System.out.println("Full Name: " + searchStudent.getFullName());
                    System.out.println("Day of Birth: " + searchStudent.getDayofBirth());
                    System.out.println("Gender: " + searchStudent.getGender());
                    System.out.println("Address: " + searchStudent.getAddress());
                    System.out.println("Phone number: " + searchStudent.getPhone());
                    System.out.println("Email: " + searchStudent.getEmail());
                    break;


        }


    }
}