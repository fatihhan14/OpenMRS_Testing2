package Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Base_Driver {
    public static WebDriver driver;
    public static WebDriverWait wait;
    public static List<String> idList = new ArrayList<>();



    @BeforeMethod(groups = "Smoke")
    public void StartsSM() {
        Logger logger = Logger.getLogger("");
        logger.setLevel(Level.SEVERE);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    @AfterMethod(groups = "Smoke")
    public void FinishSM() {
        Function.Wait(2);
        driver.quit();
    }

    @BeforeClass(groups = "Regression")
    public void StartsRG() {
        Logger logger = Logger.getLogger("");
        logger.setLevel(Level.SEVERE);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        Login();
    }

    @AfterClass(groups = "Regression")
    public void FinishRG() {
        Function.Wait(2);
        driver.quit();
    }

    public void Login() {
        driver.get("https://demo.openmrs.org/openmrs/login.htm");
        WebElement username = driver.findElement(By.xpath("//input[@placeholder='Enter your username']"));
        username.sendKeys("admin");
        WebElement password = driver.findElement(By.xpath("//input[@placeholder='Enter your password']"));
        password.sendKeys("Admin123");
        List<WebElement> locations = driver.findElements(By.cssSelector("[id='sessionLocation']>li"));
        int randomNumber = Function.RandomGenerator(locations.size());
        locations.get(randomNumber).click();
        WebElement loginButton = driver.findElement(By.cssSelector("input[id='loginButton']"));
        loginButton.click();
    }

    public void Click(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        scrollToElement(element);
        element.click();
    }

    public void Sendkeys(WebElement element, String text) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        scrollToElement(element);
        element.clear();
        element.sendKeys(text);
    }

    public void scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", element);
    }

    public void verifyContainsText(WebElement element, String value) {
        wait.until(ExpectedConditions.textToBePresentInElement(element, value));
        Assert.assertTrue(element.getText().toLowerCase().contains(value.toLowerCase()));
    }

    public void moveToElement(WebElement element) {
        Actions actions = new Actions(driver);
        wait.until(ExpectedConditions.visibilityOf(element));
        Action action = actions.moveToElement(element).build();
        action.perform();
    }
}
