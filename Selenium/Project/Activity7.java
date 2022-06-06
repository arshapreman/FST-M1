package Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Activity7 {

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
    public void Activity7() throws InterruptedException
    {
        driver.findElement(By.xpath("//a[text()='Post a Job']")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("create_account_email")).sendKeys("arsha1@test.com");
        driver.findElement(By.id("job_title")).sendKeys("FST");
        //driver.switchTo().frame("job_description_ifr");
        WebElement Description = driver.findElement(By.xpath("//iframe[contains(@id, 'job_description_ifr')]"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
        Description.sendKeys("Test FST description");
        // driver.switchTo().defaultContent();
        driver.findElement(By.id("application")).sendKeys("https://alchemy.hguy.co/jobs/post-a-job/");
        driver.findElement(By.id("company_name")).sendKeys("IBM");
        driver.findElement(By.xpath("//input[@value='Preview']")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
        driver.findElement(By.id("job_preview_submit_button")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
        driver.findElement(By.xpath("//a[text()='click here']")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
        String JobTitle=  driver.findElement(By.xpath("//h1[@class='entry-title']")).getText();
        Assert.assertEquals(JobTitle,"FST");

    }

}
