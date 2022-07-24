import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ApplicationDebitCard {

    private WebDriver driver;


    @BeforeAll
    static void setUpAll() {
        System.setProperty("webdriver.chrome.driver", "/Users/vladislavorlov/Documents/Java Netology/auto home/autoHome2.1/driver/chromedriver");

    }

    @BeforeEach
    void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--no-sandbox");
        options.addArguments("--headless");
        driver = new ChromeDriver();
    }


    @Test
    void newCardApplication(){
        driver.get("http://localhost:9999");

        driver.findElement(By.cssSelector("span[data-test-id='name'] input")).sendKeys("Михайлов Олег");
        driver.findElement(By.cssSelector("span[data-test-id='phone'] input")).sendKeys("+79253285723");
        driver.findElement(By.className("checkbox__box")).click();
        driver.findElement(By.className("button__text")).click();
        String text = driver.findElement(By.className("paragraph")).getText();
        assertEquals("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.", text.trim());

    }
    @Test
    void newCardApplicationDoubleSurname(){
        driver.get("http://localhost:9999");

        driver.findElement(By.cssSelector("span[data-test-id='name'] input")).sendKeys("Ивано-Франк Константин");
        driver.findElement(By.cssSelector("span[data-test-id='phone'] input")).sendKeys("+79253273026");
        driver.findElement(By.className("checkbox__box")).click();
        driver.findElement(By.className("button__text")).click();
        String text = driver.findElement(By.className("paragraph")).getText();
        assertEquals("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.", text.trim());

    }


    @AfterEach
    void tearDown() {
        driver.quit();
        driver = null;
    }

}
