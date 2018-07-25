package lesson30.homework30_1;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Department {
    private DepartmentType type;
    private Set<Employee> employees = new HashSet<>();

    public Department(DepartmentType type) {
        this.type = type;
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public DepartmentType getType() {
        return type;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return type == that.type;
    }

    @Override
    public int hashCode() {

        return Objects.hash(type);
    }

    @Override
    public String toString() {
        return "Department{" +
                "type=" + type +
                '}';
    }
}
