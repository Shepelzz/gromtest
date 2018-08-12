package lesson36.repository;

import lesson36.model.User;

import java.util.HashSet;
import java.util.Set;

public class UserRepository {

    Set<User> users = new HashSet<>();


    //считывание данных - считывание файла
    //обработка данных - маппинг данных

    public User registerUser(User user){
        //save user to file

        return user;
    }

    public void login(String userName, String password){

    }

    public void logout(){

    }

}
