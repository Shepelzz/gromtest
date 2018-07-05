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

    public long getUsedStorageSpace(){
        long filesSize = 0;
        for(File file : files)
            if(file != null)
                filesSize = filesSize+file.getSize();
        return filesSize;
    }

    public long getFreeStorageSpace(){
        return getStorageSize() - getUsedStorageSpace();
    }

    public int getUsedStorageCellsCount(){
        int usedCells = 0;
        for(File f : files)
            if(f != null)
                usedCells++;
        return usedCells;
    }

    public int getFreeStorageCellsCount(){
        return files.length - getUsedStorageCellsCount();
    }

    public File getFileById(long id) throws Exception{
        for(File file : files)
            if( file != null && file.getId() == id)
                return file;
        throw new Exception("file not found. file id:"+id+" storage id:"+getId());
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

    public void checkSpaceForAdd(long size, int cells) throws Exception{
        if(size > getFreeStorageSpace() || cells > getFreeStorageCellsCount())
            throw new Exception("there is no enough space in storage id:"+getId());
    }

    public void checkFileIfExists(File file)  throws Exception{
        for(File f : files)
            if (f != null && f.equals(file))
                throw new Exception("file already exists. file id:"+file.getId()+" storage id:"+getId());
    }

    public void checkFileIfExists(File[] files) throws Exception{
        for(File file : files)
            if(file != null) {
                checkFileIfExists(file);
            }
    }

    public void checkFileFormat(File file) throws Exception{
        for(String format : getFormatsSupported())
            if(format.equals(file.getFormat()))
                return;
        throw new Exception("file format is not accepted. file id:"+file.getId()+" storage id:"+getId());
    }

    public void checkFileFormat(File[] files) throws Exception{
        for(File file : files)
            if(file != null) {
                checkFileFormat(file);
            }
    }

    public void checkFileSize(File file) throws Exception{
        if(file.getSize() > getFreeStorageSpace() || getFreeStorageCellsCount() == 0)
            throw new Exception("file is too large or storage is full. file id:"+file.getId()+" storage id:"+getId());
    }

    public String getStorageInfo(){
        String info = "";
        for(File f : files)
            if(f == null)
                info = info.concat("[] ");
            else
                info = info.concat("["+f.getId()+"] ");
        return info;
    }
}
