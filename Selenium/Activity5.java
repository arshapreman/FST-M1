package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity5 {

	public static void main(String[] args) {
		FirefoxDriver driver = new FirefoxDriver();
	     driver.get("https://training-support.net/webelements/dynamic-controls");
	     System.out.println(driver.getTitle());
	     WebElement checkbox = driver.findElement(By.id("checkbox"));
	     System.out.println("is visible on the page? "  +checkbox.isDisplayed());
	     WebElement toggle = driver.findElement(By.xpath("//button[text()='Toggle Checkbox']"));
	     toggle.click();
	     System.out.println("is checbox visible now ? " +checkbox.isDisplayed());
	     driver.quit();

	}

}
