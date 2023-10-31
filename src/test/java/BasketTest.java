import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class BasketTest extends BaseTest {


    By headerMenuComputers = By.xpath("//ul[@class='top-menu']//a[contains(text(), 'Computers')]");
    By headerMenuNoteBooks = By.xpath("//ul[@class='top-menu']//a[contains(text(), 'Notebooks')]");
    By headerMenuBooks = By.xpath("//ul[@class='top-menu']//a[contains(text(), 'Books')]");

    By addProductToBasket = By.cssSelector("input[value='Add to cart']");

    By goToBasket = By.cssSelector(".ico-cart .cart-label");

    By productPrices = By.cssSelector(".product-subtotal");
    By totalAmount = By.cssSelector(".product-price > strong");

    @Test
    public void basketTest() throws InterruptedException {

        Thread.sleep(2000);
        hover(headerMenuComputers, 1000);
        hoverAndClick(headerMenuNoteBooks, 2000);
//        actions.moveToElement(getElement(headerMenuComputers))
//                .pause(Duration.ofMillis(500))
//                .moveToElement(getElement(headerMenuNoteBooks))
//                .click()
//                .perform();

        getElement(addProductToBasket).click();

        getElement(headerMenuBooks);
        clickOnRandomElement(addProductToBasket);
        clickOnRandomElement(addProductToBasket);

        getElement(goToBasket).click();

        driver.navigate().refresh();

        List<WebElement> list = driver.findElements(productPrices);
        double sum = 0;

        for (int i = 0; i < list.size(); i++) {
            sum += Double.parseDouble(list.get(i).getText());
        }

        System.out.println("Zbir je: " + sum);

        double total = Double.parseDouble(getElement(totalAmount).getText());

        System.out.println("Total je: " + total);

        Assert.assertTrue(sum == total, "Sum is not equal to Total!!!");
    }


}
