package lesson36.temp;

import lesson36.model.User;
import lesson36.model.types.UserType;

public class UserDAO {
    private static final String path = "src/lesson36/files/UserDb.txt";
    private lesson36.temp.GeneralDAO<User> generalDao = new lesson36.temp.GeneralDAO<>(path);

    public User registerUser(User user){
        return generalDao.writeToFile(new User(generalDao.randomId(), user.getUserName(), user.getPassword(), user.getCountry(), user.getUserType()));
    }

    public void login(String userName, String password) throws Exception{
    }

    public void logout(){
    }

    public User getUserById(long id) throws Exception{
        long index = 1;
        for(String line : generalDao.readFromFile()){
            User u = getValidUser(line, index++);
            if(u.getId() == id)
                return u;
        }
        throw new Exception("User id was not found");
    }

    private User getValidUser(String inputLine, long lineIndex) throws Exception{
        String[] userValues = inputLine.split(",");

        if(userValues.length != User.class.getDeclaredFields().length)
            throw new Exception("User data is not valid. Line: '"+inputLine+"'");

        try {
            return new User(
                    Long.valueOf(userValues[0]),
                    userValues[1].trim(),
                    userValues[2].trim(),
                    userValues[3].trim(),
                    UserType.getTypeByName(userValues[4])
            );
        }catch (Exception e){
            System.err.println("Can not read data. "+e.getMessage()+" Line: "+lineIndex);
        }
        return null;
    }





}
