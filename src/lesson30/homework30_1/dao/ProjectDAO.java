package lesson30.homework30_1.dao;

import lesson30.homework30_1.Project;

import java.util.HashSet;
import java.util.Set;

public class ProjectDAO {

    private static Set<Project> projects = new HashSet<>();

    public void setProjects(Project project) {
        projects.add(project);
    }

    public static Set<Project> getProjects() {
        return projects;
    }
}
