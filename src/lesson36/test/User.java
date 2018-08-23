package lesson36.test;

import lesson36.exception.BadRequestException;
import lesson36.model.types.UserType;

public class User extends GeneralModel<User> implements Comparable<User>{
    private long id;
    private String userName;
    private String password;
    private String country;
    private UserType userType;

    public User() {
    }

    public User(long id, String userName, String password, String country, UserType userType) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.country = country;
        this.userType = userType;
    }

    public User(String userName, String password, String country, UserType userType) {
        this.userName = userName;
        this.password = password;
        this.country = country;
        this.userType = userType;
    }

    public User(String textData) {
        String[] data = textData.split(",");
        try {
            id = Long.valueOf(data[0]);
            userName = data[1];
            password = data[2];
            country = data[3];
            userType = UserType.valueOf(data[4]);
        }catch (Exception e){
            throw new BadRequestException("Parsing "+getClass().getName()+" error");
        }
    }

    public long getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getCountry() {
        return country;
    }

    public UserType getUserType() {
        return userType;
    }

    @Override
    public int compareTo(User user) {
        return (int) (this.id-user.getId());
    }


    @Override
    public User parseStringToObject(String input) {
        String[] data = input.split(",");
            id = Long.valueOf(data[0]);
            userName = data[1];
            password = data[2];
            country = data[3];
            userType = UserType.valueOf(data[4]);
        return this;
    }

    @Override
    public String parseObjectToString(User user) {
        return null;
    }
}
