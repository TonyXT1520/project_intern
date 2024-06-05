package dao;

import config.DataSource;
import model.StudentInfo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataImplement extends DataClose {

    public  List<StudentInfo> getAllStudents(){
        List<StudentInfo> studentInfos = new ArrayList<>();


        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try{
            String query = "SELECT * FROM student";
            connection = DataSource.createConnection();
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                StudentInfo studentInfo = new StudentInfo();
                studentInfo.setStudentId(resultSet.getInt("student_id"));
                studentInfo.setFullName(resultSet.getString("full_name"));
                studentInfo.setDayofBirth(resultSet.getDate("date_of_birth").toString());
                studentInfo.setGender(resultSet.getString("gender"));
                studentInfo.setAddress(resultSet.getString("address"));
                studentInfo.setPhone(resultSet.getString("phone"));
                studentInfo.setEmail(resultSet.getString("email"));

                studentInfos.add(studentInfo);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closeCon(connection);
            closePst(preparedStatement);
            closeRs(resultSet);
        }
        return studentInfos;
    }

    public static void addStudent(StudentInfo studentInfo){

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            String addStudent = "INSERT INTO student (full_name, date_of_birth, gender, address, phone, email) VALUES (?, ?, ?, ?, ?, ?)";
            connection = DataSource.createConnection();
            preparedStatement = connection.prepareStatement(addStudent);


            preparedStatement.setString(1, studentInfo.getFullName());
            preparedStatement.setDate(2, java.sql.Date.valueOf(studentInfo.getDayofBirth()));
            preparedStatement.setString(3, studentInfo.getGender());
            preparedStatement.setString(4, studentInfo.getAddress());
            preparedStatement.setString(5, studentInfo.getPhone());
            preparedStatement.setString(6, studentInfo.getEmail());

            int rowsInserted = preparedStatement.executeUpdate();
            if (rowsInserted > 0){
                System.out.println("A new student was inserted successfully!");
            }
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteStudent(int studentId){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try{
            String deleteStudent = "DELETE FROM student WHERE student_id = ?";
            connection = DataSource.createConnection();
            preparedStatement = connection.prepareStatement(deleteStudent);


            preparedStatement.setInt(1, studentId);
            preparedStatement.executeUpdate();

            int rowsInserted = preparedStatement.executeUpdate();
            if (rowsInserted > 0){
                System.out.println("A student deleted successfully!");
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateStudent(StudentInfo studentInfo){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try{
            String updateStudent = "UPDATE student SET full_name = ?, date_of_birth = ?, gender = ?, address = ?, phone = ?, email = ? WHERE student_id = ?";

            connection = DataSource.createConnection();
            preparedStatement = connection.prepareStatement(updateStudent);

            preparedStatement.setString(1,studentInfo.getFullName());
            preparedStatement.setDate(2, java.sql.Date.valueOf(studentInfo.getDayofBirth()));
            preparedStatement.setString(3, studentInfo.getGender());
            preparedStatement.setString(4, studentInfo.getAddress());
            preparedStatement.setString(5, studentInfo.getPhone());
            preparedStatement.setString(6, studentInfo.getEmail());
            preparedStatement.setInt(7, studentInfo.getStudentId());

            int rowsUpdate = preparedStatement.executeUpdate();
            if (rowsUpdate > 0) {
                System.out.println("A student update successfully");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

}
