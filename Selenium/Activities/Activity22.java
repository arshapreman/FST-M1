package activities;



import java.time.Duration;

import org.junit.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;



public class Activity22 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new FirefoxDriver();
	      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	      driver.get("https://training-support.net/webelements/popups");
	      System.out.println("Page title is: " + driver.getTitle());
	  //click the pop up button  
	     
	     driver.findElement(By.id("launcher")).click();
	     Thread.sleep(4000);
	     driver.findElement(By.id("username")).sendKeys("admin");
	     driver.findElement(By.id("password")).sendKeys("password");
	     driver.findElement(By.xpath("//button[text()='Submit']")).click();
	     String result1 = driver.findElement(By.xpath("//div/h1")).getText().trim();
	     String result2 = driver.findElement(By.xpath("//div/h2")).getText().trim();

	     String successMsg = result1 + " " + result2;
	     System.out.println(successMsg);

	     Assert.assertEquals(
	         successMsg,
	         "Login Success! Welcome Back, Admin!"
	     );

driver.quit();

	}

}
