package lesson19.homework19_1;

public class Controller {

    public File put(Storage storage, File file) throws Exception{
        storage.checkPutFile(file);

        storage.addFile(file);
        return file;
    }

    public void delete(Storage storage, File file) throws Exception{
        storage.getFileById(file.getId());

        storage.deleteFile(file);
    }

    public void transferAll(Storage storageFrom, Storage storageTo) throws Exception{
        storageTo.checkTransfer(storageFrom.getFiles(), storageFrom.getUsedSize(), storageFrom.getUsedCells());

        for (File file : storageFrom.getFiles())
            if (file != null) {
                storageTo.addFile(file);
                delete(storageFrom, file);
            }
    }

    public void transferFile(Storage storageFrom, Storage storageTo, long id) throws Exception{
        storageTo.checkPutFile(storageFrom.getFileById(id));

        storageTo.addFile(storageFrom.getFileById(id));
        storageFrom.deleteFile(storageFrom.getFileById(id));
    }
}