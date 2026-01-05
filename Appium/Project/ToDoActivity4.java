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
import org.openqa.selenium.JavascriptExecutor;
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
import io.appium.java_client.remote.SupportsContextSwitching;

public class ToDoActivity4  extends Gesture
{
	//Declaration of Objects
			AndroidDriver driver;
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
				options.setCapability("chromedriverAutodownload", true);
				options.noReset();

				// Server Address
				URL serverURL = new URI("http://localhost:4723").toURL();
				// Driver Initialization
				driver = new AndroidDriver(serverURL, options);
				wait = new WebDriverWait(driver, Duration.ofSeconds(60));
				//Open the page
				driver.get("https://training-support.net/webelements");
			}
			@Test
			public void testMethod() throws InterruptedException
			{
				/*
				
				Thread.sleep(3000);
				driver.findElement(By.xpath("//a/span[.='Alerts']")).click();
				
				
				driver.context("WEBVIEW_chrome");
			
				 WebElement todoListLocator = driver.findElement(By.xpath("//a/span[.='To-Do List']"));
				
				Gesture.scrollFromBottomToTop(driver,todoListLocator);
				
				*/

				Dimension dims = driver.manage().window().getSize();
		        System.out.println(dims);
		        Point start = new Point((int)(dims.getWidth() * 0.5), (int)(dims.getHeight() * 0.8));
		        Point end = new Point((int)(dims.getWidth() * 0.5), (int)(dims.getHeight() * 0.6));

		        // Wait for page to load
		        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(AppiumBy.xpath("//android.widget.TextView[@text='WebElements']")));

		        // Scroll(Fling) to the end of the page
		        doSwipe(driver, start, end, 50);

		        // Wait for To-Do list link and click it
		        wait.until(ExpectedConditions.elementToBeClickable(
		                AppiumBy.xpath("//android.widget.TextView[contains(@text,'To-Do List')]"))
		        ).click();

				System.out.println("Web is opened in Chrome");	
			wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"todo-input\"]")));
			WebElement input = driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"todo-input\"]"));
			WebElement addbtn = driver.findElement(AppiumBy.xpath("//android.widget.Button[@resource-id=\"todo-add\"]"));
			input.sendKeys("Add tasks to list");
			addbtn.click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"todo-input\"]")));
			input.sendKeys("Get number of tasks");
			addbtn.click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"todo-input\"]")));
			input.sendKeys("Clear the list");
			addbtn.click();
			
			List<WebElement> checkbox = driver.findElements(AppiumBy.className("android.widget.CheckBox"));
			int count = checkbox.size();
			System.out.println("Total number of Tasks: " +count);
			for (int i=0; i<checkbox.size();i++) 
			{
				 String isChecked = checkbox.get(i).getAttribute("checked");
				if(isChecked.equals("false"))
				{
					checkbox.get(i).click();	
				}
				else
				{
					System.out.println("Checkbox is already selected");
				}
			}
			
			assertEquals(count,5);
			}
			
			
			@AfterClass
			public void tearDown()
			{
				driver.quit();
			}

}
