package my.silenium.training;

import com.google.common.base.Predicate;
import my.silenium.pageobjects.*;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class SearchTest1 extends Assert {
    @Test
    public void testSearchATInfo() {
        WebDriver driver = new ChromeDriver();
    /*    WebDriverWait waiter = new WebDriverWait(driver, 10);
        waiter.ignoring(NoSuchElementException.class).pollingEvery(2, TimeUnit.SECONDS)
                .until(ExpectedConditions.attributeContains(By.id("bla"), "name", "dfd")); //need change
        driver.switchTo().frame(driver.findElement(By.xpath("!!"))); //need change
        driver.switchTo().defaultContent();    // return back to page DOM from frame
        driver.switchTo().window("Name of pop-up");   //need change*/
        HomePage home = new HomePage(driver);
        SearchPage searchResult = home.search("automated testing info");
        Assert.assertTrue(searchResult.getFirstLink().contains("automated"));
        driver.close();
    }

    @Test
    public void testSearchVodka() {
        WebDriver driver = new ChromeDriver();
        HomePage home = new HomePage(driver);
        SearchPage searchResult = home.search("Vodka");
        Assert.assertTrue(searchResult.getSecondLink().contains("Vodka"));
        driver.close();
    }

    @Test
    public void testSearchUkraine() {
        WebDriver driver = new ChromeDriver();
        HomePage home = new HomePage(driver);
        SearchPage searchResult = home.search("Ukraine");
        Assert.assertTrue(searchResult.getSecondLink().contains("Ukraine"));
        driver.close();
    }
}
