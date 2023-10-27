import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class RegisterTest extends BaseTest{

    //By registerLink = By.linkText("Create an Account");
    By registerLink = By.cssSelector(".action.skip.contentarea + ul li:nth-child(3) > a");

    By firstNameField = By.xpath("//div[@class='control']/input[@name='firstname']");
    By lastNameField = By.xpath("//div[@class='control']/input[@name='lastname']");
    By emailField = By.xpath("//input[@id='email_address']");

    By passwordField = By.xpath("//input[@title='Password']");
    By confirmPasswordField = By.xpath("//input[@title='Confirm Password']");

    By button = By.xpath("//button[@title='Create an Account']/span");

    String email = System.currentTimeMillis() + "@email.com";


    //By registerLinkAbsoluth = By.cssSelector("body > div.page-wrapper > header > div.panel.wrapper > div > ul > li:nth-child(3) > a");
    // apsolutni lokator - ne koristiti


    @BeforeMethod
    public void setUp(){
        System.out.println("BeforeMethod");
    }

    @BeforeClass
    public void setupInClass(){
        System.out.println("Before Class");
    }

    @BeforeTest
    public void beforeTestSetup(){
        System.out.println("Before Test");
    }



    @Test(description = "Register user happy path - Expected result: User is registered...", priority = 0, groups = "Smoke")
    public void registerTest1() throws InterruptedException {
        Thread.sleep(2000);
        System.out.println("User: " + email);
        getElement(registerLink).click();
        typeIn(firstNameField, "Pera");
        typeIn(lastNameField, "Peric");
        typeIn(emailField, email);
        typeIn(passwordField, "Pera123456!");
        typeIn(confirmPasswordField, "Pera123456!");
        getElement(button).click();

    }

    @Test(dependsOnMethods = "registerTest1")
    public void registerTest2(){
        System.out.println("Register 2");
    }

    @Test(priority = 1)
    public void registerTest3(){
        System.out.println("Register 3");
    }




}
