package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Activity9 {

	public static void main(String[] args) {
		FirefoxDriver driver = new FirefoxDriver();
	     driver.get("https://training-support.net/webelements/keyboard-events");
	     System.out.println(driver.getTitle());
	     Actions keyboard = new Actions(driver);
	     WebElement input = driver.findElement(By.xpath("//p[@id='result']"));
	     keyboard.sendKeys("Hello").build().perform();
	     
	     String pageText = driver.findElement(By.cssSelector("h1.mt-3")).getText();
	     System.out.println(pageText);

	     driver.quit();
	     
	}

}
