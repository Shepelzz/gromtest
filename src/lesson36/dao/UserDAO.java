package lesson36.dao;

import lesson36.model.User;

public class UserDAO {
    private static final String path = "src/lesson36/files/UserDb.txt";
    private DAO<User> dao = new DAO<>(path);

    //считывание данных - считывание файла
    //обработка данных - маппинг данных

    public User registerUser(User user){
        return dao.writeToFile(new User(dao.randomId(), user.getUserName(), user.getPassword(), user.getCountry(), user.getUserType()));
    }

    public void login(String userName, String password) throws Exception{
    }

    public void logout(){
    }




    /*

    private User getUserByNamePassword(String name, String password) throws Exception{
        //TODO validate???
        for(User user : getDataFromFile())
            if(user.getUserName().equals(name) && user.getPassword().equals(password))
                return user;
        return null;
    }


    public Set<User> getDataFromFile() throws Exception{
        //validate();

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
    */


}
