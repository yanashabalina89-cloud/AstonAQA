import org.example.Calculator;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertThrows;

public class CalculatorTest {

    @DataProvider
    public Object[][] additionData() {
        return new Object[][]{
                {118, 5677, 5795},
                {-2, 2, 0},
                {-2, -3, -5},
                {0, 0, 0},
                {100, -50, 50}
        };
    }

    @DataProvider
    public Object[][] subtractionData() {
        return new Object[][]{
                {10, 3, 7},
                {8, 8, 0},
                {0, 0, 0},
                {100, -50, 150},
                {0, 7, -7},
                {7, 0, 7}
        };
    }

    @DataProvider
    public Object[][] multiplicationData() {
        return new Object[][]{
                {0, 0, 0},
                {2, 3, 6},
                {-2, 3, -6},
                {Integer.MAX_VALUE, 1, Integer.MAX_VALUE},
                {100, 100, 10000},
                {0, -5, 0}
        };
    }

    @DataProvider
    public Object[][] divisionData() {
        return new Object[][]{
                {15, 3, 5.0},
                {7, 2, 3.5},
                {-8, 2, -4.0},
                {0, 5, 0.0},
                {-12, -4, 3.0}
        };
    }

    @Test(dataProvider = "additionData")
    void testAdd(int a, int b, int expected) {
        assertEquals(Calculator.add(a, b), expected);
    }

    @Test(dataProvider = "subtractionData")
    void testSubtract(int a, int b, int expected) {
        assertEquals(Calculator.subtract(a, b), expected);
    }

    @Test(dataProvider = "multiplicationData")
    void testMultiply(int a, int b, int expected) {
        assertEquals(Calculator.multiply(a, b), expected);
    }

    @Test(dataProvider = "divisionData")
    void testDivide(int a, int b, double expected) {
        assertEquals(Calculator.divide(a, b), expected, 0.01);
    }

    @Test
    void testDivideByZeroThrowsException() {
        assertThrows(ArithmeticException.class, () -> Calculator.divide(10, 0));
    }
}
