package activities;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Activity2 
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

		// Server Address
		URL serverURL = new URI("http://localhost:4723").toURL();
		// Driver Initialization
		driver = new AndroidDriver(serverURL, options);
		//Open the page
		driver.get("https://training-support.net");
	}
	@Test
	public void testMethod()
	{
		String pageHeading = driver.findElement(AppiumBy.className("android.widget.TextView")).getText();
		assertEquals(pageHeading, "Training Support");
		//Find and tap about link
		driver.findElement(AppiumBy.accessibilityId("About Us")).click();
		pageHeading = driver.findElement(AppiumBy.className("android.widget.TextView")).getText();
		assertEquals(pageHeading, "About Us");
		
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}

}
