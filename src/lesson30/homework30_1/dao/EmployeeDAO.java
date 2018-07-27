package lesson30.homework30_1.dao;

import lesson30.homework30_1.*;

import java.util.HashSet;
import java.util.Set;

public class EmployeeDAO {

    private static Set<Employee> employees = new HashSet<>();

    public void setEmployees(Employee employee) {
        employees.add(employee);
    }

    public static Set<Employee> getEmployees() {
        return employees;
    }

    public static Employee getEmployeeByName(String firstName, String lastName){
        for(Employee e : employees){
            if(e.getFirstName().equals(firstName) && e.getLastname().equals(lastName))
                return e;
        }
        return null;
    }

}
