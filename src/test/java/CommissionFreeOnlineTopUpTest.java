
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.math.BigDecimal;
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
        String title = section.findElement(By.tagName("h2")).getText().replaceAll("\\s+", " ")
                .trim();
        assertEquals("Онлайн пополнение без комиссии", title);
    }

    @Test
    void testPaymentSystemLogos() {
        Set<String> expectedLogos = Set.of("Visa", "Verified By Visa", "MasterCard", "MasterCard Secure Code", "Белкарт");
        List<WebElement> paymentLogos = section.findElements(By.cssSelector(".pay__partners img"));

        for (String logo : expectedLogos) {
            assertTrue(paymentLogos.stream().anyMatch(img -> logo.equals(img.getAttribute("alt"))),
                    "Логотип " + logo + " не найден");
        }
    }

    @Test
    void testMoreAboutService() {
        WebElement moreInfoLink = driver.findElement(By.linkText("Подробнее о сервисе"));
        String expectedUrl = moreInfoLink.getAttribute("href");
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", moreInfoLink);

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(2));
        try {
            moreInfoLink.click();
        } catch (TimeoutException e) {}

        assertTrue(driver.getCurrentUrl().contains(expectedUrl));
    }

    @Test
    void testContinue() {
        String expectedPhone = "297777777";
        String expectedSum = "450";
        WebElement phone = section.findElement(By.id("connection-phone"));
        phone.click();
        phone.sendKeys(expectedPhone);
        WebElement sum = section.findElement(By.id("connection-sum"));
        sum.click();
        sum.sendKeys(expectedSum);
        WebElement email = section.findElement(By.id("connection-email"));
        email.click();
        email.sendKeys("test.test@mail.ru");
        WebElement continueButton = section.findElement(By.id("pay-connection")).findElement(By.tagName("button"));
        continueButton.click();

        WebElement iframe = new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.presenceOfElementLocated(By.className("payment-widget-iframe")));
        driver.switchTo().frame(iframe);

        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.textToBePresentInElementLocated(
                        By.cssSelector(".payment-page__container span"),
                        "BYN"
                ));

        String actualSum = driver.findElement(By.cssSelector(".payment-page__container span")).getText()
                .replaceAll("[^\\d.]", "");
        assertTrue(new BigDecimal(actualSum)
                .compareTo(new BigDecimal(expectedSum)) == 0, "Суммы не совпадают");

        String actualPhone = driver.findElement(By.cssSelector(".pay-description__text span")).getText()
                .replaceFirst(".*?375", "");
        assertTrue(actualPhone.equals(expectedPhone));

    }
}
