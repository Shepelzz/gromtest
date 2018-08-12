package lesson36.service;

import lesson36.model.User;
import lesson36.repository.UserRepository;

public class UserService {

    private UserRepository userRepository = new UserRepository();

    public User registerUser(User user){
        //check business logic
            //поля обьектов не пустые
            //

        //if logic is ok
        userRepository.registerUser(user);


        return null;
    }

}
