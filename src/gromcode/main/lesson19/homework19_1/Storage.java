package gromcode.main.lesson19.homework19_1;

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
            if (f != null && f.equals(file)) {
                files[index] = null;
                return;
            }
            index++;
        }
    }

    public File getFileById(long id){
        for(File file : files)
            if( file != null && file.getId() == id)
                return file;
        return null;
    }

    public void checkPutFile(File file) throws Exception{
        checkAvailableSpace(file.getSize(), 1);
        if(getFileById(file.getId()) != null)
            throw new Exception("file already exists. file id:"+file.getId()+" storage id:"+getId());
        checkFileFormat(file.getId(), file.getFormat());
    }

    public void checkTransfer(File[] files) throws Exception{
        long filesSize = 0;
        int filesCount = 0;

        for(File file : files)
            if(file != null){
                filesSize += file.getSize();
                filesCount++;
            }

        checkAvailableSpace(filesSize, filesCount);

        for (File file : files)
            if (file != null) {
                if(getFileById(file.getId()) != null)
                    throw new Exception("file already exists. file id:"+file.getId()+" storage id:"+getId());
                checkFileFormat(file.getId(), file.getFormat());
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

/*    public void checkFileIfExists(long fileId) throws Exception{
        if(getFileById(fileId) != null)
            throw new Exception("file already exists. file id:"+fileId+" storage id:"+getId());
    }

    public void checkFileIfNotExists(long fileId) throws Exception{
        if(getFileById(fileId) == null)
            throw new Exception("file not found. file id:"+fileId+" storage id:"+getId());
    }*/

    private void checkFileFormat(long fileId, String fileFormat) throws Exception{
        for(String format : getFormatsSupported())
            if(format.equals(fileFormat))
                return;
        throw new Exception("file format is not accepted. file id:"+fileId+" storage id:"+getId());
    }

    private void checkAvailableSpace(long size, int count) throws Exception{
        long usedSize = 0;
        int usedCells = 0;
        for(File file : files)
            if(file != null) {
                usedSize += file.getSize();
                usedCells++;
            }

        if(count > getFiles().length - usedCells)
            throw new Exception("storage is full. storage id:"+getId());

        if(size > getStorageSize() - usedSize)
            throw new Exception("there is no free space. storage id:"+getId());
    }
}