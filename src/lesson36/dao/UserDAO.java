package lesson36.dao;

import lesson36.exception.UnexpectedException;
import lesson36.model.User;

import java.lang.reflect.Field;
import java.util.LinkedHashMap;

public class UserDAO extends GeneralDAO<User>{
    private static final String path = "src/lesson36/files/UserDb.txt";

    public UserDAO() {
        super(path);
    }

    public User registerUser(User user) throws UnexpectedException {
        return writeToFile(user);
    }

    public User getUserByLoginAndPassword(String userName, String password) throws UnexpectedException {
        return getEntityByParameters(new LinkedHashMap<String, String>(){{
            put("userName", String.valueOf(userName)); put("password", String.valueOf(password));
        }});
    }

    @Override
    public User parseStringToObject(String input) {
        return new User(input);
    }

    @Override
    public String parseObjectToString(User user) {
        return user.toString();
    }

    @Override
    public Field[] getDeclaredFields() {
        return User.class.getDeclaredFields();
    }
}
