package lesson36.temp;

import lesson36.dao.UserDAO;
import lesson36.model.User;

public class UserService {

    private UserDAO userDAO = new UserDAO();

    public User registerUser(User user) throws Exception{
        validate(user);
        return userDAO.registerUser(user);
    }

    public void login(String userName, String password){

    }

    public void logout(){

    }

    private void validate(User user) throws Exception{
        if(user.getUserName() == null || user.getUserName().equals(""))
            throw new Exception("UserService. User register error: user name can not be empty");
        if(user.getPassword() == null || user.getPassword().equals(""))
            throw new Exception("UserService. User register error: user password can not be empty");
        if(user.getCountry() == null || user.getCountry().equals(""))
            throw new Exception("UserService. User register error: user country can not be empty");
        if(user.getUserType() == null)
            throw new Exception("UserService. User register error: invalid user type");
    }

}
