package activities;

import org.openqa.selenium.support.Color;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity4 {

	public static void main(String[] args) {
		FirefoxDriver driver = new FirefoxDriver();
	     driver.get("https://training-support.net/webelements/target-practice");
	     System.out.println(driver.getTitle());
	     String heading3= driver.findElement(By.xpath("//div/h3[text()='Heading #3']")).getText();
	     System.out.println(heading3);
	     
	     Color fifthHeaderColor = Color.fromString(driver.findElement(By.xpath("//h5[contains(text(), '#5')]")).getCssValue("color"));
	        System.out.println("Color as RGB: " + fifthHeaderColor.asRgb());
	        System.out.println("Color as hexcode: " + fifthHeaderColor.asHex());
		
	     // Find the violet button and print all its classes
	        String purpleButtonClass = driver.findElement(By.xpath("//button[text()='Purple']")).getDomAttribute("class");
	        System.out.println(purpleButtonClass);
	        // Find the grey button and print its text
	        String slateButtonText = driver.findElement(By.xpath("//button[contains(@class, 'slate')]")).getText();
	        System.out.println(slateButtonText);

	        // Close the browser
	        driver.quit();
	}

}
