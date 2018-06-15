package lesson13;

public class Demo {
    public static void main(String[] args) {

        testUserSave();
        testUserUpdate();
        testUserDelete();

        /*
        User u1 = new User(1, "User1", "121212");
        User u2 = new User(4, "User2", "12143212");

        User[] userList = {u1, u2, null, null};

        UserRepository userRepository = new UserRepository(userList);
        System.out.println(Arrays.toString(userRepository.getUsers()));

        User user = new User(1001, "Ann", "dfgdf");
        userRepository.save(user);
        System.out.println(Arrays.toString(userRepository.getUsers()));

        //сохранение юзера +
        //сохранение того же юзера +
        //когда нет места в массиве +
        //когда сохраняют null +

        int n = 15;
        while(n > 0){
            User user1 = new User(n, "Ann", "sdfsdf");
            System.out.println(userRepository.save(user1));
            n--;
        }

        System.out.println(Arrays.toString(userRepository.getUsers()));

        userRepository.save(null);

        //test update

        user = new User(1001, "Ann", "sdfgdfsgs");
        System.out.println(userRepository.update(user));
        System.out.println(Arrays.toString(userRepository.getUsers()));

        //обновление юзера +
        //когда нет юзера на обновление +
        //когда обновляем null

        user = new User(9999, "Ann", "sdfgdfsgs");
        System.out.println(userRepository.update(user));
        System.out.println(Arrays.toString(userRepository.getUsers()));

        System.out.println(userRepository.update(null));
        System.out.println(Arrays.toString(userRepository.getUsers()));
        */
    }


    private static void testUserSave(){
        for(int i = 1; i <= 4; i++) {
            userSaveCases(i);
        }
    }

    private static void testUserUpdate(){
        for(int i = 1; i <= 3; i++) {
            userUpdateCases(i);
        }
    }

    private static void testUserDelete(){
        for(int i = 1; i <= 2; i++) {
            userDeleteCases(i);
        }
    }

    private static void userSaveCases(int caseId) {
        switch (caseId) {
            case 1: {
                //save new user
                System.out.print("testUserSave - save new user:");
                UserRepository userRepository = new UserRepository(new User[]{
                        new User(1, "User1", "1111"),
                        new User(2, "User2", "2222"),
                        null
                });
                System.out.println(userRepository.save(new User(3, "User3", "3333")) != null ? " -Ok" : "FAIL!");
                break;
            }
            case 2: {
                //save null
                System.out.print("testUserSave - save null:");
                UserRepository userRepository = new UserRepository(new User[]{null});
                System.out.println(userRepository.save(null) == null ? " -Ok" : "FAIL!");
                break;
            }
            case 3: {
                //save user with existing id
                System.out.print("testUserSave - save user with existing id:");
                UserRepository userRepository = new UserRepository(new User[]{new User(1, "User1", "1111"), null});
                System.out.println(userRepository.save(new User(1, "User1", "1111")) == null ? " -Ok" : "FAIL!");
                break;
            }
            case 4: {
                //overflow array
                System.out.print("testUserSave - overflow array:");
                UserRepository userRepository = new UserRepository(new User[]{new User(1, "User1", "1111")});
                System.out.println(userRepository.save(new User(2, "User2", "2222")) == null ? " -Ok" : "FAIL!");
                break;
            }
        }
    }

    private static void userUpdateCases(int caseId) {
        switch (caseId) {
            case 1: {
                //update user
                System.out.print("testUserUpdate - update user:");
                UserRepository userRepository = new UserRepository(new User[]{
                        new User(1, "User1", "1111"),
                        new User(2, "User2", "2222")
                });
                System.out.println(userRepository.update(new User(1, "User3", "3333")).getName() == "User3" ? " -Ok" : "FAIL!");

                break;
            }
            case 2: {
                //update null
                System.out.print("testUserUpdate - update null:");
                UserRepository userRepository = new UserRepository(new User[]{
                        new User(1, "User1", "1111")
                });
                System.out.println(userRepository.update(null) == null ? " -Ok" : "FAIL!");
                break;
            }
            case 3: {
                //update user not exists
                System.out.print("testUserUpdate - user not exists:");
                UserRepository userRepository = new UserRepository(new User[]{
                        new User(1, "User1", "1111")
                });
                System.out.println(userRepository.update(new User(3, "User1", "1111")) == null ? " -Ok" : "FAIL!");
                break;
            }
        }
    }

    private static void userDeleteCases(int caseId){
        switch (caseId) {
            case 1: {
                //delete user
                System.out.print("testUserUpdate - delete user:");
                UserRepository userRepository = new UserRepository(new User[]{
                        new User(1, "User1", "1111"),
                        new User(2, "User2", "2222")
                });
                userRepository.delete(1);
                System.out.println(userRepository.getUserById(1) == null ? " -Ok" : "FAIL!");
                break;
            }
            case 2: {
                //delete ot existing id
                System.out.print("testUserUpdate - delete not existing id:");
                UserRepository userRepository = new UserRepository(new User[]{
                        new User(1, "User1", "1111")
                });
                System.out.println(userRepository.getUserById(1) != null ? " -Ok" : "FAIL!");
                break;
            }
        }
    }
}
