package lesson36.test;


import lesson36.exception.UnexpectedException;

import java.util.Set;

public class UserDAO extends GeneralDAO<User> {
    private static final String path = "src/lesson36/files/UserDb.txt";

    public UserDAO() {
        super(path);
    }

    Set<User> readFromFile() throws UnexpectedException {
        return super.readFromFile();
    }

    @Override
    public User parseStringToObject(String input){
        return new User().parseStringToObject(input);
    }

    @Override
    String parseObjectToString(User user) {
        return null;
    }
}
