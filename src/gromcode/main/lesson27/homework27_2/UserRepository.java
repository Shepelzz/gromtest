package gromcode.main.lesson27.homework27_2;

import java.util.LinkedList;

public class UserRepository {
    public LinkedList<User> users = new LinkedList<>();

    public User save(User user){
        if(user == null)
            return null;

        if(findById(user.getId()) != null)
            return null;

        users.add(user);
        return user;
    }

    public User update(User user){
        if(user == null)
            return null;

        if(findById(user.getId()) == null)
            return null;

        int index = 0;
        for(User us : users) {
            if (us.getId() == user.getId()){
                users.set(index, user);
                return users.get(index);
            }
            index++;
        }
        return null;
    }

    public void delete(long id){
        if(findById(id) == null)
            return;

        int index = 0;
        for(User us : users) {
            if (us.getId() == id){
                users.remove(index);
                return;
            }
            index++;
        }
    }

    public User findById(long id){
        for(User user : users)
            if( user != null && user.getId() == id)
                return user;
        return null;
    }

    public User[] getUsers() {
        User[] result = new User[users.size()];

        int index = 0;
        for(User user : users){
            result[index] = user;
            index++;
        }
        return result;
    }
}
