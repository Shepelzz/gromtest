package lesson30.homework30_1;

import lesson30.homework30_1.dao.EmployeeDAO;
import lesson30.homework30_1.dao.ProjectDAO;

import java.util.Set;
import java.util.TreeSet;

public class Controller {

    public Set<Employee> employeesByProject(String projectName){
        Set<Employee> result = new TreeSet<>();

        for(Employee e : EmployeeDAO.getEmployees())
            for (Project p : e.getProjects())
                if(p.getName().equals(projectName)){
                    result.add(e);
                    break;
                }

        return result;
    }

    public Set<Project> projectsByEmployee(Employee employee){
        Set<Project> result = new TreeSet<>();

        for(Employee e : EmployeeDAO.getEmployees())
            if(e.equals(employee)){
                for(Project p : e.getProjects())
                    result.add(p);
                break;
            }

        return result;
    }

    public Set<Employee> employeesByDepartmentWithoutProject(DepartmentType departmentType){
        Set<Employee> result = new TreeSet<>();

        for(Employee e : EmployeeDAO.getEmployees())
            if(e.getDepartment().getType().equals(departmentType) && e.getProjects().size() == 0)
                result.add(e);

        return result;
    }

    public Set<Employee> employeesWithoutProject(){
        Set<Employee> result = new TreeSet<>();

        for(Employee e : EmployeeDAO.getEmployees())
            if(e.getProjects().size() == 0)
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
                if(e.getProjects().contains(p) && e.getPosition() != Position.TEAM_LEAD)
                    result.add(e);

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
            for(Employee e : employeesByProject(p.getName()))
                result.add(e);

        return result;
    }
}
