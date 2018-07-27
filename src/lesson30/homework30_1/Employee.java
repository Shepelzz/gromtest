package lesson30.homework30_1;

import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Employee implements Comparable<Employee>{
    private String firstName;
    private String lastname;
    private Date dateHired;
    private Position position;
    private Department department;
    private Set<Project> projects = new HashSet<>();

    public Employee(String firstName, String lastname, Date dateHired, Position position, Department department) {
        this.firstName = firstName;
        this.lastname = lastname;
        this.dateHired = dateHired;
        this.position = position;
        this.department = department;
    }

    public void addProjects(Project project) {
        projects.add(project);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastname() {
        return lastname;
    }

    public Date getDateHired() {
        return dateHired;
    }

    public Position getPosition() {
        return position;
    }

    public Department getDepartment() {
        return department;
    }

    public Set<Project> getProjects() {
        return projects;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(firstName, employee.firstName) &&
                Objects.equals(lastname, employee.lastname) &&
                Objects.equals(dateHired, employee.dateHired) &&
                position == employee.position &&
                Objects.equals(department, employee.department);
    }

    @Override
    public int hashCode() {

        return Objects.hash(firstName, lastname, dateHired, position, department);
    }

    @Override
    public String toString() {
        return "\nEmployee{" +
                "firstName='" + firstName + '\'' +
                ", lastname='" + lastname + '\'' +
                ", dateHired=" + dateHired +
                ", position=" + position +
                ", department=" + department +
                '}';
    }

    @Override
    public int compareTo(Employee e) {
        return this.firstName.concat(this.lastname).compareTo(e.getFirstName().concat(e.getLastname()));
    }
}
