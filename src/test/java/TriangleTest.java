import org.example.Triangle;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class TriangleTest {

    @DataProvider
    public Object[][] invalidTriangles(){
        return new Object[][]{
                {1, 2, 5},
                {-3, 4, 5},
                {0, 3, 4},
                {1, 2, 3}
        };
    }

    @DataProvider
    public Object[][] areaData(){
        return new Object[][]{
                {3, 4, 5, 6.0},
                {2, 2, 2, Math.sqrt(3)},
                {5, 12, 13, 30.0},
                {13, 14, 15, 84.0},
                {0.3, 0.4, 0.5, 0.06}
        };
    }


    @Test(dataProvider = "areaData")
    void testGetArea(double a, double b, double c, double expected) {
        assertEquals(new Triangle(a, b, c).getArea(), expected, 0.01);
    }

    @Test(dataProvider = "invalidTriangles", expectedExceptions = IllegalArgumentException.class)
    void testInvalidTriangleThrowsException(double a, double b, double c) {
            new Triangle(a, b, c);
    }
}
