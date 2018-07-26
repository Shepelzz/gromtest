package lesson30.homework30_1.dao;

import lesson30.homework30_1.Employee;

import java.util.HashSet;
import java.util.Set;

public class EmployeeDAO {

    private static Set<Employee> employees = new HashSet<>();

    public void setEmployees(Employee employee) {
        employees.add(employee);
    }

    public Set<Employee> employeesByProject(String projectName){
        Set<Employee> result = new HashSet<>();

        for(Employee e : employees){
            if(e.getProjects().contains(projectName)){
                result.add(e);
            }
        }
        return new HashSet<>();
    }
}
