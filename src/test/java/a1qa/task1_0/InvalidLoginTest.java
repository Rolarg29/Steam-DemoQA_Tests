package a1qa.task1_0;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class InvalidLoginTest {

    private static WebDriver driver;

    @BeforeSuite
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--lang=en");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
    }


    @Test
    public void testInvalidLogin() {
        //Navigate to main page
        driver.get("https://store.steampowered.com/");
        //1st  validation - main page is displayed
        String expectedTitle = "Welcome to Steam";
        Assert.assertEquals(expectedTitle, driver.getTitle());


        //Click Login button
        driver.findElement(By.xpath("//a[@class='global_action_link']")).click();
        //2nd validation - login page is displayed
        String expectedTitle2 = "Sign In";
        Assert.assertEquals(expectedTitle2, driver.getTitle());

        //Explicit wait -- wait for login page to be displayed
        WebElement userName = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='text']")));

        //input random strings as credentials. Click sign in button.
        //Username
        userName.sendKeys("r.ramirez");
        //Password
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("1234567");
        //click sign in button
        driver.findElement(By.xpath("//button[contains(@class,'SubmitButton')]")).click();

        //3rd validation - Loading element is displayed
        WebElement loadingElement = driver.findElement(By.xpath("//button[contains(@class,'Loading')]"));
        Assert.assertTrue(loadingElement.isDisplayed());

        //4th validation - Error message is displayed
        WebElement errorMessage = driver.findElement(By.xpath("//div[contains(@class,'FormError')]"));
        Assert.assertTrue(errorMessage.isDisplayed());
    }

    @AfterSuite
    public void tearDown() {
//        driver.quit();
    }

}
