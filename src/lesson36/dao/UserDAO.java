package lesson36.dao;

import lesson36.exception.DAOException;
import lesson36.model.User;
import lesson36.model.types.UserType;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class UserDAO extends GeneralDAO<User>{
    private static final String path = "src/lesson36/files/UserDb.txt";

    public User registerUser(User user) throws DAOException {
        return writeToFile(user, path);
    }

    public void login(String userName, String password) throws Exception{
    }

    public void logout(){
    }

    public User getUserById(long id) throws DAOException{
        String[] data = getObjectByParameters(new LinkedHashMap<Integer, String>(){{put(0, String.valueOf(id));}}, path);
        if(data == null)
            throw  new DAOException("User with id:"+id+" was not found");
        return parseToObject(data);
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
