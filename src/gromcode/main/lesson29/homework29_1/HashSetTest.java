package gromcode.main.lesson29.homework29_1;


import java.util.*;

public class HashSetTest {

    public Set<Order> useHashTest(){
        Set<Order> orders = new HashSet<>();

        Order order1 = new Order(1, 2, "USD", "item1", "1");
        Order order2 = new Order(2, 42, "USD", "item2", "1");
        Order order3 = new Order(3, 124, "USD", "item3", "1");
        Order order4 = new Order(4, 23, "USD", "item4", "1");
        Order order5 = new Order(5, 122, "USD", "item5", "1");

        //add
        System.out.println("\nadd 1,3,4,5:");
        orders.add(order1);
        orders.add(order3);
        orders.add(order4);
        orders.add(order5);
        print(orders.iterator());

        //remove
        System.out.println("\nremove 5:");
        orders.remove(order5);
        print(orders.iterator());

        //retainAll
        System.out.println("\nretainAll:");
        ArrayList<Order> list = new ArrayList<>();
        list.add(order1);
        list.add(order2);
        list.add(order3);

        orders.retainAll(list);
        print(orders.iterator());

        //toArray
        System.out.println("\ntoArray:");
        System.out.println(Arrays.toString(orders.toArray(new Order[3])));


        //size
        System.out.println("\nsize:");
        System.out.println("HashSet size: "+orders.size());
        System.out.println(Arrays.toString(orders.toArray(new Order[orders.size()])));


        Order order41 = new Order(41, 23, "USD", "item4", "1");
        Order order51 = new Order(51, 1232, "USD", "item5", "1");
        Order order61 = new Order(61, 122, "USD", "item5", "1");
        orders.add(order41);
        orders.add(order51);
        orders.add(order61);
        return orders;
    }

    private void print(Iterator<Order> iterator){
        while(iterator.hasNext()){
            System.out.print(iterator.next().getId()+" ");
        }
    }



}
