package lesson36.dao;

import lesson36.exception.DAOException;
import lesson36.model.User;
import lesson36.model.types.UserType;

import java.util.Set;

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
        String[] data = getDataById(id, path);
        if(data == null)
            return null;
        return parseToObjectHotel(getDataById(id, path));
    }

    private User parseToObjectHotel(String[] input) throws DAOException {
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
