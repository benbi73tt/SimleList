import java.lang.reflect.Array;
import java.util.*;

public class ListOperation<T> implements SimpleList<T> {

    private T[] arr;
    private String name;
    private int size;
    private Class<T> clazzT;

    public ListOperation(String name,int maxSize, Class<T> clazz){
        this.clazzT = clazz;
        this.arr = (T[]) Array.newInstance(clazzT, maxSize);
        this.name = name;
    }

    public ListOperation() {

    }

    public void exten(int count){
        T[] bufArr = (T[]) Array.newInstance(clazzT,size + count);
        System.arraycopy(arr,0, bufArr,0,size());
        this.arr = bufArr;
        System.out.println("use exten");
    }

    @Override
    public void add(T item) {
        if(arr.length <= size) exten(1);
            arr[size] = item;
            size++;
    }

    @Override
    public void insert(int index, T item) throws Exception {
        if(arr.length <= size) exten(1);
            System.arraycopy(arr,index, arr,index+1,size()-index);
            arr[index] = item;
            size++;
    }

    @Override
    public void remove(int index) throws Exception {
        if(index > -1 && index < size()){
            System.arraycopy(arr, index+1, arr, index, size()-index-1);
            arr[size()-1] = null;
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
            return Optional.ofNullable(arr[index]);
        else
            System.out.println("Invalid Index");
        //todo посмотреть кастомные ошибки

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
        for(int i = size;i >= 0; i--){
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
            if(item.equals(arr[i])){
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
        exten(list.size());
        for(int i = 0; i<list.size();i++)
            add(list.get(i).get());
    }

    @Override
    public boolean isEmpty() {
        boolean res = true;
        System.out.println(size);
        if(size > 0)
            res = false;
        return res;
    }




    @Override
    public SimpleList<T> shuffle(){
        SimpleList shuf = new ListOperation("shuf", size, clazzT);
        int[] t = new int[size];

        for(int i = 0; i<size; i++){
            t[i]=i;
        }
        Random rnd = new Random();
        for(int i = size-1; i > 0; i--){
//            int j = (int) (Math.random() * (i-1));
            int j = rnd.nextInt(i);
//            System.out.println(j);
            int k = t[i];
            t[i] = t[j];
            t[j] = k;
        }
        for (int i = 0; i < size; i++){
            System.out.println(t[i]);
            shuf.add(arr[t[i]]);
        }
        System.out.println(size);


//        for (int i = 0; i < size(); i++){
//            int index = (int) (Math.random() * size);
//            System.out.println("["+i+"]"+index);
//            if(index == size - 1){
//                index = 0;
//            }
//            else index++;
//
//


//            while(index == i){
//                if(index == size-1)
//                    index = 0;
//                else index+=1;
//                System.out.println("["+i+"]"+index);
//            }
//                      boolean first = true;
//            for(int k = 0; k < size; k++){
//                while(t[k] == index && i == index){
//                    if (index == 0 && first){
//                        first = false;
//                        break;
//                    }
//                    if(index == size-1)
//                        index = 0;
//                    else index++;
//                    k = 0;
//                    System.out.println("я изменил index " + index);
//                }
//
//                System.out.println("["+i+"]"+index);
//            }
//
//            t[i] = (index);
//            shuf.add(arr[index]);
//        }
         // записать в новый класс
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

            if (i <= j) {//меняем местами
           swap(buf,i,j);
                i++;
                j--;
            }
        }
        if (low < j)
            quickSort(buf,low, j, comparator);

        if (high > i)
            quickSort(buf,i, high, comparator);
        return buf;
    }

    public void minSort(Comparator<T> comparator){

    }

    @Override
    public SimpleList<T> sort(Comparator<T> comparator) {
        ListOperation sortin = new ListOperation("shuf", size, clazzT);
        for(int i = 0 ; i < size; i++){
            sortin.add(arr[i]);
        }
        T[] buf = arr;
        System.out.println(size);
        //buf = quickSort(buf,0, size-1, comparator);
        return sortin;
    }
}

