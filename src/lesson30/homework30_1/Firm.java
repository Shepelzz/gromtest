package lesson30.homework30_1;


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Firm {
    private Date dateFounded;
    private Set<Department> departments = new HashSet<>();
    private Set<Customer> customers = new HashSet<>();

    public Firm(Date dateFounded) {
        this.dateFounded = dateFounded;
    }

    public void addDepartments(Department department) {
        departments.add(department);
    }

    public void addCustomers(Customer customer) {
        customers.add(customer);
    }

    public Date getDateFounded() {
        return dateFounded;
    }

    public Set<Department> getDepartments() {
        return departments;
    }

    public Set<Customer> getCustomers() {
        return customers;
    }

    @Override
    public String toString() {
        return "Firm{" +
                "dateFounded=" + dateFounded +
                '}';
    }
}
