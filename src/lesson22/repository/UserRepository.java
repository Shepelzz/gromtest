package lesson22.repository;

public class UserRepository {
    private static User[] users = new User[10];

    private static User findById(long id){
        for(User user : users)
            if( user != null && user.getId() == id)
                return user;
        return null;
    }

    public static User save(User user){
        if(user == null)
            return null;

        User result = null;
        if(findById(user.getId()) == null){
            for(int i = 0; i < users.length; i++){
                if(users[i] == null) {
                    users[i] = user;
                    result = user;
                    break;
                }
            }
        }
        return result;
    }

    public static User update(User user){
        if(user == null)
            return null;

        User result = null;
        for(int i = 0; i < users.length; i++){
            if(findById(user.getId()) != null && users[i].getId() == findById(user.getId()).getId()){
                users[i] = user;
                result = user;
                break;
            }
        }
        return result;
    }

    public static void delete(long id){
        for(int i = 0; i < users.length; i++){
            if(users[i] != null && users[i].getId() == id){
                users[i] = null;
                break;
            }
        }
    }

    public static User[] getUsers() {
        return users;
    }
}
