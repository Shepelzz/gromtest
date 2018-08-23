package lesson36.test;

public class Demo {
    public static void main(String[] args) throws Exception{

        UserDAO userDAO = new UserDAO();
        System.out.println(userDAO.readFromFile().toString());

    }
}
