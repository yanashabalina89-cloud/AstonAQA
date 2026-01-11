import org.example.Triangle;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TriangleTest {
    @Test
    void testGetArea() {
        assertEquals(1469.7, new Triangle(50, 60, 70).getArea(), 0.01);
    }

    @Test
    void testInvalidTriangleThrowsException() {
        assertAll(
                () -> assertThrows(IllegalArgumentException.class, () -> new Triangle(1, 2, 5)),
                () -> assertThrows(IllegalArgumentException.class, () -> new Triangle(-3, 4, 5)),
                () -> assertThrows(IllegalArgumentException.class, () -> new Triangle(0, 3, 4))
        );
    }
}
