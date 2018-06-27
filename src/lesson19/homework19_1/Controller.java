package lesson19.homework19_1;

public class Controller {
    public void put(Storage storage, File file){
        if(storage == null || file == null)
            return;

        try {
            storage.addFile(file);
        } catch (IllegalArgumentException | IndexOutOfBoundsException e){
            System.err.println("Can not put file id:"+file.getId()+" to storage id:"+storage.getId()+". Reason: "+e.getMessage());
        }
    }

    public void delete(Storage storage, File file){
        if(storage == null)
            return;

        try {
            storage.deleteFile(file);
        } catch(IllegalArgumentException e){
            System.err.println("Can not delete file id:"+file.getId()+" from storage id:"+storage.getId()+". Reason: "+e.getMessage());
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
                System.err.println("Can not transfer file id:"+file.getId()+" to storage id:"+storageTo.getId()+". Reason: "+e.getMessage());
            }
        } catch (IllegalArgumentException e){
            System.err.println("Can not transfer file id:"+id+" to storage id:"+storageTo.getId()+". Reason: "+e.getMessage());
        }
    }
}
