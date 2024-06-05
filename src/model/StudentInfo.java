package model;

public class StudentInfo {

    private int studentId;
    private String fullName;
    private String dayofBirth;
    private String address;
    private String gender;
    private String phone;
    private String email;

    public StudentInfo(){

    }

    public StudentInfo(int studentId, String fullName, String dayofBirth, String address, String gender, String phone, String email) {
        this.studentId = studentId;
        this.fullName = fullName;
        this.dayofBirth = dayofBirth;
        this.address = address;
        this.gender = gender;
        this.phone = phone;
        this.email = email;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getDayofBirth() {
        return dayofBirth;
    }

    public void setDayofBirth(String dayofBirth) {
        this.dayofBirth = dayofBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
