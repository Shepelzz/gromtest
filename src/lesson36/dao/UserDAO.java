package lesson36.dao;

import lesson36.exception.UnexpectedException;
import lesson36.model.User;

public class UserDAO extends GeneralDAO<User>{
    private static final String path = "files/UserDb.txt";

    public UserDAO() throws UnexpectedException{
        super(path);
    }

    public User registerUser(User user) throws UnexpectedException {
        return writeToFile(user);
    }

    public User getUserByLoginAndPassword(String userName, String password) throws UnexpectedException {
        for(User user : getAll())
            if(user.getUserName().equals(userName) && user.getPassword().equals(password))
                return user;
        return null;
    }

    @Override
    public User parseStringToObject(String input) throws UnexpectedException {
        return new User(input);
    }
}
