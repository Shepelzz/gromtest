package lesson8.hw8_2;

import java.util.Date;

public class Demo {
    Course course = new Course(new Date(), "first", 50, "Danny", null);

    Student createHighestParent(){
        Student student = new Student("A", "B", 1, null);

        course.students = new Student[] {student};
        student.coursesTaken = new Course[] {course};

        return student;
    }

    SpecialStudent createLowestChild(){
        SpecialStudent specStudent = new SpecialStudent("A", "C", 2, null, 3434, "gg@g");
        course.students = new Student[] {specStudent};
        specStudent.coursesTaken = new Course[] {course};

        return specStudent;
    }
}
