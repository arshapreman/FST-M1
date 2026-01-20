package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity7 {

	public static void main(String[] args)
	{
		FirefoxDriver driver = new FirefoxDriver();
	     driver.get("https://training-support.net/webelements/dynamic-controls");
	     System.out.println(driver.getTitle());
	     WebElement textbox = driver.findElement(By.id("textInput"));
	     System.out.println("Is textbox enabled? "  +textbox.isEnabled());
	     WebElement enabletextbox = driver.findElement(By.xpath("//button[text()='Enable Input']"));
	     enabletextbox.click();
	     System.out.println("After enabling textbox");
	     System.out.println("is checkbox selected? "  +textbox.isEnabled());
	     driver.quit();
	}

}
