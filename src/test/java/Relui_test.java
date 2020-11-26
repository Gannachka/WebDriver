import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import java.util.List;
import java.util.concurrent.TimeUnit;

public class Relui_test {

    public static String expectedResult = "COMPLIMENTI! СУПЕРОБЪЕМНАЯ" ;
    WebDriver driver = new EdgeDriver();

    @BeforeMethod(alwaysRun = true)
    public void BrowserSetup(){
        driver=new EdgeDriver();
    }

    @Test
    public void AddingItemsToCartTest() throws InterruptedException {

        driver.get("https://relouis.by/collection/complimenti/");
        WebElement chooseProduct = driver.findElement(By.xpath("//div[@datatype=\"4810438013055\"]"));
        chooseProduct.click();
        WebElement goToCart = waitForElementLocatedBy(driver, By.linkText("Перейти в корзину"));
        goToCart.click();

        Assert.assertEquals(waitForElementLocatedBy(driver,By.xpath("//div[@class='cart-block-item-name']")).getText(), expectedResult);

    }


    @AfterMethod(alwaysRun = true)
    public void driverShutDown(){
        driver.quit();
        driver=null;
    }

    private static WebElement waitForElementLocatedBy(WebDriver driver, By by){
        return new WebDriverWait(driver,4)
                .until(ExpectedConditions.presenceOfElementLocated(by));
    }


}
