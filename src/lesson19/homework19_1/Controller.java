package lesson19.homework19_1;

public class Controller {
    public File put(Storage storage, File file) throws IllegalArgumentException, IndexOutOfBoundsException{
        if(storage == null || file == null)
            return null;

        try {
            storage.addFile(file);
            return file;
        } catch (IllegalArgumentException e){
            throw new IllegalArgumentException(errorMessage(file.getId(), storage.getId(), e.getMessage()));
        } catch (IndexOutOfBoundsException e){
            throw new IndexOutOfBoundsException(errorMessage(file.getId(), storage.getId(), e.getMessage()));
        }
    }

    public void delete(Storage storage, File file) throws IllegalArgumentException{
        if(storage == null)
            return;

        try {
            storage.deleteFile(file);
        } catch(IllegalArgumentException e){
            throw new IllegalArgumentException(errorMessage(file.getId(), storage.getId(), e.getMessage()));
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
            //try {
            put(storageTo, file);
            delete(storageFrom, file);
                //storageTo.addFile(file);
                //storageFrom.deleteFile(file);
            //} catch (IllegalArgumentException | IndexOutOfBoundsException e) {
                //System.err.println("Can not transfer file id:"+file.getId()+" to storage id:"+storageTo.getId()+". Reason: "+e.getMessage());
            //}
        } catch (IllegalArgumentException e){
            throw new IllegalArgumentException(errorMessage(file.getId(), storageTo.getId(), e.getMessage()));
        } //catch (IndexOutOfBoundsException e){
            //throw new IndexOutOfBoundsException(errorMessage(file.getId(), storageTo.getId(), e.getMessage()));
        //}
    }

    private String errorMessage(long fileId, long storageId, String errorMessage){
        return "Can not put file id:"+fileId+" to storage id:"+storageId+". Reason: "+errorMessage;
    }
}
