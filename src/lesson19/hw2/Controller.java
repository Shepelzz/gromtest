package lesson19.hw2;

public class Controller {
    public File put(Storage storage, File file){
        storage.checkPutFile(file);

        storage.addFile(file);
        return file;
    }

    public void delete(Storage storage, File file){
        storage.checkDeleteFile(file);

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

        put(storageTo, storageFrom.getFileById(id));
        delete(storageFrom, storageFrom.getFileById(id));
    }





}
