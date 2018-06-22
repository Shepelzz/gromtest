package lesson18.exercise1;

public class Task {
    public static void main(String[] args) {
        FileStorage fileStorage = new FileStorage();

        fileStorage.setFiles(new String[]{"test1", "test2", "test3", "test4"});
        printer(fileStorage);
        printer2(fileStorage);

        fileStorage.setFiles(new String[]{"test1", "test2", "test3", "test4" ,"test5" ,"test6"});
        printer(fileStorage);
        printer2(fileStorage);

        fileStorage.setFiles(null);
        printer(fileStorage);
        printer2(fileStorage);

    }


    public static void printer(Storage storage) {
        String[] names = storage.getFiles();

        try {
            System.out.println("5th name is " + names[4]);
        } catch (Exception e){
            System.out.println("5th name can not be found...");
            //System.err.println(e.getMessage());
        }
    }

    //solution 2
    //HW
    public static void printer2(Storage storage) {
        String[] names = storage.getFiles();

        if(names == null || names.length < 5)
            System.out.println("5th name can not be found...");
        else
            System.out.println("5th name is " + names[4]);
    }
}
