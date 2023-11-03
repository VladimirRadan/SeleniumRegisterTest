import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import util.Utils;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class BaseTest {


    protected WebDriver driver;
    protected Actions actions;
    protected WebDriverWait wait;

    @BeforeTest
    public void driverSetup(){
        //driver = new ChromeDriver(); ne koristiti za driver
        //izvrsiti pre svih testova
    }

    @BeforeMethod
    public void setUpDriver(){
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        actions = new Actions(driver);
        Utils.waitForSeconds(3);
        driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        //driver.get("https://magento.softwaretestingboard.com/");
        //driver.get("https://demowebshop.tricentis.com/");
    }


//    @AfterMethod
//    public void tearDown(){
//        driver.quit();
//    }


    protected WebElement getElement(By locator){
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        //return driver.findElement(locator);
    }

    protected void typeIn(By locator, String text){
        getElement(locator).sendKeys(text);
    }

    protected void clickOnRandomElement(By locator){
        List<WebElement> list = driver.findElements(locator);
        Random random = new Random();
        int randomElement = random.nextInt(list.size());
        list.get(randomElement).click();
    }

    protected void hover(By locator, long wait){
        WebElement element = getElement(locator);
        new Actions(driver)
                .moveToElement(element)
                .pause(wait)
                .build()
                .perform();
    }

    protected void hoverAndClick(By locator, long wait){
        WebElement element = getElement(locator);
        new Actions(driver)
                .moveToElement(element)
                .pause(wait)
                .click()
                .build()
                .perform();
    }




}
