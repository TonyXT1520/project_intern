import model.StudentInfo;
import service.StudentService;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        StudentService studentService = new StudentService();

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

        updateStudent.setFullName("T");
        updateStudent.setDayofBirth("2006-06-07");
        updateStudent.setGender("Male");
        updateStudent.setAddress("HaNoi");
        updateStudent.setPhone("09353432");
        updateStudent.setEmail("T@gmail.com");
        updateStudent.setStudentId(1);

        studentService.updateStudent(updateStudent);

    }
}