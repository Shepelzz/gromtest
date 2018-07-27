package lesson30.homework30_1;

import lesson30.homework30_1.dao.DepartmentDAO;
import lesson30.homework30_1.dao.EmployeeDAO;
import lesson30.homework30_1.dao.ProjectDAO;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Controller {

    public Set<Employee> employeesByProject(String projectName){
        Set<Employee> result = new TreeSet<>();

        for(Employee e : EmployeeDAO.getEmployees()){
            if(e.getProjects().contains(ProjectDAO.getProjectByName(projectName))){
                result.add(e);
            }
        }

        return result;
    }

    public Set<Project> projectsByEmployee(Employee employee){
        if(!EmployeeDAO.getEmployees().contains(employee))
            return new HashSet<>();

        return employee.getProjects();
    }

    public Set<Employee> employeesByDepartmentWithoutProject(DepartmentType departmentType){
        Set<Employee> result = new TreeSet<>();

        for(Employee e : DepartmentDAO.getDepartmentByType(departmentType).getEmployees())
            if(e.getProjects().isEmpty())
                result.add(e);

        return result;
    }

    public Set<Employee> employeesWithoutProject(){
        Set<Employee> result = new TreeSet<>();

        for(Employee e : EmployeeDAO.getEmployees())
            if(e.getProjects().isEmpty())
                result.add(e);

        return result;
    }

    public Set<Employee> employeesByTeamLead(Employee lead){
        Set<Employee> result = new TreeSet<>();

        if(!EmployeeDAO.getEmployees().contains(lead))
            return result;

        if(lead.getPosition() != Position.TEAM_LEAD)
            return result;

        for(Project p : lead.getProjects())
            for(Employee e : EmployeeDAO.getEmployees())
                if(e.getProjects().contains(p))
                    result.add(e);

        result.remove(lead);
        return result;
    }

    public Set<Employee> teamLeadsByEmployee(Employee employee){
        Set<Employee> result = new TreeSet<>();

        if(!EmployeeDAO.getEmployees().contains(employee))
            return result;

        if(employee.getProjects().size() == 0)
            return result;

        for(Project p : employee.getProjects())
            for(Employee e : EmployeeDAO.getEmployees())
                if(e.getProjects().contains(p) && e.getPosition().equals(Position.TEAM_LEAD))
                    result.add(e);

        return result;
    }

    public Set<Employee> employeesByProjectEmployee(Employee employee){
        Set<Employee> result = new TreeSet<>();

        if(employee.getProjects().size() == 0)
            return result;

        for(Project p : employee.getProjects())
            for(Employee e : EmployeeDAO.getEmployees())
                if(!e.equals(employee) && e.getProjects().contains(p))
                    result.add(e);

        return result;
    }

    public Set<Project> projectsByCustomer(Customer customer){
        Set<Project> result = new TreeSet<>();

        for(Project p : ProjectDAO.getProjects())
            if(p.getCustomer().equals(customer))
                result.add(p);

        return result;
    }

    public Set<Employee> employeesByCustomerProjects(Customer customer){
        Set<Employee> result = new TreeSet<>();

        for(Project p : projectsByCustomer(customer))
            result.addAll(employeesByProject(p.getName()));

        return result;
    }
}
