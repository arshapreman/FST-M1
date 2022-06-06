package Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Activity6 {
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
    public void Activity6() throws InterruptedException
    {
        driver.findElement(By.xpath("//a[text()='Jobs']")).click();
        Thread.sleep(2000);
        WebElement search = driver.findElement(By.id("search_keywords"));
        search.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
        search.sendKeys("Banking");
        driver.findElement(By.xpath("//input[@type='submit' and @value='Search Jobs']")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
        WebElement element= driver.findElement(By.xpath("//ul[@class='job_listings']//li//h3[text()='Banking']"));
        wait = new WebDriverWait (driver, Duration.ofSeconds(100));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='job_listings']//li//h3[text()='Banking']")));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
        driver.findElement(By.xpath("//input[@value='Apply for job']")).click();
        String email=driver.findElement(By.xpath("//a[text()='abcqqwe@gmail.com']")).getText();
        System.out.println(email);
    }
}
