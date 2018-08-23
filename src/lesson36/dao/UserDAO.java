package lesson36.dao;

import lesson36.exception.BadRequestException;
import lesson36.exception.UnexpectedException;
import lesson36.model.GeneralModel;
import lesson36.model.User;
import lesson36.model.types.UserType;

import java.util.LinkedHashMap;

public class UserDAO extends GeneralDAO<User>{
    private static final String path = "src/lesson36/files/UserDb.txt";
    private static User loggedUser = null;

    public UserDAO() {
        super(User.class, path);
    }

    public static User getLoggedUser() {
        return loggedUser;
    }

    public User registerUser(User user) throws UnexpectedException {
        return writeToFile(user);
    }

    public void login(String userName, String password) throws UnexpectedException {
        String[] data = getObjectByParameters(new LinkedHashMap<String, String>(){{
            put("userName", userName);
            put("password", password);
        }});
        if(data == null)
            throw  new UnexpectedException("User with name: "+userName+" was not found, or password is incorrect");

        loggedUser = parseToObject(data);
    }

    public void logout(){
        loggedUser = null;
    }

    public User getUserById(long id) throws UnexpectedException{
        String[] data = getObjectByParameters(new LinkedHashMap<String, String>(){{put("id", String.valueOf(id));}});
        if(data == null)
            return null;
        return parseToObject(data);
    }

    public User getUserByLoginAndPassword(String userName, String password) throws UnexpectedException {
        String[] data = getObjectByParameters(new LinkedHashMap<String, String>(){{
            put("userName", String.valueOf(userName)); put("password", String.valueOf(password));
        }});

        if(data == null)
            return null;
        return parseToObject(data);
    }

    public static void checkAuthorization() throws BadRequestException {
        if(loggedUser == null)
            throw new BadRequestException("Authorization error: You must be logged in system for perform this operation");
    }

    @Override
    public User parseStringToObject(String input){
        return new User().parseStringToObject(input);
    }
}
