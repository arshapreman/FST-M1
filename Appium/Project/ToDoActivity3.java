package project;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.net.URI;
import java.net.URL;
import java.time.Duration;
import java.util.List;

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

public class ToDoActivity3 extends Gesture 
{

	AppiumDriver driver;
	WebDriverWait wait;
	
	@BeforeClass
	public void Setup() throws Exception {

		File appFile = new File("src/test/resources/ts-todo-list-v1.apk");
		UiAutomator2Options caps = new UiAutomator2Options();
		caps.setPlatformName("android");
		caps.setAutomationName("UiAutomator2");
		caps.setApp(appFile.getAbsolutePath());
		caps.noReset(); // Always resetting the app before launching it 
		//Set the appium server url
		URL serverURL = new URI("http://localhost:4723/").toURL();
	//Initialse android driver
		driver = new AndroidDriver(serverURL, caps);
		wait = new WebDriverWait(driver, Duration.ofSeconds(80));

	}

	@Test
	public void testMethod() throws InterruptedException
	
	{
		List<WebElement> chkbox = driver.findElements(AppiumBy.id("com.app.todolist:id/cb_task_done"));
		System.out.println("Total number of Tasks: " +chkbox.size());
		for (int i=0; i<chkbox.size()-1;i++) 
		{
			 String isChecked = chkbox.get(i).getAttribute("checked");
			if(isChecked.equals("false"))
			{
				chkbox.get(i).click();	
			}
			else
			{
				System.out.println("Checkbox is already selected");
			}
		}
		Dimension dims =driver.manage().window().getSize();
		int X = (int)(0.48*dims.getWidth());
		int Y =(int)(0.27*dims.getHeight());
	
				
		Point press = new Point(X, Y); 
		doLongPress(driver, press);
		WebElement edit = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/title\" and @text=\"Edit To-Do Task\"]"));
		edit.click();
		Point slideStart = new Point((int) (dims.getWidth() * 0.32), (int) (dims.getHeight() * 0.54));
		Point sliderEnd = new Point((int) (dims.getWidth() * 0.60), (int) (dims.getHeight() * 0.54));
		doSwipe(driver, slideStart, sliderEnd, 2000);
		Thread.sleep(2000);
		driver.findElement(AppiumBy.id("com.app.todolist:id/bt_new_task_ok")).click();
		driver.findElement(AppiumBy.accessibilityId("More options")).click();
		wait.until(ExpectedConditions.elementToBeClickable((AppiumBy.xpath("//android.widget.TextView[@text=\"Completed tasks\"]"))));
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Completed tasks\"]")).click();
		Thread.sleep(1000);
		int completedTasks = driver.findElements(AppiumBy.id("com.app.todolist:id/tv_exlv_task_name")).size();
		System.out.println("Total number of Completed tasks: " +completedTasks);
		assertEquals(completedTasks, 2);
		
		
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}


}
