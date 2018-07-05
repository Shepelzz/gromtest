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

    public File getFileById(long id) throws Exception{
        for(File file : files){
            if( file != null && file.getId() == id){
                return file;
            }
        }
        throw new Exception("file not found. file id:"+id+" storage id:"+getId());
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

    public void checkPutFile(File file) throws Exception{
        checkFileIfExists(file);
        checkFileSize(file);
        checkFileFormat(file);
        checkFreeStorageCell(file);
    }

    public void checkPutFile(File[] files) throws Exception{
        long filesSize = 0;
        //проверяю все файлы по отдельности. если хоть один не пройдет - ошибка
        for(File file : files)
            if(file != null) {
                checkPutFile(file);
                filesSize += file.getSize(); //формирую общий размер трансфера
            }
        if(filesSize > getFreeStorageSize() || getFreeStorageCellsCount() < files.length)
            throw new Exception("there is no enough free space in storage id:"+getId());
    }

    public void checkDeleteFile(File file)  throws Exception{
        for(File f : files)
            if (f != null && f.equals(file) )
                return;
        throw new Exception("file not found. file id:"+file.getId()+" storage id:"+getId());
    }

    public long getFreeStorageSize(){
        long filesSize = 0;
        for(File file : files)
            if(file != null)
                filesSize = filesSize+file.getSize();

        return getStorageSize()-filesSize;
    }

    private void checkFileIfExists(File file)  throws Exception{
        for(File f : files)
            if (f != null && f.equals(file))
                throw new Exception("file already exists. file id:"+file.getId()+" storage id:"+getId());
    }

    private void checkFileSize(File file) throws Exception{
        if(file.getSize() > getFreeStorageSize())
            throw new Exception("file is too large. file id:"+file.getId()+" storage id:"+getId());
    }

    private void checkFileFormat(File file) throws Exception{
        for(String format : getFormatsSupported())
            if(format.equals(file.getFormat()))
                return;
        throw new Exception("file format is not accepted. file id:"+file.getId()+" storage id:"+getId());
    }

    private void checkFreeStorageCell(File file) throws Exception{
        if (getFreeStorageCellsCount() == 0)
            throw new Exception("storage is full. file id:"+file.getId()+" storage id:"+getId());
    }

    private int getFreeStorageCellsCount(){
        int freeCells = 0;
        for(File f : files)
            if(f == null)
                freeCells++;
        return freeCells;
    }
}
