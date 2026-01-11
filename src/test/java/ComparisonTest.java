import org.example.Comparison;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ComparisonTest {
    @Test
    void testCompareLess() {
        assertEquals(-1, Comparison.compare(91, 345));
    }

    @Test
    void testCompareGreater() {
        assertEquals(1, Comparison.compare(78, 6));
    }

    @Test
    void testCompareEqual() {
        assertEquals(0, Comparison.compare(-99, -99));
    }

    @Test
    void testCompareMinMax() {
        assertEquals(-1, Comparison.compare(Integer.MIN_VALUE, Integer.MAX_VALUE));
    }

    @Test
    void testCompareZero() {
        assertEquals(0, Comparison.compare(0, 0));
    }
}
