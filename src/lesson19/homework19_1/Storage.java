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

    public long getUsedSize(){
        long usedSize = 0;
        for(File file : files)
            if(file != null)
                usedSize += file.getSize();
        return usedSize;
    }

    public int getUsedCells(){
        int usedCells = 0;
        for(File f : files)
            if(f != null)
                usedCells++;
        return usedCells;
    }

    public void checkPutFile(File file) throws Exception{
        checkAvailableSpace(file.getSize(), 1);
        checkFileIfExists(id);
        checkFileFormat(file.getId(), file.getFormat());
    }

    public void checkTransfer(File[] files, long size, int count) throws Exception{
        checkAvailableSpace(size, count);

        for (File file : files)
            if (file != null) {
                checkFileIfExists(file.getId());
                checkFileFormat(file.getId(), file.getFormat());
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

    public String getStorageInfo(){
        String info = "";
        for(File f : files)
            if(f == null)
                info = info.concat("[] ");
            else
                info = info.concat("["+f.getId()+"] ");
        return info;
    }

    private void checkFileIfExists(long fileId)  throws Exception{
        try {
            if (getFileById(fileId) != null)
                throw new Exception("file already exists. file id:"+fileId+" storage id:"+getId());
        }catch (Exception e){}
    }

    private void checkFileFormat(long fileId, String fileFormat) throws Exception{
        for(String format : getFormatsSupported())
            if(format.equals(fileFormat))
                return;
        throw new Exception("file format is not accepted. file id:"+fileId+" storage id:"+getId());
    }

    private void checkAvailableSpace(long Size, int Count) throws Exception{
        long freeSize = getStorageSize() - getUsedSize();
        int freeCells = getFiles().length - getUsedCells();
        if(Count > freeCells || Size > freeSize)
            throw new Exception("storage is full. storage id:"+getId());
    }
}