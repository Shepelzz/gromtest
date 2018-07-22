package lesson27.homework27_2;

import java.util.Arrays;

public class Demo {
    public static void main(String[] args) {

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

    }
}