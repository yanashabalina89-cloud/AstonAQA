import org.example.Factorial;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FactorialTest {
    @Test
    void testFactorial() {
        assertEquals(new BigInteger("362880"), Factorial.calculate(9));
    }

    @Test
    void testFactorialZero() {
        assertEquals(BigInteger.ONE, Factorial.calculate(0));
    }

    @Test
    void testFactorialOne() {
        assertEquals(BigInteger.ONE, Factorial.calculate(1));
    }

    @Test
    void testFactorialNegativeThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> Factorial.calculate(-1));
    }
}
