
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;
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
        long start = System.currentTimeMillis();
        WebElement link = section.findElement(By.tagName("a"));
//        WebElement link = new WebDriverWait(driver, Duration.ofSeconds(5))
//                .until(ExpectedConditions.elementToBeClickable(By.linkText("Подробнее о сервисе")));//Долго

        link.click();
        System.out.println("Клик занял: " + (System.currentTimeMillis() - start) + " мс");
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions
                .urlContains("/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/"));


        driver.navigate().back();
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
        email.sendKeys("yana.dresvina@mail.ru");
        WebElement continueButton = section.findElement(By.id("pay-connection")).findElement(By.tagName("button"));
        continueButton.click();


        //WebElement iframe = driver.findElement(By.className("payment-widget-app"));
        WebElement iframe = new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.presenceOfElementLocated(By.className("payment-widget-iframe")));
        driver.switchTo().frame(iframe);

        WebElement popup = driver.findElement(By.className("payment-page__container"));

        WebElement sumInPopup = popup.findElement(By.cssSelector("pay-description__cost span"));
        String actualSum = sumInPopup.getText();
        BigDecimal actualSumDecimal = new BigDecimal(actualSum);
        BigDecimal expectedSumDecimal = new BigDecimal(expectedSum);
        assertTrue(actualSumDecimal.compareTo(expectedSumDecimal) == 0, "Суммы не совпадают");

    }
}
