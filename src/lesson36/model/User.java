package lesson36.model;

import lesson36.exception.UnexpectedException;
import lesson36.model.types.UserType;

public class User implements Entity{
    private long id;
    private String userName;
    private String password;
    private String country;
    private UserType userType;

    public User(String userName, String password, String country, UserType userType) {
        this.userName = userName;
        this.password = password;
        this.country = country;
        this.userType = userType;
    }

    public User(String textData) throws  UnexpectedException{
        String[] data = textData.split(",");
        try {
            id = Long.valueOf(data[0]);
            userName = data[1];
            password = data[2];
            country = data[3];
            userType = UserType.valueOf(data[4]);
        }catch (Exception e){
            throw new UnexpectedException(getClass().getName()+". Parsing. error parsing text data ["+textData+"]");
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

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return
                (id == 0 ? "" : id+",")+
                        userName+","+
                        password+","+
                        country+","+
                        userType.toString();
    }
}