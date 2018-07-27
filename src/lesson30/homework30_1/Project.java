package lesson30.homework30_1;


import java.util.Objects;

public class Project implements Comparable<Project>{
    private String name;
    private Customer customer;

    public Project(String name, Customer customer) {
        this.name = name;
        this.customer = customer;
    }

    public String getName() {
        return name;
    }

    public Customer getCustomer() {
        return customer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Project project = (Project) o;
        return Objects.equals(name, project.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "\nProject{" +
                "name='" + name + '\'' +
                ", customer=" + customer +
                '}';
    }

    @Override
    public int compareTo(Project p) {
        return this.name.compareTo(p.getName());
    }
}
