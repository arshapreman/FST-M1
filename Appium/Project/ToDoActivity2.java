package project;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.net.URI;
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

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class ToDoActivity2 extends Gesture
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
		//Get the screen dimensions
		Dimension dims =driver.manage().window().getSize();
		System.out.println(dims.getWidth() + " " +dims.getHeight());
		int X = (int)(0.53*dims.getWidth());
		int Y =(int)(0.13*dims.getHeight());
		Point press = new Point(X, Y);
		wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.app.todolist:id/tv_exlv_task_name")));
		doLongPress(driver, press);
		WebElement name = driver.findElement(AppiumBy.id("android:id/title"));
		name.click();
		driver.findElement(AppiumBy.id("com.app.todolist:id/tv_todo_list_deadline")).click();
		driver.findElement(AppiumBy.id("android:id/next")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.accessibilityId("03 January 2026")));
		driver.findElement(AppiumBy.accessibilityId("03 January 2026")).click();
		driver.findElement(AppiumBy.id("com.app.todolist:id/bt_deadline_ok")).click();
		driver.findElement(AppiumBy.id("com.app.todolist:id/bt_new_task_ok")).click();
		String actualDeadline = driver.findElement(AppiumBy.id("com.app.todolist:id/tv_exlv_task_deadline")).getText();
		System.out.println(actualDeadline);
		String ExpectedDeadline ="Deadline: 03.01.2026";
		assertEquals(actualDeadline,ExpectedDeadline );
		
		
		
	}
	
	@AfterClass
	public void tearDown()
	{
driver.quit();
	}

}
