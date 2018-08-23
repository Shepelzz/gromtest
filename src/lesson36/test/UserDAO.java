package lesson36.test;


public class UserDAO extends GeneralDAO<User> {
    private static final String path = "src/lesson36/files/UserDb.txt";

    public UserDAO() {
        super(path);
    }

    @Override
    public User parseStringToObject(String input){
        GeneralModel<User> user = new User();
        return user.parseStringToObject(input);
    }

    @Override
    String parseObjectToString(User user) {
        return null;
    }
}
