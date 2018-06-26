package lesson19.homework19_1;

public class Storage {
    private long id;
    private File[] files;
    private String[] formatsSupported;
    private String storageCountry;
    private long storageSize;

    public Storage(long id, File[] files, String[] formatsSupported, String storageCountry, long storageSize) {
        this.id = id;
        this.files = files;
        this.formatsSupported = formatsSupported;
        this.storageCountry = storageCountry;
        this.storageSize = storageSize;
    }

    public long getId() {
        return id;
    }

    public File[] getFiles() {
        return files;
    }

    public String[] getFormatsSupported() {
        return formatsSupported;
    }

    public String getStorageCountry() {
        return storageCountry;
    }

    public long getStorageSize() {
        return storageSize;
    }


    public void addFile(File file) throws IndexOutOfBoundsException, IllegalArgumentException{
        if(checkFileIfExists(file))
            throw new IllegalArgumentException("file already exists");

        if(!checkFileSize(file))
            throw new IllegalArgumentException("file is too large");

        if(!checkFileFormat(file))
            throw new IllegalArgumentException("file format is not accepted");

        if(!checkFileName(file))
            throw new IllegalArgumentException("file name is too large");

        int index = 0;
        for(File f : files) {
            if (f == null){
                files[index] = file;
                return;
            }
            index++;
        }
        throw new IndexOutOfBoundsException("storage is full");
    }

    public void deleteFile(File file) throws IllegalArgumentException {
        int index = 0;
        for(File f : files) {
            if (f != null && f.equals(file) && f.hashCode() == file.hashCode()) {
                files[index] = null;
                return;
            }
            index++;
        }
        throw new IllegalArgumentException("file not found");
    }

    public File getFileById(long id) throws IllegalArgumentException{
        for(File file : files){
            if( file != null && file.getId() == id){
                return file;
            }
        }
        throw new IllegalArgumentException("there is no file with such id");
    }


    public String getStorageInfo(){
        String info = "";
        for(File f : files){
            if(f == null)
                info = info.concat("[] ");
            else
                info = info.concat("["+f.getId()+"] ");
        }
        return info;
    }

    private boolean checkFileIfExists(File file){
        for(File f : files)
            if (f != null && f.equals(file) && f.hashCode() == file.hashCode())
                return true;
        return false;
    }

    private boolean checkFileSize(File file){
        if(file.getSize() <= getFreeStorageSize())
            return true;
        return false;
    }

    private boolean checkFileFormat(File file){
        for(String format : formatsSupported)
            if(format.equals(file.getFormat()))
                return true;
         return false;
    }

    private boolean checkFileName(File file){
        if(file.getName().length() <= 10)
            return true;
        return false;
    }

    private long getFreeStorageSize(){
        long filesSize = 0;
        for(File file : files)
            if(file != null)
                filesSize = filesSize+file.getSize();

        return getStorageSize()-filesSize;
    }
}
