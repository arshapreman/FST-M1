package project;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class ToDoActivity1 
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
				String[] priorities = {"high", "medium", "low"};
				for (int i = 1; i <= 3; i++)
				{
					String priority = priorities[i - 1];

					String expectedText =
				            "Complete Activity " + i + " with priority " + priority;
				WebElement addbtn = driver.findElement(AppiumBy.id("com.app.todolist:id/fab_new_task"));
				wait.until(ExpectedConditions.elementToBeClickable(addbtn));
				addbtn.click();
				System.out.println("App is opened");
				wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.app.todolist:id/et_new_task_name")));
				
//				WebElement name =driver.findElement(AppiumBy.className("android.widget.EditText"));
				WebElement name =driver.findElement(AppiumBy.id("com.app.todolist:id/et_new_task_name"));
//				wait.until(ExpectedConditions.elementToBeSelected(name));
				
				name.sendKeys(expectedText);
				WebElement okbtn =driver.findElement(AppiumBy.id("com.app.todolist:id/bt_new_task_ok"));
//				wait.until(ExpectedConditions.elementToBeClickable(okbtn));
				okbtn.click();
				Thread.sleep(6000);
				
				  WebElement task = wait.until(
						  ExpectedConditions.visibilityOfElementLocated(AppiumBy.androidUIAutomator(  "new UiSelector().text(\"" + expectedText + "\")" ) )  );

			        assertEquals(task.getText(), expectedText);

				}
				
				
			}
			
			@AfterClass
			public void tearDown()
			{
		driver.quit();
			}

}
