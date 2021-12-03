package ru.madbrains.simpleList;

import java.util.Comparator;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.locks.ReentrantLock;

public class Program {

    private static SimpleList mycar;
    private static SimpleList youcar;


    public static SimpleList createIndexList(int count) throws NoEntityException, ArrayIndexOutOfBoundsException {
        SimpleList<Car> indexList = new ListOperation();
        for (int i = 0; i < count; i++) {
            indexList.add(new Car(String.valueOf(i), String.valueOf(count - 1 - i), (float) i));
        }
        return indexList;
    }

    private static void swap(int[] array, int ind1, int ind2) {
        int tmp = array[ind1];
        array[ind1] = array[ind2];
        array[ind2] = tmp;
    }

    public static void print(SimpleList list) throws ArrayIndexOutOfBoundsException, NoEntityException {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).get());
        }
        System.out.println("\n");
    }


    public static void main(String[] args) throws NoEntityException, ArrayIndexOutOfBoundsException, InterruptedException, ExecutionException {
        Comparator<Car> comparatorName = Comparator.comparing(Car::getName);
        Comparator<Car> comparatorName1 = Comparator.comparing(Car::getName);
        mycar = createIndexList(3000000);
        mycar = mycar.shuffle();

        youcar = createIndexList(15000);
        youcar = youcar.shuffle();

        //print(youcar);
//        long start1 = System.nanoTime();
//        youcar = youcar.sortingThreads(comparatorName1);
//        long finish1 = System.nanoTime();
//        print(youcar);
//
//       // print(mycar);
        long start = System.nanoTime();
        mycar = mycar.sort(comparatorName);
        long finish = System.nanoTime();
        //print(mycar);



        long elapsed = finish - start;
        //long elapsed1 = finish1 - start1;
        System.out.println("Mycar Время в мс: " + elapsed / 100000);
        //System.out.println("Youcar Время в мс: " + elapsed1 / 100000);
//        print(mycar);
    }
}