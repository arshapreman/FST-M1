package project;

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.SupportsContextSwitching;

public class ToDoActivity5  extends Gesture
{
	//Declaration of Objects
	AppiumDriver driver;
	WebDriverWait wait;
	
	
	//setUp function
	@BeforeClass
	public void Setup() throws MalformedURLException, URISyntaxException
	{
	//Desired Capabalities
		// Desired Capabilities
		UiAutomator2Options options = new UiAutomator2Options();
		options.setPlatformName("android");
		options.setAutomationName("UiAutomator2");
		options.setAppPackage("com.android.chrome");
		options.setAppActivity("com.google.android.apps.chrome.Main");
		options.noReset();
		options.setCapability("chromedriverAutoDownload", true);
		// Server Address
		URL serverURL = new URI("http://localhost:4723").toURL();
		// Driver Initialization
		driver = new AndroidDriver(serverURL, options);
		wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		//Open the page
		driver.get("https://training-support.net/webelements");
	}
	@Test(priority=1)
	public void testPass() throws InterruptedException
	{
		Dimension dims = driver.manage().window().getSize();
        System.out.println(dims);
        Point start = new Point((int)(dims.getWidth() * 0.5), (int)(dims.getHeight() * 0.8));
        Point end = new Point((int)(dims.getWidth() * 0.5), (int)(dims.getHeight() * 0.5));

        // Wait for page to load
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(AppiumBy.xpath("//android.widget.TextView[@text='WebElements']")));

        // Scroll(Fling) to the end of the page
        doSwipe(driver, start, end, 150);
        Thread.sleep(2000);
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Login Form\"]")).click();
        WebElement username=wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"username\"]")));
    	username.sendKeys("admit");
    	WebElement password=wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"password\"]")));
    	password.sendKeys("password");
    	driver.findElement(AppiumBy.xpath("//android.widget.Button[@text=\"Submit\"]")).click();
    	Thread.sleep(3000);
        String failMsg = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"subheading\"]")).getText();
        assertEquals(failMsg, "Invalid credentials");
        username.clear();
        password.clear();
       
	}
	
	@Test(priority=2)
	public void testFail() throws InterruptedException
	{
		

        
        WebElement username=wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"username\"]")));
    	username.sendKeys("admin");
    	WebElement password=wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"password\"]")));
    	password.sendKeys("password");
    	driver.findElement(AppiumBy.xpath("//android.widget.Button[@text=\"Submit\"]")).click();
    	Thread.sleep(3000);
        String result1 = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Login Success!\"]")).getText();
        String result2 = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Welcome Back, Admin!\"]")).getText();
        String successMsg = result1 + result2;
        assertEquals(successMsg, "Login Success!Welcome Back, Admin!");
	}
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}

}
