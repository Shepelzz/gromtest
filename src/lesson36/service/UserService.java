package lesson36.service;

import lesson36.exception.DAOException;
import lesson36.exception.ServiceException;
import lesson36.exception.ObjectNotFoundException;
import lesson36.model.User;
import lesson36.dao.UserDAO;

public class UserService {

    private UserDAO userDAO = new UserDAO();

    public User registerUser(User user) throws ServiceException {
        validate(user);
        try {
            return userDAO.registerUser(user);
        }catch (DAOException e){
            throw new ServiceException("Registration error: "+e.getMessage());
        }
    }

    public void login(String userName, String password) throws ServiceException{
        try {
            userDAO.login(userName, password);
        }catch (DAOException e){
            throw new ServiceException("Authorization error: "+e.getMessage());
        }
    }

    public void logout(){
        userDAO.logout();
    }

    private void validate(User user) throws ServiceException{
        try{
            userDAO.getUserByLoginAndPassword(user.getUserName(), user.getPassword());
        }catch (ObjectNotFoundException e) {

            if (user.getUserName() == null || user.getUserName().equals(""))
                throw new ServiceException("Validation error: User register error: user name can not be empty");
            if (user.getPassword() == null || user.getPassword().equals(""))
                throw new ServiceException("Validation error: User register error: user password can not be empty");
            if (user.getCountry() == null || user.getCountry().equals(""))
                throw new ServiceException("Validation error: User register error: user country can not be empty");
            return;

        }catch (DAOException e){
            throw new ServiceException("Validation error: "+e.getMessage());
        }
        throw new ServiceException("Validation error: User with user name: "+user.getUserName()+" is alreagy registered.");
    }
}
