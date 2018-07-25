package lesson30.homework30_1.dao;

import lesson30.homework30_1.Customer;

import java.util.HashSet;
import java.util.Set;

public class CustomerDAO {

    private Set<Customer> customers = new HashSet<>();

    {
        Customer customer1 = new Customer("Customer 1", "Ukraine", 500);
        Customer customer2 = new Customer("Customer 2", "USA", 2000);
        Customer customer3 = new Customer("Customer 3", "Ukraine", 2300);
        Customer customer4 = new Customer("Customer 4", "Ukraine", 5400);

        customers.add(customer1);
        customers.add(customer2);
        customers.add(customer3);
        customers.add(customer4);
    }
}
