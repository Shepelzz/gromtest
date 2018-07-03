package lesson19.hw2;

public class Controller {
    public File put(Storage storage, File file){
        checkPutFile(storage, file);

        storage.addFile(file);
        return file;
    }

    public void delete(Storage storage, File file){
        checkDeleteFile(storage, file);

        storage.deleteFile(file);
    }

    public void transferAll(Storage storageFrom, Storage storageTo){
        if(storageFrom == null || storageTo == null)
            return;

        for(File f : storageFrom.getFiles())
            if(f != null)
                transferFile(storageFrom, storageTo, f.getId());
    }

    public void transferFile(Storage storageFrom, Storage storageTo, long id){
        if(storageFrom.getFileById(id) == null)
            throw new RuntimeException("file not found. file id:"+id+" storage id:"+storageFrom.getId());

        File file = storageFrom.getFileById(id);

        put(storageTo, file);
        delete(storageFrom, file);
    }


    private void checkPutFile(Storage storage, File file){
        if(storage.checkFileIfExists(file))
            throw new RuntimeException("file already exists. file id:"+file.getId()+" storage id:"+storage.getId());

        if(!storage.checkFileSize(file))
            throw new RuntimeException("file is too large. file id:"+file.getId()+" storage id:"+storage.getId());

        if(!storage.checkFileFormat(file))
            throw new RuntimeException("file format is not accepted. file id:"+file.getId()+" storage id:"+storage.getId());

        if(!storage.checkFileName(file))
            throw new RuntimeException("file name is too large. file id:"+file.getId()+" storage id:"+storage.getId());

        if(storage.checkFreeStorageCell()==0)
            throw new RuntimeException("storage is full. file id:"+file.getId()+" storage id:"+storage.getId());
    }

    private void checkDeleteFile(Storage storage, File file){
        if(!storage.checkFileIfExists(file))
            throw new RuntimeException("file not found. file id:"+file.getId()+" storage id:"+storage.getId());
    }
}
