package my.silenium.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPage {
    private WebDriver driver;

    public SearchPage(WebDriver driver){
        this.driver = driver;
    }

    public String getFirstLink() {
        return (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//*[@id='rso']/div[1]/div/div/div/div/h3/a"))).getText();

    }

    public String getSecondLink() {
        return (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//*[@id='rso']/div/div/div[2]/div/div/h3/a"))).getText();
    }
}
