import java.lang.reflect.Array;
import java.util.Comparator;
import java.util.Optional;

public class ListOperation<T> implements SimpleList<T> {
    private T[] rainbow;
    private String name;
    private int size;


    public ListOperation(String name,int maxSize, Class<T> clazz){
        this.rainbow = (T[]) Array.newInstance(clazz, maxSize);
        this.name = name;
    }
    public ListOperation() {

    }

    @Override
    public void add(T item) {
        rainbow[size] = item;
        size++;
    }

    @Override
    public void insert(int index, T item) throws Exception {
        size++;
        System.arraycopy(rainbow,index, rainbow,index+1,size()-index);
        rainbow[index] = item;
    }

    @Override
    public void remove(int index) throws Exception {
        if(index > -1 && index < size()){
            System.arraycopy(rainbow, index+1, rainbow, index, size()-index-1);
            rainbow[size()-1] = null;
            size--;
            System.gc();

        }
    }

    public String toString(){
        return "ListOperation {"+
                "Name = '"+ name + '\'' +
                "  Size = '" + size + '\'' +
                '}';
    }

    @Override
    public Optional<T> get(int index) {
        if(index > -1 && index < size())
            return Optional.ofNullable(rainbow[index]);
        else
            System.out.println("Invalid Index");

        return Optional.empty();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public int first(T item) {
        int res = 0;
        for(int i = 0; i < size; i++) {
            if (item.equals(rainbow[i])){
                res = i;
                break;
            }
            else res = -1;
        }
        return res;
    }

    @Override
    public int last(T item) {
        int res = 0;
        for(int i = size;i >= 0; i--){
            if (item.equals(rainbow[i])){
                res = i;
                break;
            }
            else res = -1;
        }
        return res;
    }

    @Override
    public boolean contains(T item) {
        boolean res = false;
        for(int i = 0; i < size; i++){
            if(item.equals(rainbow[i])){
                res = true;
                break;
            }
        }

//todo        for(T x : rainbow){
//            if (x == null) return false;
//            if(x.equals(item)) {
//                return true;
//            }
//        }
        return res;
    }

    @Override
    public void addAll(SimpleList<T> list) {
        for(int i = 0; i<list.size();i++)
        add(list.get(i).get());
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public SimpleList<T> shuffle() {
        return null;
    }

    @Override
    public SimpleList<T> sort(Comparator<T> comparator) {
        return null;
    }
}

