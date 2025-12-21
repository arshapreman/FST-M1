package crm;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.Color;

public class Activity5_GetColor {

	public static void main(String[] args) throws InterruptedException {
		FirefoxDriver driver = new FirefoxDriver();
	     driver.get("http://alchemy.hguy.co/crm");
	     driver.findElement(By.id("user_name")).sendKeys("admin");
	     driver.findElement(By.id("username_password")).sendKeys("pa$$w0rd");
	     driver.findElement(By.id("bigbutton")).click();
	     Thread.sleep(1000);
	     System.out.println(driver.getTitle());
         WebElement navigationMenu = driver.findElement(By.id("toolbar"));
         String rgbaColor = navigationMenu.getCssValue("background-color");
         String hexColor = Color.fromString(rgbaColor).asHex();
         System.out.println("Navigation menu color (RGBA): " + rgbaColor);
         System.out.println("Navigation menu color (HEX): " + hexColor);

	     driver.quit();

	}

}
