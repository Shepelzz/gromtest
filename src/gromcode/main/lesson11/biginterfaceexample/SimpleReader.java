package gromcode.main.lesson11.biginterfaceexample;

public class SimpleReader implements Readable {

    @Override
    public void readFileFromStorage(Storage storage) {
        if (storage == null)
            return;
        for(File file : storage.getFiles()){
            if(file != null)
                System.out.println(file.getName());
            else
                System.out.println(file);
        }
    }
}
