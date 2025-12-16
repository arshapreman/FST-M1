package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity1 {

	public static void main(String[] args) {
		FirefoxDriver driver = new FirefoxDriver();
	    
	    driver.get("https://training-support.net");
	    System.out.println(driver.getTitle());
	    driver.findElement(By.linkText("About Us")).click();
	   
	    System.out.println(driver.getTitle());
	    driver.quit();
	}

}
