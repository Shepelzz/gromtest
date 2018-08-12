package gromcode.main.lesson28.homework28_1;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Demo {
    public static void main(String[] args) {

        System.out.println("\nFullComparator:");
        testFullComparator();
        System.out.println("\nDateCreatedComparator:");
        testDateCreatedComparator();
    }

    public static void testDateCreatedComparator(){
        Capability capability1 = new Capability(1001, "test", "nnnn", true, getDateFromParts(2018, 7, 22, 12, 23, 10));
        Capability capability2 = new Capability(1005, "fdf", "332", false, getDateFromParts(2018, 6, 1, 02, 33, 52));
        Capability capability3 = new Capability(900, "aaa", "aaaa", false, getDateFromParts(2018, 7, 22, 12, 23, 17));
        Capability capability4 = new Capability(1004, "aaa", "bbb", true, getDateFromParts(2018, 7, 22, 12, 23, 9));
        Capability capability5 = new Capability(1006, "aaa", "rrrr", false, getDateFromParts(2018, 7, 22, 12, 21, 10));

        ArrayList<Capability> capabilities = new ArrayList<>();
        capabilities.add(capability1);
        capabilities.add(capability2);
        capabilities.add(capability3);
        capabilities.add(capability4);
        capabilities.add(capability5);

        print(capabilities, "Capability before");
        capabilities.sort(new DateCreatedComparator());
        print(capabilities, "Capability after");
    }

    public static void testFullComparator(){
        Capability capability1 = new Capability(1001, "test", "nnnn", true, new Date());
        Capability capability2 = new Capability(1005, "fdf", "332", false, new Date());
        Capability capability3 = new Capability(900, "aaa", "aaaa", false, new Date());
        Capability capability4 = new Capability(1004, "aaa", "bbb", true, new Date());
        Capability capability5 = new Capability(1006, "aaa", "rrrr", false, new Date());
        Capability capability6 = new Capability(9007, "bbbb", "332", false, new Date());
        Capability capability7 = new Capability(1001, "test", "1", true, new Date());
        Capability capability8 = new Capability(1001, "test", "2", true, new Date());
        Capability capability9 = new Capability(1001, "test", "2", true, getDateFromParts(2018, 7, 22, 12, 23, 10));
        Capability capability10 = new Capability(1001, "test", "2", true, getDateFromParts(2018, 7, 22, 12, 23, 9));

        ArrayList<Capability> capabilities = new ArrayList<>();
        capabilities.add(capability1);
        capabilities.add(capability2);
        capabilities.add(capability3);
        capabilities.add(capability4);
        capabilities.add(capability5);
        capabilities.add(capability6);
        capabilities.add(capability7);
        capabilities.add(capability8);
        capabilities.add(capability9);
        capabilities.add(capability10);

        print(capabilities, "Capability before");
        capabilities.sort(new FullComparator());
        print(capabilities, "Capability after");
    }

    public static void print(ArrayList<Capability> capabilities, String caption){
        System.out.println(caption+": {");
        for(Capability c : capabilities){
            System.out.println("\t["+c.getChannelName()+" | "+c.getFingerPrint()+" | "+c.getDateCreated()+"]");
        }
        System.out.println("}");
    }

    private static Date getDateFromParts(int year, int month, int day, int hour, int minute, int second){
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month);
        cal.set(Calendar.DAY_OF_MONTH, day);
        cal.set(Calendar.HOUR_OF_DAY, hour);
        cal.set(Calendar.MINUTE, minute);
        cal.set(Calendar.SECOND, second);
        return cal.getTime();
    }
}
