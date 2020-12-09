import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;



public class Relui_test {

    WebDriver driver = new EdgeDriver();

    @Before()
    public void BrowserSetup(){
        driver=new EdgeDriver();
    }

    @Test
    public void AddingItemsToCartTest() throws InterruptedException {

        driver.get("https://relouis.by/collection/complimenti/");
        WebElement chooseProduct = waitForElementLocatedBy(driver, By.xpath("//div[@datatype=\"4810438013055\"]"));
        chooseProduct.click();
        WebElement goToCart = waitForElementLocatedBy(driver, By.linkText("Перейти в корзину"));
        goToCart.click();

        Assert.assertTrue(waitForElementLocatedBy(driver,By.xpath("//div[@datatype=\"4810438013055\"]")).isDisplayed());

    }


    @After()
    public void driverShutDown(){
        driver.quit();
        driver=null;
    }

    private static WebElement waitForElementLocatedBy(WebDriver driver, By by){
        return new WebDriverWait(driver,50)
                .until(ExpectedConditions.presenceOfElementLocated(by));
    }


}
