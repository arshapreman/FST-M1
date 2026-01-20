package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity2 {

	public static void main(String[] args) {
		FirefoxDriver driver = new FirefoxDriver();
	     driver.get("https://training-support.net/webelements/login-form");
	     System.out.println(driver.getTitle());
	     driver.findElement(By.id("username")).sendKeys("admin");
	     driver.findElement(By.id("password")).sendKeys("password");
	     driver.findElement(By.xpath("//button[text()='Submit']")).click();
	     driver.quit();
	     
		   

	}

}
