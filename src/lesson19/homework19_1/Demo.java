package lesson19.homework19_1;

public class Demo {
    public static void main(String[] args) {

        Storage storage1 = new Storage(0001, new File[4], new String[]{".txt", ".xls", ".dvd"},"Ukraine",12000);;
        Storage storage2 = new Storage(0002, new File[3], new String[]{".txt", ".xls", ".pdf"},"Ukraine",7700);

        Controller controller = new Controller();


        try{
            File f1 = new File(1, "qwertyuhdlfjsn", ".txt", 9);
            controller.put(storage1, f1);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        try{
            File f2 = new File(2, "file2", ".txt", 2);
            controller.put(storage1, f2);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        try{
            File f3 = new File(3, "file3", ".txt", 617);
            controller.put(storage1, f3);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        try{
            File f4 = new File(4, "file4", ".xls", 7000);
            controller.put(storage1, f4);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        try{
            File f5 = new File(5, "file5", ".dvd", 15000);
            controller.put(storage1, f5);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        try{
            File f6 = new File(6, "file6", ".xls", 30);
            controller.put(storage1, f6);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        System.out.println("storage1: "+storage1.getStorageInfo()+" storage2:"+storage2.getStorageInfo());

        try{
            controller.transferAll(storage1, storage2);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        System.out.println("storage1: "+storage1.getStorageInfo()+" storage2:"+storage2.getStorageInfo());

        try{
            controller.transferFile(storage2, storage1, 2);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        try{
            controller.transferFile(storage1, storage2, 4);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        try{
            File f4 = new File(4, "file4", ".xls", 7000);
            controller.delete(storage1, f4);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        System.out.println("storage1: "+storage1.getStorageInfo()+" storage2:"+storage2.getStorageInfo());

        try{
            File f4 = new File(4, "file4", ".xls", 7000);
            controller.delete(storage1, f4);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        try{
            File f6 = new File(6, "file6", ".xls", 7000);
            controller.delete(storage1, f6);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        try{
            controller.transferAll(storage1, storage2);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        System.out.println("storage1: "+storage1.getStorageInfo()+" storage2:"+storage2.getStorageInfo());

        try{
            File f6 = new File(3, "file3", ".xls", 7000);
            controller.delete(storage2, f6);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        try{
            File f1 = new File(1, "file1", ".pdf", 9);
            controller.put(storage2, f1);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        System.out.println("storage1: "+storage1.getStorageInfo()+" storage2:"+storage2.getStorageInfo());

        try{
            controller.transferAll(storage2, storage1);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        System.out.println("storage1: "+storage1.getStorageInfo()+" storage2:"+storage2.getStorageInfo());



        //test();

    }

    public static void test(){
        /*
        File f1 = new File(1, "qwertyuhdlfjsn", ".txt", 9);
        File f2 = new File(2, "file2", ".txt", 2);
        File f3 = new File(3, "file3", ".dvd", 5617);
        File f4 = new File(4, "file4", ".xls", 7000);
        File f5 = new File(5, "file5", ".txt", 1);
        File f6 = new File(6, "file3", ".iso", 5);
        File f7 = new File(7, "file7", ".xls", 12);
        File f8 = new File(8, "file8", ".xls", 6000);
        File f9 = new File(8, "file8", ".xls", 18);

        Storage storage1;
        Storage storage2;

        Controller controller = new Controller();

        // method put
        System.out.println("\nmethod put test:");

        //1. file name > 10
        System.out.print("1. file name > 10: ");
        storage1 = new Storage(0001, new File[4], new String[]{".txt", ".xls", "dvd"},"Ukraine",12000);
        try {controller.put(storage1, f1);}catch(Exception e){}

        //2. file format not supported
        System.out.print("2. file format not supported: ");
        storage1 = new Storage(0001, new File[4], new String[]{".txt", ".xls", "dvd"},"Ukraine",12000);
        try {controller.put(storage1, f6);}catch(Exception e){}

        //3. file is null
        System.out.print("3. file is null: ");
        storage1 = new Storage(0001, new File[4], new String[]{".txt", ".xls", "dvd"},"Ukraine",12000);
        try {controller.put(storage1, null);}catch(Exception e){}
        System.out.println();

        //4. storage is full
        System.out.print("4. storage is full: ");
        storage1 = new Storage(0001, new File[4], new String[]{".txt", ".xls", "dvd"},"Ukraine",10000);
        try {controller.put(storage1, f8);}catch(Exception e){}
        try {controller.put(storage1, f4);}catch(Exception e){}

        //5. file exists
        System.out.print("5. file exists: ");
        storage1 = new Storage(0001, new File[4], new String[]{".txt", ".xls", "dvd"},"Ukraine",12000);
        try {controller.put(storage1, f2);}catch(Exception e){}
        try {controller.put(storage1, f2);}catch(Exception e){}

        // method delete
        System.out.println("\nmethod delete test:");

        //1. file not exists
        System.out.print("1. file not exists: ");
        storage1 = new Storage(0001, new File[4], new String[]{".txt", ".xls", "dvd"},"Ukraine",12000);
        try {controller.put(storage1, f8);}catch(Exception e){}
        controller.delete(storage1, f2);

        //2. file is null
        System.out.print("2. file is null: ");
        controller.delete(storage1, null);
        System.out.println();

        //method transfer all
        System.out.println("\nmethod transfer all test:");

        //1. storage 1 is empty
        System.out.print("1. file not exists: ");
        storage1 = new Storage(0001, new File[4], new String[]{".txt", ".xls", "dvd"},"Ukraine",12000);
        storage2 = new Storage(0002, new File[3], new String[]{".txt", ".xls"},"Ukraine",9000);
        controller.transferAll(storage1, storage2);
        System.out.println("storage1: "+storage1.getStorageInfo()+" storage2:"+storage2.getStorageInfo());

        //2. storage 2 is smaller than 1
        System.out.print("2. is smaller than 1: ");
        try {controller.put(storage1, f2);}catch(Exception e){}
        try {controller.put(storage1, f4);}catch(Exception e){}
        try {controller.put(storage1, f9);}catch(Exception e){}
        try {controller.put(storage1, f7);}catch(Exception e){}
        controller.transferAll(storage1, storage2);

        //3. null values in storage 1
        System.out.print("3. null values in storage 1: ");
        storage1 = new Storage(0001, new File[4], new String[]{".txt", ".xls", "dvd"},"Ukraine",12000);
        try {controller.put(storage1, f2);}catch(Exception e){}
        try {controller.put(storage1, f4);}catch(Exception e){}
        try {controller.put(storage1, f9);}catch(Exception e){}
        try {controller.put(storage1, f7);}catch(Exception e){}
        controller.delete(storage1, f4);
        storage2 = new Storage(0002, new File[3], new String[]{".txt", ".xls"},"Ukraine",9000);
        System.out.print("|before: storage1: "+storage1.getStorageInfo()+" storage2:"+storage2.getStorageInfo());
        controller.transferAll(storage1, storage2);
        System.out.print("|after: storage1: "+storage1.getStorageInfo()+" storage2:"+storage2.getStorageInfo());
        System.out.println();

        //method transferFile test
        System.out.println("\nmethod transferFile test:");

        //1. no file with such id
        System.out.print("1. no file with such id: ");
        storage1 = new Storage(0001, new File[2], new String[]{".txt", ".xls", "dvd"},"Ukraine",12000);
        storage2 = new Storage(0002, new File[3], new String[]{".txt", ".xls"},"Ukraine",9000);
        try {controller.put(storage1, f2);}catch(Exception e){}
        try {controller.put(storage1, f4);}catch(Exception e){}
        controller.transferFile(storage1, storage2, 8);

        //2. storage 2 is full
        System.out.print("2. storage 2 is full: ");
        try {controller.put(storage2, f2);}catch(Exception e){}
        try {controller.put(storage2, f5);}catch(Exception e){}
        try {controller.put(storage2, f7);}catch(Exception e){}
        controller.transferFile(storage1, storage2, 4);

        //3. file exists in storage2
        System.out.print("3. file exists in storage2: ");
        controller.delete(storage2, f7);
        controller.transferFile(storage1, storage2, 2);
*/
    }
}