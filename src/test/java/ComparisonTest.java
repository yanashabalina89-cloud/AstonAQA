import org.example.Comparison;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class ComparisonTest {

    @DataProvider
    public Object[][] comparisonData(){
        return new Object[][]{
                {91, 345, -1},
                {78, 6, 1},
                {-99, -99, 0},
                {Integer.MIN_VALUE, Integer.MAX_VALUE, -1},
                {0, 0, 0}
        };
    }

    @Test(dataProvider = "comparisonData")
    void testCompare(int a, int b, int excepted) {
        assertEquals(Comparison.compare(a,b), excepted);
    }
}
