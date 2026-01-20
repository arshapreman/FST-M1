package activities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity15 {

	public static void main(String[] args) throws InterruptedException {
		  WebDriver driver = new FirefoxDriver();
	      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	      driver.get("https://training-support.net/webelements/dynamic-attributes");
	      System.out.println("Page title is: " + driver.getTitle());
	      Thread.sleep(60);
	    WebElement name=   driver.findElement(By.xpath("//input[contains(@id, 'full-name-')]"));
	    	name.sendKeys("FST");
	      WebElement email = driver.findElement(By.xpath("//input[@type='email']"));
	      email.sendKeys("fsttes@gmail.com");
	      WebElement eventDate = driver.findElement(By.xpath("//input[contains(@name, '-event-date-')]"));
	      eventDate.sendKeys("2025-06-26");
	      
	      WebElement details = driver.findElement(By.xpath("//label[text()='Additional Details']/following::textarea"));
	      details.sendKeys("Activity15");
	   
	      wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Submit']")));
	      driver.findElement(By.xpath("//button[text()='Submit']")).click();
	      String sucessmsg = driver.findElement(By.xpath("//div/h3[@id='action-confirmation']")).getText();
	     System.out.println(sucessmsg);

	      driver.quit();
		 
	}

}
