package Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class Activity5 {
    WebDriver driver;
    WebDriverWait wait;
    @BeforeMethod
    public void setup()
    {
        System.out.println("Driver Launch...");
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.get("https://alchemy.hguy.co/jobs/");
    }

    @AfterMethod
    public void tearDown()
    {
        System.out.println("Driver Closing...");
        driver.quit();

    }
    @Test
    public void Activity5() throws InterruptedException
    {
        driver.findElement(By.xpath("//a[text()='Jobs']")).click();
        Thread.sleep(2000);
        String pageJob = driver.getTitle();
        System.out.println(pageJob);
        Assert.assertEquals(pageJob, "Jobs – Alchemy Jobs");
    }
}
