import java.util.List;

public class WorkList {

    public static void print(SimpleList car) throws ArrayIndexOutOfBoundsException {
        for(int i = 0; i< car.size();i++){
            System.out.println(car.get(i));
        }
        System.out.println("\n");
    }

    public static void main(String[] args) throws Exception {

        SimpleList skoda = new ListOperation("Skoda", 5, Cars.class);
        SimpleList toyota = new ListOperation("Toyota", 10, Cars.class);
        SimpleList test = new ListOperation();

        Cars octavia = new Cars("Octavia","2018",1.7f);
        Cars rapid = new Cars("Rapid","2015",0.7f);
        Cars karoq = new Cars("Karoq","2019",2f);
        Cars kodiaq = new Cars("Kodiaq","2020",2.4f);
        Cars superb = new Cars("Superb","2021",3.1f);
        Cars camry = new Cars("Camry","2015",1f);
        Cars corolla = new Cars("Corolla","2020",1.5f);
    }
}


