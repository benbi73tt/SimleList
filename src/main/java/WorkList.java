import java.util.ArrayList;
import java.util.List;

public class WorkList {

    public static void print(SimpleList car){
        for(int i = 0; i< car.size();i++){
            System.out.println(car.get(i));
        }
        System.out.println("\n");
    }

    public static void main(String[] args) throws Exception {

        SimpleList skoda = new ListOperation("Skoda", 20, Cars.class);


        Cars octavia = new Cars("2018",1.7f);
        Cars rapid = new Cars("2015",0.7f);
        Cars karoq = new Cars("2019",2f);
        Cars kodiaq = new Cars("2020",2.4f);
        Cars superb = new Cars("2021",3.1f);

        skoda.add(octavia);
        skoda.add(rapid);
        skoda.add(karoq);
        skoda.add(superb);
        skoda.add(octavia);
        skoda.add(rapid);
        skoda.add(karoq);
        skoda.add(superb);
        skoda.add(octavia);
        skoda.add(rapid);
        skoda.add(karoq);
        skoda.add(superb);


        System.out.println(skoda.toString());
        print(skoda);


        skoda.insert(2,kodiaq);

        print(skoda);
        System.out.println(skoda.toString());

        skoda.remove(0);

        print(skoda);
        System.out.println(skoda.toString());

        System.out.println(skoda.first(karoq));
        System.out.println(skoda.first(rapid));
        System.out.println(skoda.first(octavia));

        System.out.println(skoda.last(karoq));
        System.out.println(skoda.last(rapid));
        System.out.println(skoda.last(kodiaq));

    }
}
