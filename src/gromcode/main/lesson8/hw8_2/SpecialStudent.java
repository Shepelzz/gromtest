package gromcode.main.lesson8.hw8_2;

public class SpecialStudent extends CollegeStudent {
    long secretKey;
    String email;

    public SpecialStudent(String firstName, String lastName, int group, Course[] coursesTaken, long secretKey, String email) {
        super(firstName, lastName, group, coursesTaken);
        this.secretKey = secretKey;
        this.email = email;
    }
}
