package lesson36.service;

import lesson36.exception.DAOException;
import lesson36.exception.ServiceException;
import lesson36.model.User;
import lesson36.dao.UserDAO;

public class UserService {

    private UserDAO userDAO = new UserDAO();

    public User registerUser(User user) throws DAOException, ServiceException {
        validate(user);
        return userDAO.registerUser(user);
    }

    public void login(String userName, String password){

    }

    public void logout(){

    }

    private void validate(User user) throws ServiceException{
        if(user.getUserName() == null || user.getUserName().equals(""))
            throw new ServiceException("UserService. User register error: user name can not be empty");
        if(user.getPassword() == null || user.getPassword().equals(""))
            throw new ServiceException("UserService. User register error: user password can not be empty");
        if(user.getCountry() == null || user.getCountry().equals(""))
            throw new ServiceException("UserService. User register error: user country can not be empty");
        if(user.getUserType() == null)
            throw new ServiceException("UserService. User register error: invalid user type");
    }

}
