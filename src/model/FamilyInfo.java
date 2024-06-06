package model;

public class FamilyInfo {

    private int familyId;
    private String fatherName;
    private String fatherPhone;
    private String motherName;
    private String motherPhone;

    public FamilyInfo(){

    }

    public FamilyInfo(int familyId, String fatherName, String fatherPhone, String motherName, String motherPhone) {
        this.familyId = familyId;
        this.fatherName = fatherName;
        this.fatherPhone = fatherPhone;
        this.motherName = motherName;
        this.motherPhone = motherPhone;
    }

    public int getFamilyId() {
        return familyId;
    }

    public void setFamilyId(int familyId) {
        this.familyId = familyId;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getFatherPhone() {
        return fatherPhone;
    }

    public void setFatherPhone(String fatherPhone) {
        this.fatherPhone = fatherPhone;
    }

    public String getMotherName() {
        return motherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    public String getMotherPhone() {
        return motherPhone;
    }

    public void setMotherPhone(String motherPhone) {
        this.motherPhone = motherPhone;
    }

}
