package lesson36.dao;

import lesson36.exception.DAOException;
import lesson36.exception.ObjectNotFoundException;
import lesson36.model.User;
import lesson36.model.types.UserType;

import java.util.LinkedHashMap;

public class UserDAO extends GeneralDAO<User>{
    private static final String path = "src/lesson36/files/UserDb.txt";
    private static User loggedUser = null;

    public static User getLoggedUser() {
        return loggedUser;
    }

    public User registerUser(User user) throws DAOException {
        return writeToFile(user, path);
    }

    public void login(String userName, String password) throws DAOException{
        String[] data = getObjectByParameters(new LinkedHashMap<String, String>(){{
            put("userName", userName);
            put("password", password);
        }}, User.class, path);
        if(data == null)
            throw  new DAOException("User with name: "+userName+" was not found, or password is incorrect");

        loggedUser = parseToObject(data);
    }

    public void logout(){
        loggedUser = null;
    }

    public User getUserById(long id) throws DAOException{
        String[] data = getObjectByParameters(new LinkedHashMap<String, String>(){{put("id", String.valueOf(id));}}, User.class, path);
        if(data == null)
            throw new ObjectNotFoundException("User with id: "+id+" was not found");
        return parseToObject(data);
    }

    public User getUserByLoginAndPassword(String userName, String password) throws DAOException {
        String[] data = getObjectByParameters(new LinkedHashMap<String, String>(){{
            put("userName", String.valueOf(userName)); put("password", String.valueOf(password));
        }}, User.class, path);

        if(data == null)
            throw new ObjectNotFoundException("User with name: "+userName+" was not found, or password is incorrect");
        return parseToObject(data);
    }

    public static void checkAuthorization() throws ObjectNotFoundException {
        if(loggedUser == null)
            throw new ObjectNotFoundException("Authorization error: You must be logged in system for perform this operation");
    }

    private User parseToObject(String[] input) throws DAOException {
        try{
            return new User(
                Long.valueOf(input[0]),
                input[1],
                input[2],
                input[3],
                UserType.getTypeByName(input[4])
            );
        }catch (Exception e){
            throw new DAOException(e.getMessage());
        }
    }
}
