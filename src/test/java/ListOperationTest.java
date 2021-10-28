import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ListOperationTest {
    private Cars octavia;
    private Cars rapid;
    private Cars karoq;


    @Before
    public void setUp(){
        Cars octavia = new Cars("Octavia","2018",1.7f);
        Cars rapid = new Cars("Rapid","2015",0.7f);
        Cars karoq = new Cars("Karoq","2019",2f);
        Cars kodiaq = new Cars("Kodiaq","2020",2.4f);
        Cars superb = new Cars("Superb","2021",3.1f);
        Cars camry = new Cars("Camry","2015",1f);
        Cars corolla = new Cars("Corolla","2020",1.5f);
//        for(int i = )


    }

    @Test
    public void getAllUsers_NO_NULL(){
        SimpleList test = new ListOperation();
        test.add(octavia);
        System.out.println(test.size());
        System.out.println(test);
        Assert.assertNotNull(test);
    }


    @Test
    public void exten() {

    }

    @Test
    public void testExten() {
    }

    @Test
    public void add() throws ArrayIndexOutOfBoundsException, NoEntityException {
        SimpleList test = new ListOperation();
        test.add(octavia);
        test.add(karoq);
        test.add(rapid);



        List<Cars> actual = new ArrayList<>();
        actual.add(octavia);
        actual.add(rapid);


        Assert.assertEquals(test.get(0).get(), actual.get(0));

        Assert.assertEquals(test.get(2).get(),actual.get(1));

    }

    @Test
    public void insert() {
    }

    @Test
    public void remove() {
    }

    @Test
    public void get() {
    }

    @Test
    public void size() throws Exception {
        SimpleList test = new ListOperation();
        Cars octavia = new Cars("Octavia","2018",1.7f);
        Cars rapid = new Cars("Rapid","2015",0.7f);
        Cars karoq = new Cars("Karoq","2019",2f);
        test.add(octavia);
        test.add(rapid);
        Assert.assertEquals(test.size(),2);

        SimpleList test2 = new ListOperation();
        test2.add(karoq);
        test2.add(octavia);

        test.addAll(test2);

        Assert.assertEquals(test.size(),4);

        test.remove(3);

        Assert.assertEquals(test.size(),3);

        test.insert(0,octavia);


        Assert.assertEquals(test.size(),4);
    }


    @Test
    public void first() {
    }

    @Test
    public void last() {
    }

    @Test
    public void contains() {
        SimpleList test = new ListOperation();

    }

    @Test
    public void addAll() {
    }

    @Test
    public void isEmpty() {
    }

    @Test
    public void shuffle() {
    }

    @Test
    public void sort() {
    }
}