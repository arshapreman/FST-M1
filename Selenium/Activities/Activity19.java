package activities;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity19 {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
	      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	      driver.get("https://training-support.net/webelements/alerts");
	      System.out.println("Page title is: " + driver.getTitle());
	    //Accept the alert  
	     driver.findElement(By.id("confirmation")).click();
	     Alert alert = driver.switchTo().alert();
	     System.out.println(alert.getText());
	     alert.accept();
	     String result = driver.findElement(By.id("result")).getText();
	     System.out.println(result);
	     
	     //Cancel the alert
	     driver.findElement(By.id("confirmation")).click();
	     alert = driver.switchTo().alert();
	     System.out.println(alert.getText());
	     alert.dismiss();
	     result = driver.findElement(By.id("result")).getText();
	     System.out.println(result);
	     
	     driver.quit();
	     
	     
	     
	      
	      
	}

}
