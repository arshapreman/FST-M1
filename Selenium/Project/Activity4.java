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

public class Activity4 {

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
    @Test
    public void Activity4() throws InterruptedException
    {
        String heading2 = driver.findElement(By.xpath("//h2[text()='Quia quis non']")).getText();
        System.out.println(heading2);
        Thread.sleep(2000);
        Assert.assertEquals(heading2, "Quia quis non");
    }
    @AfterMethod
    public void tearDown()
    {
        System.out.println("Driver Closing...");
        driver.quit();

    }

}
