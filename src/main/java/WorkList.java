import java.util.*;

public class WorkList {

    public static void print(SimpleList car){
        for(int i = 0; i< car.size();i++){
            System.out.println(car.get(i));
        }
        System.out.println("\n");
    }

    public static void main(String[] args) throws Exception {

        SimpleList skoda = new ListOperation("Skoda", 5, Cars.class);
        SimpleList toyota = new ListOperation("Toyota", 10, Cars.class);

        Cars octavia = new Cars("octavia","2018",1.7f);
        Cars rapid = new Cars("rapid","2015",0.7f);
        Cars karoq = new Cars("karoq","2019",2f);
        Cars kodiaq = new Cars("kodiaq","2020",2.4f);
        Cars superb = new Cars("superb","2021",3.1f);
        Cars camry = new Cars("camry","2015",1f);
        Cars corolla = new Cars("corolla","2020",1.5f);

        ArrayList check = new ArrayList();
        ArrayList chekc2 = new ArrayList();
        check.add("gfdgfd");
        check.add("gfdadgfd");
        check.add("gfdgffsdd");
        check.add("gffdsdgfd");
       Collections.shuffle(check);



        skoda.add(octavia);
        skoda.add(rapid);
        skoda.add(karoq);
        skoda.add(superb);



        toyota.add(camry);
        toyota.add(corolla);
        skoda.insert(3,camry);


        System.out.println(toyota.size());
        toyota.addAll(skoda);

        //print(toyota);
        //System.out.println(toyota.size());
        print(toyota);
         SimpleList shufToyouta = toyota.shuffle();
        System.out.println("shufToyouta: ");
         print(shufToyouta);
        System.out.println("Toyouta: ");

         print(toyota);
        //print(shufToyouta);
        //print(toyota);
       // System.out.println(check.get(0));
       // System.out.println(check.get(0));

        //System.out.println(toyota);
       // System.out.println(shufToyouta);

        Comparator<Cars> comparator = Comparator.comparing(obj -> obj.getPrice());
        print(toyota);
        toyota.sort(comparator);
        print(toyota);
        SimpleList sortToyouta = toyota.sort(comparator);
        System.out.println(sortToyouta);
        print(sortToyouta);
        System.out.println(toyota);
        print(toyota);
    }

}


