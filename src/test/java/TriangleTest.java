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
                {0, 3, 4}
        };
    }

    @Test
    void testGetArea() {
        assertEquals(new Triangle(50, 60, 70).getArea(),1469.7, 0.01);
    }

    @Test(dataProvider = "invalidTriangles", expectedExceptions = IllegalArgumentException.class)
    void testInvalidTriangleThrowsException(double a, double b, double c) {
            new Triangle(a, b, c);
    }
}
