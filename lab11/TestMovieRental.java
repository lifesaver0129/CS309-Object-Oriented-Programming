import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertTrue;

public class TestMovieRental {
    Customer C1;
    Customer C2;
    Customer C3;
    Customer C4;

    Movie M1;
    Movie M2;
    Movie M3;


    @Before
    public void setUp() {
        C1 = new Customer("John");
        C2 = new Customer("Mary");
        C3 = new Customer("Manny");

        M1 = new Movie("Oz The Great and Powerful", Movie.NEW_RELEASE);
        M2 = new Movie("The Dark Knight", Movie.REGULAR);
        M3 = new Movie("Wreck-it Ralph", Movie.CHILDRENS);
    }

    private String getAnswer1() {
        StringBuilder ans = new StringBuilder("Rental Record for John\n");
        ans.append("\tOz The Great and Powerful\t15.0\n");
        ans.append("\tThe Dark Knight\t3.5\n");
        ans.append("\tWreck-it Ralph\t3.0\n");
        ans.append("Amount owed is 21.5\n");
        ans.append("You earned 4 frequent renter points");
        return ans.toString();
    }

    private String getAnswer2() {
        StringBuilder ans = new StringBuilder("Rental Record for Mary\n");
        ans.append("\tOz The Great and Powerful\t3.0\n");
        ans.append("\tWreck-it Ralph\t9.0\n");
        ans.append("Amount owed is 12.0\n");
        ans.append("You earned 2 frequent renter points");
        return ans.toString();
    }

    private String getAnswer3() {
        StringBuilder ans = new StringBuilder("Rental Record for Manny\n");
        ans.append("\tThe Dark Knight\t2.0\n");
        ans.append("\tWreck-it Ralph\t1.5\n");
        ans.append("Amount owed is 3.5\n");
        ans.append("You earned 2 frequent renter points");
        return ans.toString();
    }

    @Test
    public void test1() {
        Date start = new Date(2013, 7, 1);
        Date end1 = new Date(2013, 7, 6);
        Date end2 = new Date(2013, 7, 4);
        Date end3 = new Date(2013, 7, 5);

        C1.addRental(new Rental(M1, new DataRange(start, end1)));
        C1.addRental(new Rental(M2, new DataRange(start, end2)));
        C1.addRental(new Rental(M3, new DataRange(start, end3)));

        String ans = getAnswer1();
        assertTrue(ans.equals(C1.statement()));
    }

    @Test
    public void test2() {
        Date start = new Date(2013, 7, 11);
        Date end1 = new Date(2013, 7, 12);
        Date end2 = new Date(2013, 7, 19);
        C2.addRental(new Rental(M1, new DataRange(start, end1)));
        C2.addRental(new Rental(M3, new DataRange(start, end2)));

        String ans = getAnswer2();
        assertTrue(ans.equals(C2.statement()));
    }

    @Test
    public void test3() {
        Date start = new Date(2013, 6, 1);
        Date end1 = new Date(2013, 6, 3);
        Date end2 = new Date(2013, 6, 2);
        C3.addRental(new Rental(M2, new DataRange(start, end1)));
        C3.addRental(new Rental(M3, new DataRange(start, end2)));
        String ans = getAnswer3();
        assertTrue(ans.equals(C3.statement()));
    }
}
