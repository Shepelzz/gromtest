package gromcode.main.lesson25.homework25_1;

public class GeneralDAO<T> {

    @SuppressWarnings("unchecked")
    private T[] array = (T[]) new Object[5];

    public T save(T t) throws Exception{
        for(T el : array){
            if(t.equals(el)){
                throw  new Exception("element "+t.toString()+" exists in array");
            }
        }

        int index = 0;
        for(T el : array){
            if(el == null){
                array[index] = t;
                return array[index];
            }
            index++;
        }
        throw new Exception("there is no free space");
    }

    public T[] getAll(){
        return array;
    }
}

