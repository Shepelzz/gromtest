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

    public File getFileById(long id) throws Exception{
        for(File file : files)
            if( file != null && file.getId() == id)
                return file;
        throw new Exception("file not found. file id:"+id+" storage id:"+getId());
    }

    public void checkPutFile(File file) throws Exception{
        checkFileIfExists(file);
        checkAvaliableSpaceForAdd(file);
        checkAvaliableCellsForAdd(file);
        checkFileFormat(file);
    }

    public void checkTransfer(Storage storageFrom) throws Exception{
        checkAvaliableSpaceForAdd(storageFrom);
        checkAvaliableCellsForAdd(storageFrom);
        for (File file : storageFrom.getFiles())
            if (file != null) {
                checkFileIfExists(file);
                checkFileFormat(file);
            }
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
            if (f != null && f.equals(file)) {
                files[index] = null;
                return;
            }
            index++;
        }
    }

    public void checkFileIfExists(File file)  throws Exception{
        try {
            if (getFileById(file.getId()).equals(file))
                throw new Exception("file already exists. file id:"+file.getId()+" storage id:"+getId());
        }catch (Exception e){}

        /*for(File f : files)
            if (f != null && f.equals(file))
                throw new Exception("file already exists. file id:"+file.getId()+" storage id:"+getId());*/
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

    private void checkAvaliableSpaceForAdd(Storage storage) throws Exception{
        if(storage.getUsedStorageSpace() > getStorageSize() - getUsedStorageSpace())
            throw new Exception("there is no enough space in storage id:"+getId());
    }


    private void checkAvaliableCellsForAdd(File file) throws Exception{
        if(file.getSize() > getStorageSize()-getUsedStorageSpace())
            throw new Exception("there is no enough space in storage id:"+getId());
    }

    private void checkFileFormat(File file) throws Exception{
        for(String format : getFormatsSupported())
            if(format.equals(file.getFormat()))
                return;
        throw new Exception("file format is not accepted. file id:"+file.getId()+" storage id:"+getId());
    }

    private void checkAvaliableCellsForAdd(Storage storage) throws Exception{
        if(storage.getUsedStorageCellsCount() > files.length - getUsedStorageCellsCount())
            throw new Exception("there is no enough space in storage id:"+getId());
    }

    private void checkAvaliableSpaceForAdd(File file) throws Exception{
        if(file.getSize() > getStorageSize()-getUsedStorageSpace())
            throw new Exception("file is too large. file id:"+file.getId()+" storage id:"+getId());
    }

    private long getUsedStorageSpace(){
        long filesSize = 0;
        for(File file : files)
            if(file != null)
                filesSize = filesSize+file.getSize();
        return filesSize;
    }

    private int getUsedStorageCellsCount(){
        int usedCells = 0;
        for(File f : files)
            if(f != null)
                usedCells++;
        return usedCells;
    }
}