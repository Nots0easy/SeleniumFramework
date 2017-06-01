package my.silenium.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    public static String homeURL = "https://www.google.com";
    private WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver = driver;
        driver.get(homeURL);
    }

    public SearchPage search(String text) {
        driver.findElement(By.id("lst-ib")).sendKeys(text);
        driver.findElement(By.id("_fZl")).click();
        return new SearchPage(driver);
    }
}
