package lesson30.homework30_1.dao;

import lesson30.homework30_1.Department;
import lesson30.homework30_1.DepartmentType;

import java.util.HashSet;
import java.util.Set;

public class DepartmentDAO {

    private Set<Department> departments = new HashSet<>();

    {
        Department department1 = new Department(DepartmentType.ANALYSTS);
        Department department2 = new Department(DepartmentType.DESIGNERS);
        Department department3 = new Department(DepartmentType.DEVELOPERS);
        Department department4 = new Department(DepartmentType.FINANCE);
        Department department5 = new Department(DepartmentType.MANAGEMENT);

        departments.add(department1);
        departments.add(department2);
        departments.add(department3);
        departments.add(department4);
        departments.add(department5);
    }


}
