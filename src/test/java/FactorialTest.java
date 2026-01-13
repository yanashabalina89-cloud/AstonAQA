import org.example.Factorial;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertThrows;

public class FactorialTest {
    @Test
    void testFactorial() {
        assertEquals(Factorial.calculate(9), 362880);
    }

    @Test
    void testFactorialZero() {
        assertEquals( Factorial.calculate(0), 1);
    }

    @Test
    void testFactorialOne() {
        assertEquals(Factorial.calculate(1), 1);
    }

    @Test
    void testFactorialNegativeThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> Factorial.calculate(-1));
    }
}
