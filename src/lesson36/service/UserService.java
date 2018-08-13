package lesson36.service;

import lesson36.model.User;
import lesson36.repository.UserRepository;

public class UserService {

    private UserRepository userRepository = new UserRepository();

    public User registerUser(User user) throws Exception{
        userValidate(user);
        return userRepository.registerUser(user);
    }

    public void login(String userName, String password){

    }

    public void logout(){

    }

    private void userValidate(User user) throws Exception{
        if(user.getUserName() == null || user.getUserName().equals(""))
            throw new Exception("User name can not be empty");
        if(user.getPassword() == null || user.getPassword().equals(""))
            throw new Exception("User password can not be empty");
        if(user.getCountry() == null || user.getCountry().equals(""))
            throw new Exception("User country can not be empty");
        if(user.getUserType() == null)
            throw new Exception("User type can not be empty");
    }

}
