package lesson19.homework19_1;

public class Controller {

    public File put(Storage storage, File file) throws Exception{
        storage.checkPutFile(file);

        storage.addFile(file);
        return file;
    }

    public void delete(Storage storage, File file) throws Exception{
        storage.checkDeleteFile(file);

        storage.deleteFile(file);
    }

    public void transferAll(Storage storageFrom, Storage storageTo) throws Exception{
        for(File f : storageFrom.getFiles())
            if(f != null)
                storageTo.checkPutFile(f);

        for(File f : storageFrom.getFiles())
            if(f != null)
                transferFile(storageFrom, storageTo, f.getId());
    }

    public void transferFile(Storage storageFrom, Storage storageTo, long id) throws Exception{
        put(storageTo, storageFrom.getFileById(id));
        delete(storageFrom, storageFrom.getFileById(id));
    }





}
