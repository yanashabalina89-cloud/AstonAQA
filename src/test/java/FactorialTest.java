import org.example.Factorial;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.math.BigInteger;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertThrows;

public class FactorialTest {
    @DataProvider
    public Object[][] factorialData() {
        return new Object[][]{
                {0, BigInteger.ONE},
                {1, BigInteger.ONE},
                {9, new BigInteger("362880")},
                {20, new BigInteger("2432902008176640000")}
        };
    }

    @Test(dataProvider = "factorialData")
    void testFactorial(int a, BigInteger expected) {
        assertEquals(Factorial.calculate(a), expected);
    }

    @Test
    void testFactorialNegativeThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> Factorial.calculate(-1));
    }
}
