import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// uses hashing so custom objects have to have equals method appropriately overridden
public class RemoveInConstantTimeArray <T> {
    private List<T> database;
    private Map<T, Integer> searchEngine;
    private int size;

    public RemoveInConstantTimeArray(){
        this.database = new ArrayList<>();
        this.searchEngine = new HashMap<>();
        this.size = 0;
    }

    public void put(T elem){
        if (!searchEngine.containsKey(elem)){
            database.add(elem);
            searchEngine.put(elem, size++);
        }
    }

    public T get(int index){
        if (index >= 0 && index < size) return database.get(index);
        else throw new ArrayIndexOutOfBoundsException();
    }

    // swap target and the last element and do pop
    public void remove(T elem){
        if (searchEngine.containsKey(elem)){
            int indexOfTarget = searchEngine.get(elem);
            T lastElem = database.get(size-1);
            database.set(indexOfTarget, lastElem);
            searchEngine.put(lastElem, indexOfTarget);
            database.remove(size-1);
            size--;
        }
    }

    public boolean contains(T elem){
        return searchEngine.containsKey(elem);
    }

    public int size(){ return this.size;}

    public static void main(String[] args) {
        RemoveInConstantTimeArray <String> arr = new RemoveInConstantTimeArray<>();
        arr.put("bla");
        arr.put("ble");
        arr.put("blu");
        System.out.println(arr.size());
        arr.put("blu");
        System.out.println(arr.size());
        arr.remove("blu");
        System.out.println(arr.size());
        System.out.println(arr.contains("bla"));
        System.out.println(arr.get(1));
    }
}
