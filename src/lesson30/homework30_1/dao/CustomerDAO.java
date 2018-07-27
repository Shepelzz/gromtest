package lesson30.homework30_1.dao;

import lesson30.homework30_1.Customer;

import java.util.HashSet;
import java.util.Set;

public class CustomerDAO {

    private static Set<Customer> customers = new HashSet<>();

    public void setCustomers(Customer customer) {
        customers.add(customer);
    }

    public static Customer getCustomerByName(String name, String country){
        for(Customer c : customers){
            if(c.getName().equals(name) && c.getCountry().equals(country))
                return c;
        }
        return null;
    }
}
