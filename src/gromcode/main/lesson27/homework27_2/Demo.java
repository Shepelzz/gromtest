package gromcode.main.lesson27.homework27_2;

import java.util.Date;

public class Demo {
    public static void main(String[] args) {
/*
        UserRepository userRepository = new UserRepository();

        userRepository.save(new User(1, "u1", "ses1"));
        userRepository.save(new User(2, "u2", "ses2"));
        userRepository.save(new User(3, "u3", "ses1"));
        userRepository.save(new User(4, "u4", "ses2"));
        System.out.println(Arrays.toString(userRepository.getUsers()));

        userRepository.update(new User(2, "u22", "ses2"));
        System.out.println(Arrays.toString(userRepository.getUsers()));

        userRepository.delete(2);
        System.out.println(Arrays.toString(userRepository.getUsers()));
*/
        testGetMethod();
    }

    private static void testGetMethod(){
        //arraylist
        UserRepository userRepository = new UserRepository();
        Date startAdd = new Date();
        for(int i = 0; i < 20000; i++){
            userRepository.save(new User(i, "user_"+i, "session_"+i));
        }
        Date finishAdd = new Date();
        long addTime = finishAdd.getTime() - startAdd.getTime();
        System.out.println("ArrayList add: "+addTime);


        Date startGet = new Date();
        userRepository.getUsers();
        Date finishGet = new Date();
        long getTime = finishGet.getTime() - startGet.getTime();
        System.out.println("get - array list: "+ getTime);



        //linkedlist
        UserRepository2 userRepository2 = new UserRepository2();
        Date startAdd2 = new Date();
        for(int i = 0; i < 20000; i++){
            userRepository2.save(new User(i, "user_"+i, "session_"+i));
        }
        Date finishAdd2 = new Date();
        long addTime2 = finishAdd2.getTime() - startAdd2.getTime();
        System.out.println("LinkedList add: "+addTime2);


        Date startGet2 = new Date();
        userRepository2.getUsers();
        Date finishGet2 = new Date();
        long getTime2 = finishGet2.getTime() - startGet2.getTime();
        System.out.println("get - linked list: "+ getTime2);
    }
}