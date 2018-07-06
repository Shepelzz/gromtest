package lesson19.homework19_1;

public class Controller {

    public File put(Storage storage, File file) throws Exception{
        storage.checkFileIfExists(file);
        storage.checkCellsForAdd(1);
        storage.checkSpaceForAdd(file.getSize());
        storage.checkFileFormat(file);

        storage.addFile(file);
        return file;
    }

    public void delete(Storage storage, File file) throws Exception{
        storage.getFileById(file.getId());
        storage.deleteFile(file);
    }

    public void transferAll(Storage storageFrom, Storage storageTo) throws Exception{
        storageTo.checkSpaceForAdd(storageFrom.getUsedStorageSpace());
        storageTo.checkCellsForAdd(storageFrom.getUsedStorageCellsCount());
        for (File file : storageFrom.getFiles())
            if (file != null) {
                storageTo.checkFileIfExists(file);
                storageTo.checkFileFormat(file);
            }

        for (File file : storageFrom.getFiles())
            if (file != null) {
                storageTo.addFile(file);
                delete(storageFrom, file);
            }
    }

    public void transferFile(Storage storageFrom, Storage storageTo, long id) throws Exception{
        put(storageTo, storageFrom.getFileById(id));
        delete(storageFrom, storageFrom.getFileById(id));
    }
}