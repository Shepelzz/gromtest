package lesson19.hw2;

public class Controller {
    public File put(Storage storage, File file) throws IllegalArgumentException, IndexOutOfBoundsException{

        if(storage.checkFileIfExists(file))
            throw new IllegalArgumentException("file already exists. file id:"+file.getId()+" storage id:"+storage.getId());

        if(!storage.checkFileSize(file))
            throw new IllegalArgumentException("file is too large. file id:"+file.getId()+" storage id:"+storage.getId());

        if(!storage.checkFileFormat(file))
            throw new IllegalArgumentException("file format is not accepted. file id:"+file.getId()+" storage id:"+storage.getId());

        if(!storage.checkFileName(file))
            throw new IllegalArgumentException("file name is too large. file id:"+file.getId()+" storage id:"+storage.getId());

        if(storage.checkFreeStorageCell()==0)
            throw new IndexOutOfBoundsException("storage is full. file id:"+file.getId()+" storage id:"+storage.getId());

        storage.addFile(file);
        return file;
    }

    public void delete(Storage storage, File file) throws IllegalArgumentException{
        if(!storage.checkFileIfExists(file))
            throw new IllegalArgumentException("file not found. file id:"+file.getId()+" storage id:"+storage.getId());

        storage.deleteFile(file);
    }

    public void transferAll(Storage storageFrom, Storage storageTo){
        if(storageFrom == null || storageTo == null)
            return;

        for(File f : storageFrom.getFiles())
            if(f != null)
                transferFile(storageFrom, storageTo, f.getId());
    }

    public void transferFile(Storage storageFrom, Storage storageTo, long id) throws IllegalArgumentException, IndexOutOfBoundsException{
        if(storageFrom.getFileById(id) == null)
            throw new IllegalArgumentException("file not found. file id:"+id+" storage id:"+storageFrom.getId());

        File file = storageFrom.getFileById(id);

        try{
            put(storageTo, file);
            delete(storageFrom, file);
        } catch (IllegalArgumentException | IndexOutOfBoundsException e){
            System.out.println(e.getMessage());
        }
    }
}
