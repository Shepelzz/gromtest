package lesson36.demo;

import java.util.concurrent.ThreadLocalRandom;

public class DemoUser {
    public static void main(String[] args) throws Exception{
//        UserController userController= new UserController();
//
//        try {
//            User user1 = new User("1", "Pass", "UA", UserType.ADMIN);
//            System.out.println(userController.registerUser(user1));
//        } catch(Exception e){
//            System.err.println(e.getMessage());
//        }




        System.out.println(ThreadLocalRandom.current().nextLong(Long.MAX_VALUE));
    }
}
