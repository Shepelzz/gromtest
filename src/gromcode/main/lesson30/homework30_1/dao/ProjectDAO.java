package gromcode.main.lesson30.homework30_1.dao;

import gromcode.main.lesson30.homework30_1.Customer;
import gromcode.main.lesson30.homework30_1.Employee;
import gromcode.main.lesson30.homework30_1.Project;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class ProjectDAO {

    private static Set<Project> projects = new HashSet<>();

    public void setProjects(Project project) {
        projects.add(project);
    }

    public static Set<Project> getProjects() {
        return projects;
    }

    public static Project getProjectByName(String name){
        for(Project p : getProjects()){
            if(p.getName().equals(name))
                return p;
        }
        return null;
    }

    public static Set<Project> projectsByCustomer(Customer customer){
        Set<Project> result = new TreeSet<>();

        for(Project p : projects)
            if(p.getCustomer().equals(customer))
                result.add(p);

        return result;
    }

    public static Set<Project> projectsByEmployee(Employee employee){
        Set<Project> result = new TreeSet<>();

        result.addAll(employee.getProjects());
        return result;
    }
}
