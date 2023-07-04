package caseSecond;

public class Student {
    private String fullName;
    private String speciality;
    private Float grade;

    public Student(String fullName, String speciality, Float grade) {
        this.fullName = fullName;
        this.speciality = speciality;
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "\nStudent [fullName=" + fullName + ", speciality=" + speciality + ", grade=" + grade + "]";
    }

    public Float getGrade() {
        return grade;
    }

    public void setGrade(Float grade) {
        this.grade = grade;
    }
    
}
