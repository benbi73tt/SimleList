import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class WorkList {

    public static void print(SimpleList car){
        for(int i = 0; i< car.size();i++){
            System.out.println(car.get(i));
        }
        System.out.println("\n");
    }

    public static void main(String[] args) throws Exception {

        SimpleList skoda = new ListOperation("Skoda", 10, Cars.class);
        SimpleList toyota = new ListOperation("Toyota", 10, Cars.class);

        Cars octavia = new Cars("octavia","2018",1.7f);
        Cars rapid = new Cars("rapid","2015",0.7f);
        Cars karoq = new Cars("karoq","2019",2f);
        Cars kodiaq = new Cars("kodiaq","2020",2.4f);
        Cars superb = new Cars("superb","2021",3.1f);
        Cars camry = new Cars("camry","2015",1f);
        Cars corolla = new Cars("corolla","2020",1.5f);

        ArrayList check = new ArrayList();


        skoda.add(octavia);
        skoda.add(rapid);
        skoda.add(karoq);
        skoda.add(superb);
        skoda.add(octavia);
        skoda.add(rapid);
        skoda.add(karoq);
        skoda.add(superb);


        toyota.add(camry);
        toyota.add(corolla);


        System.out.println(skoda.toString());
        print(skoda);


        skoda.insert(2,kodiaq);

        print(skoda);
        System.out.println(skoda.toString());

        skoda.remove(0);
        skoda.remove(2);
        skoda.remove(1);

        print(skoda);
        System.out.println(skoda.toString());

        System.out.println(skoda.first(karoq));
        System.out.println(skoda.first(rapid));
        System.out.println(skoda.first(octavia));

        System.out.println(skoda.last(karoq));
        System.out.println(skoda.last(rapid));
        System.out.println(skoda.last(kodiaq));
        System.out.println(skoda.contains(camry));
        System.out.println(skoda.contains(octavia));

        print(skoda);
        print(toyota);
        skoda.addAll(toyota);
        print(skoda);

    }
}
