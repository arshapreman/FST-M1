package Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Activity8 {
    WebDriver driver;
    WebDriverWait wait;
    @BeforeMethod
    public void setup()
    {
        System.out.println("Driver Launch...");
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.get("https://alchemy.hguy.co/jobs/wp-admin");
    }
@Test
public void login()
{
    driver.findElement(By.id("user_login")).sendKeys("root");
    driver.findElement(By.id("user_pass")).sendKeys("pa$$w0rd");
    driver.findElement(By.id("wp-submit")).click();
    String pageTitle = driver.getTitle();
    System.out.println(pageTitle);
    Assert.assertEquals(pageTitle,"Dashboard ‹ Alchemy Jobs — WordPress" );
}


    @AfterMethod
    public void tearDown()
    {
        System.out.println("Driver Closing...");
        driver.quit();

    }
}


