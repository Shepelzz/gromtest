package lesson36.service;

import lesson36.dao.UserDAO;
import lesson36.exception.BadRequestException;
import lesson36.exception.UnexpectedException;
import lesson36.model.User;

public class UserService {

    private UserDAO userDAO = new UserDAO();

    public User registerUser(User user) throws BadRequestException, UnexpectedException {
        validate(user);
        return userDAO.registerUser(user);
    }

    public void login(String userName, String password) throws UnexpectedException{
        userDAO.login(userName, password);
    }

    public void logout(){
        userDAO.logout();
    }

    private void validate(User user) throws BadRequestException, UnexpectedException {
        if(userDAO.getUserByLoginAndPassword(user.getUserName(), user.getPassword()) != null)
            throw new BadRequestException("Validation error: User with user name: "+user.getUserName()+" is already registered.");

        if (user.getUserName() == null || user.getUserName().equals(""))
            throw new BadRequestException("Validation error: User register error: user name can not be empty");
        if (user.getPassword() == null || user.getPassword().equals(""))
            throw new BadRequestException("Validation error: User register error: user password can not be empty");
        if (user.getCountry() == null || user.getCountry().equals(""))
            throw new BadRequestException("Validation error: User register error: user country can not be empty");
    }
}
