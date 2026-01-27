package activities;

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import examples.ActionsBase;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Activity6 extends ActionsBase
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
			wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			//Open the page
			driver.get("https://training-support.net/webelements/sliders");
		}
		@Test
		public void volume25Test()
		{
			//Get the screen dimensions
			Dimension dims =driver.manage().window().getSize();
			System.out.println(dims.getWidth() + " " +dims.getHeight());
			
			wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.SeekBar")));
			
			//Calculate the start and end points 
			
			int startX = (int)(0.5*dims.getWidth());
			int startY =(int)(0.72*dims.getHeight());
			Point start = new Point(startX, startY);
			
			int endX = (int)(0.34*dims.getWidth());
			int endY =(int)(0.72*dims.getHeight());
			Point end = new Point(endX, endY);
			// Move the slider
			
		ActionsBase.doSwipe(driver, start, end, 1500);
			
			//Get the volume text and assert
			
			String volumeText = driver.findElement(AppiumBy.xpath("//android.widget.TextView[contains(@text, '%')]")).getText();
			assertEquals(volumeText, "25%");
		
		}
		@Test
		public void volume75Test()
		{
			
			
		}
		
		
		@AfterClass
		public void tearDown()
		{
			driver.quit();
		}

}
