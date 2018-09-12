package lesson36.model;

import lesson36.model.types.UserType;

public class User extends Entity{
    private String userName;
    private String password;
    private String country;
    private UserType userType;

    private User() {}

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
            (getId() == 0 ? "" : getId()+",")+
            userName+","+
            password+","+
            country+","+
            userType.toString();
    }

//    public static UserBuilder newUserBuilder(){
//        return new User().new UserBuilder();
//    }
//
//    public class UserBuilder {
//        private UserBuilder(){}
//
//        public UserBuilder setId(long id){
//            User.this.setId(id);
//            return this;
//        }
//
//        public UserBuilder setUserName(String userName) {
//            User.this.userName = userName;
//            return this;
//        }
//
//        public UserBuilder setPassword(String password) {
//            User.this.password = password;
//            return this;
//        }
//
//        public UserBuilder setCountry(String country) {
//            User.this.country = country;
//            return this;
//        }
//
//        public UserBuilder setUserType(UserType userType) {
//            User.this.userType = userType;
//            return this;
//        }
//
//        public UserBuilder parseStringToObject(String input) throws InternalServerError {
//            String[] data = input.split(",");
//            try {
//                setId(Long.valueOf(data[0]));
//                userName = data[1];
//                password = data[2];
//                country = data[3];
//                userType = UserType.valueOf(data[4]);
//                return this;
//            }catch (Exception e){
//                throw new InternalServerError(getClass().getName(), "parseStringToObject","error parsing text data ["+input+"]", e.getMessage());
//            }
//        }
//
//        public User build(){
//            return User.this;
//        }
//    }
}