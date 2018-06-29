package lesson19.homework19_1;

public class Controller {
    public File put(Storage storage, File file) throws Exception{
        if(storage == null || file == null)
            return null;

        try {
            storage.addFile(file);
            return file;
        } catch (IllegalArgumentException | IndexOutOfBoundsException e){
            throw new Exception(errorMessage(file.getId(), storage.getId(), e.getMessage()));
        }
    }

    public void delete(Storage storage, File file) {
        if(storage == null)
            return;

        try {
            storage.deleteFile(file);
        } catch(IllegalArgumentException e){
            System.err.println(errorMessage(file.getId(), storage.getId(), e.getMessage()));
        }
    }

    public void transferAll(Storage storageFrom, Storage storageTo){
        if(storageFrom == null || storageTo == null)
            return;

        for(File f : storageFrom.getFiles())
            if(f != null)
                transferFile(storageFrom, storageTo, f.getId());
    }

    public void transferFile(Storage storageFrom, Storage storageTo, long id){
        if(storageFrom == null || storageTo == null)
            return;

        File file = null;

        try {
            file = storageFrom.getFileById(id);
            try {
                storageTo.addFile(file);
                storageFrom.deleteFile(file);
            } catch (IllegalArgumentException | IndexOutOfBoundsException e) {
                System.err.println(errorMessage(file.getId(), storageTo.getId(), e.getMessage()));
            }
        } catch (IllegalArgumentException e){
            System.err.println(errorMessage(file.getId(), storageTo.getId(), e.getMessage()));
        }
    }

    private String errorMessage(long fileId, long storageId, String errorMessage){
        return "Can not put file id:"+fileId+" to storage id:"+storageId+". Reason: "+errorMessage;
    }
}
