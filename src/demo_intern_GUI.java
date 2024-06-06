import model.StudentInfo;
import service.StudentService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class demo_intern_GUI {
    private JPanel main;
    private JLabel title;
    private JTextField txtStudentId;
    private JTextField txtFullName;
    private JTextField txtDate;
    private JTextField txtGender;
    private JTextField txtAddress;
    private JTextField txtPhone;
    private JTextField txtEmail;
    private JButton saveButton;
    private JTable table1;
    private JButton updateButton;
    private JButton deleteButton;
    private JButton searchButton;
    private JTextField txtsearch;

    private StudentService studentService;

    public static void main(String[] args) {
        JFrame frame = new JFrame("demo_intern_GUI");
        frame.setContentPane(new demo_intern_GUI().main);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public demo_intern_GUI() {
        studentService = new StudentService();
        loadStudentTable();

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addstudent();
                loadStudentTable();
            }
        });
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateStudent();
                loadStudentTable();
            }
        });
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteStudent();
                loadStudentTable();
            }
        });
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchStudent();
                loadStudentTable();
            }
        });
    }

    private void addstudent(){
        StudentInfo studentInfo = new StudentInfo();

        studentInfo.setFullName(txtFullName.getText());
        studentInfo.setDayofBirth(txtDate.getText());
        studentInfo.setGender(txtGender.getText());
        studentInfo.setAddress(txtAddress.getText());
        studentInfo.setPhone(txtPhone.getText());
        studentInfo.setEmail(txtEmail.getText());

        studentService.addStudent(studentInfo);
    }

    private void updateStudent(){
        StudentInfo studentInfo = new StudentInfo();

        studentInfo.setFullName(txtFullName.getText());
        studentInfo.setDayofBirth(txtDate.getText());
        studentInfo.setGender(txtGender.getText());
        studentInfo.setAddress(txtAddress.getText());
        studentInfo.setPhone(txtPhone.getText());
        studentInfo.setEmail(txtEmail.getText());
        studentInfo.setStudentId(Integer.parseInt(txtStudentId.getText()));

        studentService.updateStudent(studentInfo);
    }

    private void deleteStudent(){
        int studentId = Integer.parseInt(txtsearch.getText());
        studentService.deleteStudent(studentId);
    }

    private void searchStudent(){
        String searchInput = txtsearch.getText().trim();


        List<StudentInfo> studentInfos = studentService.getAllStudents();

        try{
            int searchId = Integer.parseInt(searchInput);
            for(StudentInfo studentInfo : studentInfos){
                if(studentInfo.getStudentId() == searchId){
                    getSearch(studentInfo);
                    break;
                }
            }
        }catch (NumberFormatException e){
            for(StudentInfo studentInfo : studentInfos){
                if(studentInfo.getFullName().equalsIgnoreCase(searchInput)){
                    getSearch(studentInfo);
                    break;
                }
            }
        }

    }

    private void getSearch(StudentInfo studentInfo){
        txtStudentId.setText(String.valueOf(studentInfo.getStudentId()));
        txtFullName.setText(studentInfo.getFullName());
        txtDate.setText(studentInfo.getDayofBirth());
        txtGender.setText(studentInfo.getGender());
        txtAddress.setText(studentInfo.getAddress());
        txtPhone.setText(studentInfo.getPhone());
        txtEmail.setText(studentInfo.getEmail());
    }

    private void loadStudentTable(){
        List<StudentInfo> studentInfos = studentService.getAllStudents();
        String[] columnNames = {"ID", "Full Name", "Date of Birth", "Gender", "Address", "Phone", "Email"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        for (StudentInfo studentInfo: studentInfos){
            Object[] row = new Object[]{
                    studentInfo.getStudentId(),
                    studentInfo.getFullName(),
                    studentInfo.getDayofBirth(),
                    studentInfo.getGender(),
                    studentInfo.getAddress(),
                    studentInfo.getPhone(),
                    studentInfo.getEmail()
            };
            model.addRow(row);
        }
        table1.setModel(model);
    }
}
