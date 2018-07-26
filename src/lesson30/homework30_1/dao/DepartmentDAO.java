package lesson30.homework30_1.dao;

import lesson30.homework30_1.Department;

import java.util.HashSet;
import java.util.Set;

public class DepartmentDAO {

    private static Set<Department> departments = new HashSet<>();

    public void setDepartments(Department department) {
        departments.add(department);
    }
}
