package lesson25.homework25_1;

public class GeneralDAO<T> {

    @SuppressWarnings("unchecked")
    private T[] array = (T[]) new Object[5];

    public T save(T t) throws Exception{
        validate();

        int index = 0;
        for(T el : array){
            if(el == null){
                array[index] = t;
                return array[index];
            }
            index++;
        }
        return null;
    }

    private void validate() throws Exception{
        int count = 0;
        for(T el : array){
            if(el == null){
                count++;
            }
        }
        if(count == 0)
            throw new Exception("there is no free space");
    }

    public T[] getAll(){
        return array;
    }
}
