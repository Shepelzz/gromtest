package lesson36.model;

import lesson36.model.types.UserType;

public class User  implements Comparable<User>{
    private long id;
    private String userName;
    private String password;
    private String country;
    private UserType userType;

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
    public String toString() {
        return
                (id == 0 ? "" : id+",")+
                userName+","+
                password+","+
                country+","+
                userType.toString();
    }

    @Override
    public int compareTo(User user) {
        return (int) (this.id-user.getId());
    }
}
