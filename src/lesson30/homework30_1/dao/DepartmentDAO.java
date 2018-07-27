package lesson30.homework30_1.dao;

import lesson30.homework30_1.Department;
import lesson30.homework30_1.DepartmentType;

import java.util.HashSet;
import java.util.Set;

public class DepartmentDAO {

    private static Set<Department> departments = new HashSet<>();

    public void setDepartments(Department department) {
        departments.add(department);
    }

    public static Set<Department> getDepartments() {
        return departments;
    }

    public static Department getDepartmentByType(DepartmentType type){
        for(Department d : departments){
            if(d.getType().equals(type))
                return d;
        }
        return null;
    }
}
