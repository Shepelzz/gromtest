package gromcode.main.lesson15.homework15_1;

import java.util.Arrays;

public class Demo {
    public static void main(String[] args) {
        User u1 = new User(1, "User1", "121212");
        User u2 = new User(4, "User2", "12143212");
        User u3 = new User(34, "User3", "1rfd21212");
        User u4 = new User(3, "User4", "121235h212");

        User[] userList = {u1, null, u3, u4};

        UserRepository rep = new UserRepository(userList);

        System.out.println(Arrays.toString(rep.getUserNames()));
        System.out.println(Arrays.toString(rep.getUserIds()));
        System.out.println(rep.save(u1));
/*
        System.out.println("save");
        User u5 = new User(9, "User5", "15212");
        rep.save(u5);
        System.out.println(Arrays.toString(rep.getUserNames()));

        System.out.println("update");
        User u6 = new User(4, "Updated user", "0000");
        System.out.println(rep.update(u6));
        System.out.println(Arrays.toString(rep.getUserNames()));

        System.out.println("delete");
        rep.delete(4);
        System.out.println(Arrays.toString(rep.getUserNames()));

        System.out.println("find");*/

/*
        //--------------------------------------------------------------------------------------
        System.out.println("\n\n-------------------------------------------------------------------------------------");
        //UserRepository test
        System.out.println("UserRepository test");
        //method String[] getUserNames()
        System.out.println("\nmethod String[] getUserNames()");
        //1.nullable users
        System.out.println("1. nullable users");
        System.out.println(Arrays.toString(new UserRepository(new User[]{null, null}).getUserNames()));
        //2.user name == null
        System.out.println(Arrays.toString(new UserRepository(new User[]{new User(7, null, "121235h212")}).getUserNames()));
        //3.similar user names
        System.out.println(Arrays.toString(new UserRepository(new User[]{
                new User(7, "A", "121235h212"),
                new User(7, "A", "121235h212")
        }).getUserNames()));

        //method long[] getUserIds()
        System.out.println("\nmethod long[] getUserIds()");
        //1.nullable users
        System.out.println("1. nullable users");
        System.out.println(Arrays.toString(new UserRepository(new User[]{null, null}).getUserIds()));

        //method String getUserNameById(long id)
        System.out.println("\nmethod String getUserNameById(long id)");
        //1.id not exists
        System.out.println("1.id not exists");
        System.out.println(rep.getUserNameById(67));
        //2.user name is null
        System.out.println("2.user name is null");
        u4 = new User(3, null, "121235h212");
        userList = new User[]{null, u2, null, u4};
        rep = new UserRepository(userList);
        System.out.println(rep.getUserNameById(3));

        //method User getUserByName(String name)
        System.out.println("\nmethod User getUserByName(String name)");
        //1.user not exists
        System.out.println("1.user not exists");
        System.out.println(rep.getUserByName("User22"));
        //2.name is null
        System.out.println("2.name is null");
        System.out.println(new UserRepository(new User[]{u1,u2, u3}).getUserByName(null));

        //method User findUser(User user)
        System.out.println("\nmethod User findUser(User user)");
        //1. user not exists
        System.out.println("1. user not exists");
        System.out.println(Arrays.toString(rep.getUserNames()));
        User uNew = new User(1, "User1", "121212");
        System.out.println(rep.findUser(u1));
        //2. user is null
        System.out.println("2. user is null");
        System.out.println(rep.findUser(null));

        //method User getUserBySessionId(String session)
        System.out.println("\nUser getUserBySessionId(String session)");
        //1.session not exists
        System.out.println("1.session not exists");
        System.out.println(rep.getUserBySessionId("345dfg"));
        //2. session null
        System.out.println("2. session null");
        System.out.println(rep.getUserBySessionId(null));


        //method User save(User user)
        System.out.println("\nmethod User save(User user)");
        //1. save null
        System.out.println("1. save null");
        System.out.println(Arrays.toString(rep.getUserNames()));
        System.out.println(rep.save(null));
        System.out.println(Arrays.toString(rep.getUserNames()));
        //2. save user with existing id
        System.out.println("2. save user with existing id");
        System.out.println(rep.save(new User(4, "User2", "12143212")));
        //3. overflow array
        System.out.println("3. overflow array");
        System.out.println(rep.save(new User(41, "User41", "1")));
        System.out.println(rep.save(new User(42, "User42", "2")));
        System.out.println(rep.save(new User(56, "User56", "3")));
        System.out.println(rep.save(new User(77, "User77", "4")));
        System.out.println(Arrays.toString(rep.getUserNames()));

        //User update(User user)
        System.out.println("\nUser update(User user)");
        //1. new user is null
        System.out.println(rep.update(null));

        //method delete(long id)
        System.out.println("\nmethod delete(long id)");
        //1. id not exists
        rep.delete(416);
        System.out.println(Arrays.toString(rep.getUserNames()));
*/
    }
}
