import java.lang.reflect.Array;
import java.util.*;

public class ListOperation<T> implements SimpleList<T> {

    private T[] arr;
    private String name;
    private int size;
    private Class<?> clazzT;

    public ListOperation(String name,int maxSize, Class<T> clazz){
        this.clazzT = clazz;
        this.arr = (T[]) Array.newInstance(clazzT, maxSize);
        this.name = name;
    }

    public ListOperation() {
        this.clazzT = getClass();
        this.arr = (T[]) Array.newInstance( clazzT, 0);

    }
    public void assignmentClass(T item){
        if (arr.length == 0){
            this.clazzT = item.getClass();
        }

    }

    public void exten(int count){
        T[] bufArr = (T[]) Array.newInstance(clazzT,size + count);
        System.arraycopy(arr,0, bufArr,0,size());
        this.arr = bufArr;
    }

    public void exten(){
        T[] bufArr = (T[]) Array.newInstance(clazzT,(size + 1) * 2);
        System.arraycopy(arr, 0, bufArr, 0, size());
        this.arr = bufArr;
    }

    @Override
    public void add(T item) {
        assignmentClass(item);
        if (arr.length <= size) {
            exten();
            arr[size] = item;
        } else {
            arr[size] = item;
        }
        size++;
    }

    @Override
    public void insert(int index, T item) throws ArrayIndexOutOfBoundsException{
        assignmentClass(item);
        if (arr.length <= size) exten();
        if (index > -1 && index < size()){
            System.arraycopy(arr, index, arr, index + 1, size() - index);
            arr[index] = item;
            size++;
        }
        else
            throw new ArrayIndexOutOfBoundsException(item + " не может быть добавлен, index'a " + index
                    + " не существует, измените значение");

    }

    @Override
    public void remove(int index) throws ArrayIndexOutOfBoundsException{
        if (index > -1 && index < size()){
            System.arraycopy(arr, index+1, arr, index, size() - index - 1);
            arr[size()-1] = null;
            size--;
        }
        else
            throw new ArrayIndexOutOfBoundsException("элемент под index " + index
                    + " не существует, измените значение");
    }

    @Override
    public String toString(){
        return "ListOperation {" +
                "Name = '" + name + '\'' +
                "  Size = '" + size + '\'' +
                '}';
    }


    @Override
    public Optional<T> get(int index) throws ArrayIndexOutOfBoundsException{
        if(index > -1 && index < size())
            return Optional.ofNullable(arr[index]);
        else
            throw new ArrayIndexOutOfBoundsException("Вызываемого элемента " + index
                    + " не существует, измените значение");
    }

    @Override
    public int size() { return size; }

    @Override
    public int first(T item) {
        int res = 0;
        for(int i = 0; i < size; i++) {
            if (item.equals(arr[i])){
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
        for(int i = size; i >= 0; i--){
            if (item.equals(arr[i])){
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
            if (item.equals(arr[i])){
                res = true;
                break;
            }
        }
        return res;
    }

    @Override
    public void addAll(SimpleList<T> list) throws ArrayIndexOutOfBoundsException {
        exten(list.size());
        for(int i = 0; i<list.size(); i++)
            add(list.get(i).get());
    }

    @Override
    public boolean isEmpty() {
        boolean res = true;
        if(size > 0)
            res = false;
        return res;
    }

    @Override
    public SimpleList<T> shuffle(){
        SimpleList shuf = new ListOperation("shuf" + name, size, clazzT);
        int[] t = new int[size];
        for(int i = 0; i < size; i++){
            t[i] = i;
        }
        Random rnd = new Random();
        for(int i = size-1; i > 0; i--){
            int j = rnd.nextInt(i);
            int k = t[i];
            t[i] = t[j];
            t[j] = k;
        }
        for (int i = 0; i < size; i++){
            shuf.add(arr[t[i]]);
        }
        return shuf;
    }

    public void swap(T[] x, int a, int b) {
        T t = x[a];
        x[a] = x[b];
        x[b] = t;
    }

    public T[] quickSort(T[] buf, int low, int high, Comparator<T> comparator){
        if (size == 0)
            return buf;

        if (low >= high)
            return buf;

        int middle = low + (high - low) / 2;
        T opora = buf[middle];
        int i = low, j = high;

        while (i <= j) {
            while (comparator.compare(opora, buf[i]) == 1 ) {
                i++;
            }

            while (comparator.compare(opora, buf[j]) == -1 ) {
                j--;
            }

            if (i <= j) {
                swap(buf,i,j);
                i++;
                j--;
            }
        }
        if (low < j)
            quickSort(buf,low, j, comparator);

        if (high > i)
            quickSort(buf, i, high, comparator);
        return buf;
    }

    @Override
    public SimpleList<T> sort(Comparator<T> comparator) {
        ListOperation sortin = new ListOperation("Sorting" + name, size, clazzT);
        T[] temporaryArray = Arrays.copyOf(arr,size);
        temporaryArray = quickSort(temporaryArray, 0 ,size - 1,comparator);
        for( int i = 0; i < size; i++){
            sortin.add(temporaryArray[i]);
        }
        return sortin;
    }
}

//todo    public void swap(int[] x, int a, int b) {
//        int t = x[a];
//        x[a] = x[b];
//        x[b] = t;
//    }
//
//todo    public int[] quickSort(int[] t, int low, int high, Comparator<T> comparator){
//        if (size == 0)
//            return t;
//        if (low >= high)
//            return t;
//        int middle = low + (high - low) / 2;
//        T opora = arr[t[middle]];
//        int i = low, j = high;
//        while (i <= j) {
//            while (comparator.compare(opora, arr[t[i]]) == 1 ) {
//                i++;
//            }
//            while (comparator.compare(opora, arr[t[j]]) == -1 ) {
//                j--;
//            }
//            if (i <= j) {
//                swap(t,i,j);
//                i++;
//                j--;
//            }
//        }
//        if (low < j)
//            quickSort(t, low, j, comparator);
//        if (high > i)
//            quickSort(t ,i, high, comparator);
//        return t;
//    }
//
//todo    @Override
//    public SimpleList<T> sort(Comparator<T> comparator) {
//        SimpleList sortin = new ListOperation("Sorting" + name, size, clazzT);
//        int[] t = new int[size];
//        for(int i = 0; i<size; i++){
//            t[i]=i;
//        }
//        t = quickSort(t,0, size-1, comparator);
//        for (int i = 0; i<size();i++){
//            sortin.add(arr[t[i]]);
//        }
//        return sortin;
//    }
// }

