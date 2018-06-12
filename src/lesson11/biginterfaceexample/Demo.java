package lesson11.biginterfaceexample;

public class Demo {
    public static void main(String[] args) {
        File file1 = new File("test","C:/user/home", "txt", 11);
        File file2 = new File("test","C:/user/home", "txt", 11);
        File file3 = new File("video","C:/user/home", "txt", 120);
        //File file4 = new File("test","C:/user/home", "txt", 11);
        File file5 = new File("myhome","C:/user/home", "jpg", 120);
        File file6 = new File(null,null, null, 120);

        File[] files = new File[]{file1, file2, file3, null, file5, file6};
        File[] files2 = new File[]{null, null, null, null};

        Storage storage = new Storage(files);
        Storage storage2 = new Storage(files2);

        FileReader fileReader = new FileReader();
        SimpleReader simpleReader = new SimpleReader();

        read(storage, fileReader);
        read(storage, simpleReader);

        //------------------------------------------------------------------------------------------
        //testing readFileFromStorage(Storage storage)
        //1. nullable parameters
        fileReader.readFileFromStorage(null);
        //2. file parameters nullable
        fileReader.readFileFromStorage(storage);
        //3. nullable files in storage
        fileReader.readFileFromStorage(storage2);
        //4. check simplereaders work
        System.out.println();
        read(storage, simpleReader);
        //5. check fileReaders work
        System.out.println();
        read(storage, fileReader);


        //testing read(Storage storage, Readable readable)
        //1. nullable parameters
        read(null, null);

    }

    private static void read(Storage storage, Readable readable){
        if(storage == null || readable == null)
            return;
        System.out.println("method is starting");
        readable.readFileFromStorage(storage);
    }
}
