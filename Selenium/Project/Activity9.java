package Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Activity9 {
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
    public void login() throws InterruptedException {
        driver.findElement(By.id("user_login")).sendKeys("root");
        driver.findElement(By.id("user_pass")).sendKeys("pa$$w0rd");
        driver.findElement(By.id("wp-submit")).click();
        String pageTitle = driver.getTitle();
        System.out.println(pageTitle);
        Assert.assertEquals(pageTitle,"Dashboard ‹ Alchemy Jobs — WordPress" );
        WebElement jobListing = driver.findElement(By.xpath("//div[contains(text(),'Job Listings')]"));
        jobListing.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.xpath("//a[@class='page-title-action' and text()='Add New']")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
        driver.findElement(By.xpath("(//button[contains(@class,'components-button has-icon')])[5]")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        String jobPostTitle = "FST_Activity_9";
        WebElement positionTxtBx = driver.findElement(By.xpath("//textarea[contains(@id,'post-title-0')]"));
        positionTxtBx.sendKeys(jobPostTitle);
        Thread.sleep(3000);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement publishBtn = driver.findElement(By.xpath("//button[text()='Publish…']"));
        publishBtn.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
        driver.findElement(By.xpath("//button[text()='Publish']")).click();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
        wait = new WebDriverWait (driver, Duration.ofSeconds(100));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='View Job']")));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='View Job']")));
        driver.findElement(By.xpath("//a[text()='View Job']")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("entry-title")));
        String jobTitle = driver.findElement(By.className("entry-title")).getText();
        Assert.assertEquals(jobTitle, "FST_Activity_9");

    }


    @AfterMethod
    public void tearDown()
    {
        System.out.println("Driver Closing...");
        driver.quit();

    }
}
