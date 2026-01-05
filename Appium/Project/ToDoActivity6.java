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

public class ToDoActivity6  extends Gesture
{
	private static final String Dependson = null;
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
	public void LaunchPop() throws InterruptedException
	{
		Dimension dims = driver.manage().window().getSize();
        System.out.println(dims);
        Point start = new Point((int)(dims.getWidth() * 0.5), (int)(dims.getHeight() * 0.8));
        Point end = new Point((int)(dims.getWidth() * 0.5), (int)(dims.getHeight() * 0.5));

        // Wait for page to load
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(AppiumBy.xpath("//android.widget.TextView[@text='WebElements']")));

        By popupsCard = AppiumBy.xpath(
        	    "//android.view.View[@content-desc='Popups Work with popups!']"
        	);

        	int maxSwipes = 5;
        	while (maxSwipes-- > 0) 
        	{
        	    try {
        	        driver.findElement(popupsCard).click();
        	        break;
        	    } catch (Exception e) {
        	        doSwipe(driver, start, end, 200);
        	        Thread.sleep(1000);
        	    }
        	}

        
	}
	
	@Test(dependsOnMethods = "LaunchPop" ) 
	public void enterCredentials() throws InterruptedException
	{
		Dimension dims = driver.manage().window().getSize();
		 wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(AppiumBy.xpath("//android.widget.Button[@resource-id='launcher']")));
		driver.findElement(AppiumBy.xpath("//android.widget.Button[@resource-id='launcher']")).click();
		Point tap = new Point((int)(dims.getWidth() * 0.5), (int)(dims.getHeight() * 0.27));
		doLongPress(driver, tap);
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
