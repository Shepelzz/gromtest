package lesson36.dao;

import lesson36.exception.BadRequestException;
import lesson36.exception.UnexpectedException;
import lesson36.model.User;

import java.util.LinkedHashMap;
import java.util.Set;

public class UserDAO extends GeneralDAO<User>{
    private static final String path = "src/lesson36/files/UserDb.txt";

    public UserDAO() {
        super(User.class, path);
    }

    public Set<User> readFromFile() throws UnexpectedException {
        return super.readFromFile();
    }

    public User registerUser(User user) throws UnexpectedException {
        return writeToFile(user);
    }

    public User getUserById(long id) throws UnexpectedException{
        return getObjectByParameters(new LinkedHashMap<String, String>(){{put("id", String.valueOf(id));}});
    }

    public User getUserByLoginAndPassword(String userName, String password) throws UnexpectedException {
        return getObjectByParameters(new LinkedHashMap<String, String>(){{
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
}
