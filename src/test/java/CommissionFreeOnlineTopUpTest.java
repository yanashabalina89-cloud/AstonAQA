
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Set;

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
        WebElement acceptButton = driver.findElement(By.id("cookie-agree"));
        acceptButton.click();
    }

    @AfterEach
    void teardown() {
        driver.quit();
    }

    @Test
    void testNameSection() {
        String header = section.findElement(By.tagName("h2")).getText().replaceAll("\\s+", " ")
                .trim();
        assertEquals("Онлайн пополнение без комиссии",header);
    }

    @Test
    void testPaymentSystemLogos() {
        Set<String> expectedLogos = Set.of("Visa", "Verified By Visa", "MasterCard", "MasterCard Secure Code", "Белкарт");
        List<WebElement> paymentLogos = driver.findElements(By.cssSelector(".pay__partners img"));

        for (String logo : expectedLogos) {
            assertTrue(paymentLogos.stream().anyMatch(img -> logo.equals(img.getAttribute("alt"))),
                    "Логотип " + logo + " не найден");
        }
    }

    @Test
    void testMoreAboutService() {

        WebElement link = driver.findElement(By.linkText("Подробнее о сервисе"));
        link.click();
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions
                .urlContains("/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/"));

        assertTrue(driver.getCurrentUrl().contains("/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/"),
                "Переход не произошёл или URL неверный");
        driver.navigate().back();
    }
}
