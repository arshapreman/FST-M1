package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Activity10 {

	public static void main(String[] args)
	{
		FirefoxDriver driver = new FirefoxDriver();
	     driver.get("https://training-support.net/webelements/drag-drop");
	     System.out.println(driver.getTitle());
	     WebElement Ball = driver.findElement(By.id("ball"));
	     WebElement Basket1 = driver.findElement(By.id("dropzone1"));
	     WebElement Basket2 = driver.findElement(By.id("dropzone2"));
	     
	     Actions action = new Actions(driver);
	     action.dragAndDrop(Ball, Basket1);
	     if(Basket1.findElement(By.className("dropzone-text")).getText().equals("Dropped!")) {
	        	System.out.println("Ball was dropped in Dropzone 1");
	        }
	     
	     

	}

}
