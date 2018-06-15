package lesson9.homework;

import java.util.Arrays;

public class Demo {
    public static void main(String[] args) {

        testUserSave();
        testUserUpdate();
        testUserDelete();
        testGetUserNames();
        testGetUserIds();
        testGetUserNameById();
        testGetUserByName();
        testGetUserById();
        testGetUserBySessionId();

        /*User u1 = new User(1, "User1", "121212");
        User u2 = new User(4, "User2", "12143212");
        User u3 = new User(34, "User3", "1rfd21212");
        User u4 = new User(3, "User4", "121235h212");

        User[] userList = {null, u2, null, u4};

        UserRepository rep = new UserRepository(userList);

        System.out.println(Arrays.toString(rep.getUserNames()));
        System.out.println(Arrays.toString(rep.getUserIds()));
        System.out.println(rep.getUserNameById(67));

        User u5 = new User(9, "User5", "15212");
        rep.save(u5);
        System.out.println(Arrays.toString(rep.getUserNames()));

        User u6 = new User(9, "User9", "9999");
        rep.update(u6);
        System.out.println(Arrays.toString(rep.getUserNames()));

        rep.delete(4);
        System.out.println(Arrays.toString(rep.getUserNames()));

        rep.delete(4);
        System.out.println(Arrays.toString(rep.getUserNames()));*/

        //--------------------------------------------------------------------------------------

    }

    static void testUserSave() {
        {
            //save new user
            System.out.print("testUserSave - save new user:");
            UserRepository userRepository = new UserRepository(new User[]{
                    new User(1, "User1", "1111"),
                    new User(2, "User2", "2222"),
                    null
            });
            System.out.println(userRepository.save(new User(3, "User3", "3333")) != null ? " -Ok" : "FAIL!");
        }
        {
            //save null
            System.out.print("testUserSave - save null:");
            UserRepository userRepository = new UserRepository(new User[]{null});
            System.out.println(userRepository.save(null) == null ? " -Ok" : "FAIL!");
        }
        {
            //save user with existing id
            System.out.print("testUserSave - save user with existing id:");
            UserRepository userRepository = new UserRepository(new User[]{new User(1, "User1", "1111"), null});
            System.out.println(userRepository.save(new User(1, "User1", "1111")) == null ? " -Ok" : "FAIL!");
        }
        {
            //overflow array
            System.out.print("testUserSave - overflow array:");
            UserRepository userRepository = new UserRepository(new User[]{new User(1, "User1", "1111")});
            System.out.println(userRepository.save(new User(2, "User2", "2222")) == null ? " -Ok" : "FAIL!");
        }
    }

    static void testUserUpdate() {
        {
            //update user
            System.out.print("testUserUpdate - update user:");
            UserRepository userRepository = new UserRepository(new User[]{
                    new User(1, "User1", "1111"),
                    new User(2, "User2", "2222")
            });
            System.out.println(userRepository.update(new User(1, "User3", "3333")).getName() == "User3" ? " -Ok" : "FAIL!");
        }
        {
            //update null
            System.out.print("testUserUpdate - update null:");
            UserRepository userRepository = new UserRepository(new User[]{
                    new User(1, "User1", "1111")
            });
            System.out.println(userRepository.update(null) == null ? " -Ok" : "FAIL!");
        }
        {
            //update user not exists
            System.out.print("testUserUpdate - user not exists:");
            UserRepository userRepository = new UserRepository(new User[]{
                    new User(1, "User1", "1111")
            });
            System.out.println(userRepository.update(new User(3, "User1", "1111")) == null ? " -Ok" : "FAIL!");
        }
    }

    static void testUserDelete(){
        {
            //delete user
            System.out.print("testUserUpdate - delete user:");
            UserRepository userRepository = new UserRepository(new User[]{
                    new User(1, "User1", "1111"),
                    new User(2, "User2", "2222")
            });
            userRepository.delete(1);
            System.out.println(userRepository.getUserById(1) == null ? " -Ok" : "FAIL!");
        }
        {
            //delete ot existing id
            System.out.print("testUserUpdate - delete not existing id:");
            UserRepository userRepository = new UserRepository(new User[]{
                    new User(1, "User1", "1111")
            });
            System.out.println(userRepository.getUserById(1) != null ? " -Ok" : "FAIL!");
        }
    }

    static void testGetUserNames(){
        {
            //1.nullable users
            System.out.print("testGetUserNames - nullable users: ");
            System.out.println(Arrays.toString(new UserRepository(new User[]{null, null}).getUserNames()));
        }
        {
            //2.user name == null
            System.out.print("testGetUserNames - user name == null: ");
            System.out.println(Arrays.toString(new UserRepository(new User[]{new User(7, null, "121235h212")}).getUserNames()));
        }
        {
            //3.similar user names
            System.out.print("testGetUserNames - similar user names: ");
            System.out.println(Arrays.toString(new UserRepository(new User[]{
                    new User(7, "A", "121235h212"),
                    new User(7, "A", "121235h212")
            }).getUserNames()));
        }
    }

    static void testGetUserIds(){
        {
            //1.nullable users
            System.out.print("testGetUserIds - nullable users: ");
            System.out.println(Arrays.toString(new UserRepository(new User[]{null, null}).getUserIds()));
        }
    }

    static void testGetUserNameById(){
        {
            //1.id not exists
            System.out.print("testGetUserNameById - id not exists: ");
            System.out.println(new UserRepository(new User[]{
                    new User(2, "User2", "121235h212")
            }).getUserNameById(2));
        }
        {
            //2.user name is null
            System.out.print("testGetUserNameById - user name is null: ");
            System.out.println(new UserRepository(new User[]{
                    new User(2, "User2", "121235h212"),
                    null,
                    new User(4, null, "121235h212")
            }).getUserNameById(4));
        }
    }

    static void testGetUserByName(){
        {
            //1.user not exists
            System.out.print("testGetUserByName - user not exists: ");
            System.out.println(new UserRepository(new User[]{
                    new User(2, "User2", "121235h212")
            }).getUserByName("User3"));
        }
        {
            //2.name is null
            System.out.print("testGetUserByName - name is null: ");
            System.out.println(new UserRepository(new User[]{
                    new User(2, "User2", "121235h212"),
                    null
            }).getUserByName(null));
        }
    }

    static void testGetUserById(){
        {
            System.out.print("testGetUserById - id not exists: ");
            System.out.println(new UserRepository(new User[]{
                    new User(2, "User2", "121235h212"),
                    null
            }).getUserById(4));
        }
    }

    static void testGetUserBySessionId(){
        {
            System.out.print("testGetUserBySessionId - session not exists: ");
            System.out.println(new UserRepository(new User[]{
                    new User(2, "User2", "test"),
                    null
            }).getUserBySessionId("test"));
        }
        {
            System.out.print("testGetUserBySessionId - session is null: ");
            System.out.println(new UserRepository(new User[]{
                    new User(2, "User2", "121235h212"),
                    null
            }).getUserBySessionId(null));
        }
    }
}
