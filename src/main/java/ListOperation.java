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
        //System.out.println(this.getColor() + size + " is added " );
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
    public void addAll(SimpleList<T> list) {

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
        return false;
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

