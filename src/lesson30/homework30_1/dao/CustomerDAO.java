package lesson30.homework30_1.dao;

import lesson30.homework30_1.Customer;

import java.util.HashSet;
import java.util.Set;

public class CustomerDAO {

    private static Set<Customer> customers = new HashSet<>();

    public void setCustomers(Customer customer) {
        customers.add(customer);
    }
}
