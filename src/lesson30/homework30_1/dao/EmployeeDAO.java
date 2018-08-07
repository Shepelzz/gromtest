package lesson30.homework30_1.dao;

import lesson30.homework30_1.*;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

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

    public static Set<Employee> employeesByProject(String projectName){
        Set<Employee> result = new TreeSet<>();

        for(Employee e : employees){
            if(e.getProjects().contains(ProjectDAO.getProjectByName(projectName))){
                result.add(e);
            }
        }

        return result;
    }

    public static Set<Employee> employeesByDepartmentWithoutProject(DepartmentType departmentType){
        Set<Employee> result = new TreeSet<>();

        for(Employee e : DepartmentDAO.getDepartmentByType(departmentType).getEmployees())
            if(e.getProjects().isEmpty())
                result.add(e);

        return result;
    }

    public static Set<Employee> employeesWithoutProject(){
        Set<Employee> result = new TreeSet<>();

        for(Employee e : employees)
            if(e.getProjects().isEmpty())
                result.add(e);

        return result;
    }

    public static Set<Employee> employeesByTeamLead(Employee lead){
        Set<Employee> result = new TreeSet<>();

        if(lead.getPosition() != Position.TEAM_LEAD)
            return result;

        for(Project p : lead.getProjects())
            for(Employee e : employees)
                if(e.getProjects().contains(p))
                    result.add(e);

        result.remove(lead);
        return result;
    }

    public static Set<Employee> teamLeadsByEmployee(Employee employee){
        Set<Employee> result = new TreeSet<>();

        if(employee.getProjects().isEmpty())
            return result;

        for(Project p : employee.getProjects())
            for(Employee e : employees)
                if(e.getProjects().contains(p) && e.getPosition().equals(Position.TEAM_LEAD))
                    result.add(e);

        return result;
    }

    public static Set<Employee> employeesByProjectEmployee(Employee employee){
        Set<Employee> result = new TreeSet<>();

        if(employee.getProjects().isEmpty())
            return result;

        for(Project p : employee.getProjects())
            for(Employee e : employees)
                if(!e.equals(employee) && e.getProjects().contains(p))
                    result.add(e);

        return result;
    }

    public static Set<Employee> employeesByCustomerProjects(Customer customer){
        Set<Employee> result = new TreeSet<>();

        for(Project p : ProjectDAO.projectsByCustomer(customer))
            result.addAll(employeesByProject(p.getName()));

        return result;
    }

}
