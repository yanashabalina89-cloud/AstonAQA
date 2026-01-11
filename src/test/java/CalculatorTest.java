import org.example.Calculator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    @Test
    void testAdd() {
        assertAll(
                () -> assertEquals(5795, Calculator.add(118, 5677)),
                () -> assertEquals(0, Calculator.add(-2, 2)),
                () -> assertEquals(-5, Calculator.add(-2, -3))
        );
    }


    @Test
    void testSubtract() {
        assertAll(
                () -> assertEquals(6123, Calculator.subtract(11800, 5677)),
                () -> assertEquals(1, Calculator.subtract(3, 2)),
                () -> assertEquals(-1, Calculator.subtract(2, 3))
        );
    }

    @Test
    void testMultiply() {
        assertAll(
                () -> assertEquals(15912, Calculator.multiply(68, 234)),
                () -> assertEquals(0, Calculator.multiply(0, 5)),
                () -> assertEquals(-6, Calculator.multiply(2, -3))
        );
    }

    @Test
    void testDivide() {
        assertAll(
                () -> assertEquals(75, Calculator.divide(1725, 23)),
                () -> assertEquals(2.5, Calculator.divide(5, 2)),
                () -> assertEquals(0, Calculator.divide(0, 5))
        );
    }

    @Test
    void testDivideByZeroThrowsException() {
        assertThrows(ArithmeticException.class, () -> Calculator.divide(10, 0));
    }
}
