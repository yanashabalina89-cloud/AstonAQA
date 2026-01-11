import org.example.Factorial;
import org.testng.annotations.Test;


public class FactorialTest {
    @Test
    void testFactorial() {
        assertEquals(362880, Factorial.calculate(9));
    }

    @Test
    void testFactorialZero() {
        assertEquals(1, Factorial.calculate(0));
    }

    @Test
    void testFactorialOne() {
        assertEquals(1, Factorial.calculate(1));
    }

    @Test
    void testFactorialNegativeThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> Factorial.calculate(-1));
    }
}
