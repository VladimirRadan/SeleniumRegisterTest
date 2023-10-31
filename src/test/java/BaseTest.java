import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.util.List;
import java.util.Random;

public class BaseTest {


    protected WebDriver driver;
    protected Actions actions;

    @BeforeTest
    public void driverSetup(){
        //driver = new ChromeDriver(); ne koristiti za driver
        //izvrsiti pre svih testova
    }

    @BeforeMethod
    public void setUpDriver(){
        driver = new ChromeDriver();
        actions = new Actions(driver);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.manage().window().maximize();
        //driver.get("https://magento.softwaretestingboard.com/");
        //driver.get("https://demowebshop.tricentis.com/");
    }


//    @AfterMethod
//    public void tearDown(){
//        driver.quit();
//    }


    protected WebElement getElement(By locator){
        return driver.findElement(locator);
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
