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
        long transferSize = 0;
        //проверяю все файлы по отдельности. если хоть один не пройдет - ошибка
        for(File f : storageFrom.getFiles())
            if(f != null) {
                storageTo.checkPutFile(f);
                transferSize += f.getSize(); //формирую общий размер трансфера
            }
        //проверяю размер трансфера. если не ок - ошибка
        if(transferSize > storageTo.getFreeStorageSize())
            throw new Exception("transfer fail. there is no enough free space in storage id:"+storageTo.getId());
        //если до сюда дошло - юзаю метод transferFile который перенесет файлы по очереди
        for (File f : storageFrom.getFiles())
            if (f != null)
                transferFile(storageFrom, storageTo, f.getId());
    }

    public void transferFile(Storage storageFrom, Storage storageTo, long id) throws Exception{
        put(storageTo, storageFrom.getFileById(id));
        delete(storageFrom, storageFrom.getFileById(id));
    }





}
