package gromcode.main.lesson26.homework26_1;

import java.util.ArrayList;

public class ArrayListTest {

    public ArrayList<Order> useList(){
        ArrayList<Order> list = new ArrayList<>();

        //add
        list.add(new Order(1, 12, "USD", "item1", "1"));
        list.add(new Order(2, 5, "EUR", "item2", "6"));
        list.add(new Order(3, 670, "USD", "item3", "94"));
        System.out.println(list.toString());

        //add index
        list.add(1, new Order(4, 8900, "UAH", "item4", "555"));
        list.add(1, new Order(5, 45, "EUR", "item5", "1"));
        list.add(1, new Order(6, 1, "UAH", "item6", "1"));
        list.add(1, new Order(7, 66, "EUR", "item7", "5"));
        list.add(1, new Order(8, 9, "USD", "item8", "12"));
        System.out.println(list.toString());

        //remove
        list.remove(5);
        System.out.println(list.toString());

        //remove obj
        list.remove(new Order(1, 12, "USD", "item1", "1"));
        System.out.println(list.toString());

        //add all
        ArrayList<Order> list1 = new ArrayList<>();
        list1.add(new Order(11, 1, "USD", "item11", "1"));
        list1.add(new Order(12, 1, "EUR", "item12", "1"));
        list1.add(new Order(13, 1, "USD", "item13", "1"));
        list1.add(new Order(14, 1, "EUR", "item14", "1"));
        list1.add(new Order(15, 1, "USD", "item15", "1"));

        list.addAll(list1);
        System.out.println(list.toString());

        //sublist
        System.out.println(list.subList(1,4));

        //set
        list.set(0, new Order(100, 1000000, "USD", "item100", "9"));

        //contains
        System.out.println(list.contains(new Order(12, 1, "EUR", "item12", "1")));

        //toArray
        list.toArray(new Order[] {
                new Order(120, 100, "EUR", "item120", "1"),
                new Order(130, 100, "USD", "item130", "1")
        });
        System.out.println(list.toString());

        //clear
        list.clear();
        System.out.println(list.toString());

        list.addAll(list1);
        return list;
    }

}
