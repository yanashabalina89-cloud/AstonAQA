
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import static org.junit.jupiter.api.Assertions.*;

public class CommissionFreeOnlineTopUpTest {
    WebDriver driver;
    WebElement section;

    @BeforeAll
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setupTest() {
        driver = new ChromeDriver();
        driver.get("https://www.mts.by/");
        section = driver.findElement(By.xpath("//section[@class='pay']"));
    }

    @AfterEach
    void teardown() {
        driver.quit();
    }

    @Test
    void testNameSection() {
        String header = section.findElement(By.tagName("h2")).getText().replaceAll("\\s+", " ")
                .trim();
        System.out.println(header);
        assertEquals("Онлайн пополнение без комиссии",header);


    }
}
