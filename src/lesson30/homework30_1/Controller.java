package lesson30.homework30_1;

import lesson30.homework30_1.dao.CustomerDAO;
import lesson30.homework30_1.dao.DepartmentDAO;
import lesson30.homework30_1.dao.EmployeeDAO;
import lesson30.homework30_1.dao.ProjectDAO;

import java.util.HashSet;
import java.util.Set;

public class Controller {
    EmployeeDAO employeeDAO = new EmployeeDAO();
    CustomerDAO customerDAO = new CustomerDAO();
    DepartmentDAO departmentDAO = new DepartmentDAO();
    ProjectDAO projectDAO = new ProjectDAO();

    public Set<Employee> employeesByProject(String projectName){
        return employeeDAO.employeesByProject(projectName);
    }

    public Set<Project> projectsByEmployee(Employee employee){
        return new HashSet<>();
    }

    public Set<Employee> employeesByDepartmentWithoutProject(DepartmentType departmentType){
        return new HashSet<>();
    }

    public Set<Employee> employeesWithoutProject(){
        return new HashSet<>();
    }

    public Set<Employee> projectsByTeamLead(Employee lead){
        return new HashSet<>();
    }

    public Set<Employee> teamLeadsByEmployee(Employee employee){
        return new HashSet<>();
    }

    public Set<Employee> employeesByProjectEmployee(Employee employee){
        return new HashSet<>();
    }

    public Set<Project> projectsByCustomer(Customer customer){
        return new HashSet<>();
    }

    public Set<Employee> employeesByCustomerProjects(Customer customer){
        return new HashSet<>();
    }

}
