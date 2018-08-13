package lesson36.repository;

import lesson36.model.User;
import lesson36.model.types.UserType;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ThreadLocalRandom;

public class UserRepository {
    private static final String path = "C:\\Users\\Zhenya Shepel\\Documents\\IDEA Projects\\Java_Courses\\files\\project\\UserDb.txt";
    private static User loggedUser = null;

    //считывание данных - считывание файла
    //обработка данных - маппинг данных

    public User registerUser(User user) throws Exception{
        validate();
        return saveUserToFile(new User(ThreadLocalRandom.current().nextLong(Long.MAX_VALUE), user.getUserName(), user.getPassword(), user.getCountry(), user.getUserType()));
    }

    public void login(String userName, String password) throws Exception{
        User user = getUserByNamePassword(userName, password);

        if(getUserByNamePassword(userName, password) == null)
            throw new Exception("User with name: "+userName+" not found or password is incorrect");
        loggedUser = user;
    }

    public void logout(){
        loggedUser = null;
    }


    private User saveUserToFile(User user){
        System.out.println("user "+user+" saved."); //TODO saving
        return user;
    }

    private User getUserByNamePassword(String name, String password) throws Exception{
        //TODO validate???
        for(User user : getDataFromFile())
            if(user.getUserName().equals(name) && user.getPassword().equals(password))
                return user;
        return null;
    }


    private Set<User> getDataFromFile() throws Exception{
        validate();

        Set<User> lines = new TreeSet<>();
        try(BufferedReader br = new BufferedReader(new FileReader(path))){
            String line;
            while ((line = br.readLine()) != null) {
                String[] lineElements = line.split(",");
                User user = new User(Long.valueOf(lineElements[0]), lineElements[1], lineElements[2], lineElements[3], UserType.getTypeByName(lineElements[4]));
                lines.add(user);
            }
        } catch (FileNotFoundException e){
            System.err.println("File "+path+" does not exist");
        } catch (IOException e){
            System.err.println("Reading from file "+path+" failed");
        }
        return lines;
    }

    private long getNextId(){
        return 1;
    }

    private void validate() throws Exception{
        try(BufferedReader br = new BufferedReader(new FileReader(path))){
            Set<Long> idList = new HashSet<>();
            String line;
            long lineId = 1;
            while ((line = br.readLine()) != null) {
                if(line.split(",").length != User.class.getDeclaredFields().length)
                    throw new Exception("UserDb: data is not valid. Line "+lineId+" Reason: '"+line+"'");

                if(!idList.add(Long.valueOf(line.split(",")[0])))
                    throw new Exception("UserDb: data is not valid. Line "+lineId+" Reason: id "+line.split(",")[0]+" duplicated");

                if(line.split(",")[1].trim().length() == 0)
                    throw new Exception("UserDb: data is not valid. Line "+lineId+" Reason: illegal name");

                if(line.split(",")[2].trim().length() == 0)
                    throw new Exception("UserDb: data is not valid. Line "+lineId+" Reason: illegal password");

                if(line.split(",")[3].trim().length() == 0)
                    throw new Exception("UserDb: data is not valid. Line "+lineId+" Reason: illegal country");

                if(UserType.getTypeByName(line.split(",")[4]) == null)
                    throw new Exception("UserDb: data is not valid. Line "+lineId+" Reason: illegal type");

                lineId++;
            }
        } catch (FileNotFoundException e){
            System.err.println("File "+path+" does not exist");
        } catch (IOException e){
            System.err.println("Reading from file "+path+" failed");
        }
    }


}
