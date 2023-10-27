import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class BaseTest {


    protected WebDriver driver;

    @BeforeTest
    public void driverSetup(){
        //driver = new ChromeDriver(); ne koristiti za driver
        //izvrsiti pre svih testova
    }

    @BeforeMethod
    public void setUpDriver(){
        driver = new ChromeDriver();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.manage().window().maximize();
        driver.get("https://magento.softwaretestingboard.com/");
    }


    @AfterMethod
    public void tearDown(){
        driver.quit();
    }


    protected WebElement getElement(By locator){
        return driver.findElement(locator);
    }

    protected void typeIn(By locator, String text){
        getElement(locator).sendKeys(text);
    }




}
