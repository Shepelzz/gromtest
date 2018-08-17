package lesson36.demo;

import java.util.Calendar;
import java.util.Date;

public class DemoOrder {
    public static void main(String[] args) {
        Calendar c = Calendar.getInstance();
        Date d = new Date();
        c.setTime(d);
        c.add(Calendar.DATE, 3);

        System.out.println(c.getTime().toString());
    }
}
