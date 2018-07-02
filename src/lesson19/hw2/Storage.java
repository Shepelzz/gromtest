package lesson19.hw2;

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


    public void addFile(File file){
        int index = 0;
        for(File f : files) {
            if (f == null){
                files[index] = file;
                return;
            }
            index++;
        }
    }

    public void deleteFile(File file){
        int index = 0;
        for(File f : files) {
            if (f != null && f.equals(file) && f.hashCode() == file.hashCode()) {
                files[index] = null;
                return;
            }
            index++;
        }
    }

    public File getFileById(long id) throws IllegalArgumentException{
        for(File file : files){
            if( file != null && file.getId() == id){
                return file;
            }
        }
        return null;
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

    protected boolean checkFileIfExists(File file){
        for(File f : files)
            if (f != null && f.equals(file) && f.hashCode() == file.hashCode())
                return true;
        return false;
    }

    protected boolean checkFileSize(File file){
        if(file.getSize() <= getFreeStorageSize())
            return true;
        return false;
    }

    protected boolean checkFileFormat(File file){
        for(String format : getFormatsSupported())
            if(format.equals(file.getFormat()))
                return true;
         return false;
    }

    protected boolean checkFileName(File file){
        if(file.getName().length() <= 10)
            return true;
        return false;
    }

    protected int checkFreeStorageCell(){
        int freeCells = 0;
        for(File file : files)
            if(file == null)
                freeCells++;
        return freeCells;
    }

    private long getFreeStorageSize(){
        long filesSize = 0;
        for(File file : files)
            if(file != null)
                filesSize = filesSize+file.getSize();

        return getStorageSize()-filesSize;
    }


}
