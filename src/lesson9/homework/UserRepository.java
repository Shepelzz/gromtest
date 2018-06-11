package lesson9.homework;

public class UserRepository {
    private User[] users;

    public UserRepository(User[] users) {
        this.users = users;
    }

    public User[] getUsers() {
        return users;
    }

    public String[] getUserNames(){
        String[] userNamesList = new String[users.length];
        for(int i = 0; i < userNamesList.length; i++){
            if(users[i] != null)
                userNamesList[i] = users[i].getName();
        }
        return userNamesList;
    }

    public long[] getUserIds(){
        int idxCount = 0;
        for(User user : users){
            if(user != null)
                idxCount++;  //узнаю кол-во эл-тов не null
        }

        long[] idsList = new long[idxCount];

        for(User user : users){
            for(int i = 0; i < idsList.length; i++){
                if(idsList[i] == 0 && user != null){
                    idsList[i] = user.getId();
                    break;
                }
            }
        }
        return idsList;
    }

    public String getUserNameById(long id){
        String userName = null;
        for(User user : users){
            if(user != null && user.getId() == id) {
                return user.getName();
            }
        }
        return userName;
    }

    public User getUserByName(String name){
        User result = null;

        for(User user : users){
            if( user != null && user.getName() == name){
                result = user;
                break;
            }
        }
        return result;
    }

    public User getUserById(long id){
        User result = null;

        for(User user : users){
            if( user != null && user.getId() == id){
                result = user;
                break;
            }
        }
        return result;
    }

    public User getUserBySessionId(String session){
        User result = null;

        for(User user : users){
            if( user != null && user.getSessionId() == session){
                result = user;
                break;
            }
        }
        return result;
    }

    private User findById(long id){
        User result = null;

        for(User user : users){
            if( user != null && user.getId() == id){
                result = user;
                break;
            }
        }
        return result;
    }

    public User save(User user){
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

    public User update(User user){
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

    public void delete(long id){
        for(int i = 0; i < users.length; i++){
            if(users[i] != null && users[i].getId() == id){
                users[i] = null;
                break;
            }
        }
    }

}
