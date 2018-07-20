package lesson25.homework25_1;

import java.util.Arrays;

public class Demo {
    public static void main(String[] args) {
        String string1 = "test";
        String string2 = "test2";
        String string3 = "test3";
        String string4 = "test4";
        String string5 = "test5";
        String string6 = "test6";
        Integer integer1 = 1;
        Integer integer2 = 2;
        Integer integer3 = 3;
        Integer integer4 = 4;
        Integer integer5 = 5;
        Long aLong = 789L;

        GeneralDAO<String> generalDAO = new GeneralDAO<>();
        try {
            generalDAO.save(string1);
            generalDAO.save(string2);
            generalDAO.save(string3);
            generalDAO.save(string4);
            generalDAO.save(string4);
            generalDAO.save(string6);
        } catch(Exception e){
            System.out.println(e.getMessage());
        }

        GeneralDAO<Integer> generalDAOi = new GeneralDAO<>();
        try {
            generalDAOi.save(integer1);
            generalDAOi.save(integer2);
            generalDAOi.save(integer3);
            generalDAOi.save(integer4);
            generalDAOi.save(integer5);
        } catch(Exception e){
            System.out.println(e.getMessage());
        }

        System.out.println(Arrays.toString(generalDAO.getAll()));
        System.out.println(Arrays.toString(generalDAOi.getAll()));
    }
}
