package lesson9.homework;

import java.util.Arrays;

public class Demo {
    public static void main(String[] args) {
        User u1 = new User(1, "User1", "121212");
        User u2 = new User(4, "User2", "12143212");
        User u3 = new User(34, "User3", "1rfd21212");
        User u4 = new User(3, "User4", "121235h212");

        User[] userList = {null, u2, null, u4};

        UserRepository rep = new UserRepository(userList);

        System.out.println(Arrays.toString(rep.getUserNames()));
        System.out.println(Arrays.toString(rep.getUserIds()));
        System.out.println(rep.getUserNameById(67));

        /*System.out.println(rep.getUserByName("User3").getName());
        System.out.println(rep.getUserById(2).getName());
        System.out.println(rep.getUserBySessionId("12143212").getName());*/

        User u5 = new User(9, "User5", "15212");
        rep.save(u5);
        System.out.println(Arrays.toString(rep.getUserNames()));

        User u6 = new User(9, "User9", "9999");
        rep.update(u6);
        System.out.println(Arrays.toString(rep.getUserNames()));

        rep.delete(4);
        System.out.println(Arrays.toString(rep.getUserNames()));

        rep.delete(4);
        System.out.println(Arrays.toString(rep.getUserNames()));
    }
}
