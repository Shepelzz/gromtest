package lesson25.homework25_1;

import java.util.Arrays;

public class Demo {
    public static void main(String[] args) {
        String string = "test";
        Integer integer = 90;
        Long aLong = 789L;

        GeneralDAO<String> generalDAO = new GeneralDAO<>();
        try {
            generalDAO.save(string);
            generalDAO.save(string);
            generalDAO.save(string);
            generalDAO.save(string);
            generalDAO.save(string);
            generalDAO.save(string);
        } catch(Exception e){
            System.out.println(e.getMessage());
        }

        GeneralDAO<Integer> generalDAOi = new GeneralDAO<>();
        try {
            generalDAOi.save(integer);
            generalDAOi.save(integer);
            generalDAOi.save(integer);
            generalDAOi.save(integer);
            generalDAOi.save(integer);
        } catch(Exception e){
            System.out.println(e.getMessage());
        }

        System.out.println(Arrays.toString(generalDAO.getAll()));
        System.out.println(Arrays.toString(generalDAOi.getAll()));
    }
}
