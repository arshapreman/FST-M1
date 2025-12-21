package crm;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity6_MenuCheck {

	public static void main(String[] args) throws InterruptedException {
		FirefoxDriver driver = new FirefoxDriver();
	     driver.get("http://alchemy.hguy.co/crm");
	     driver.findElement(By.id("user_name")).sendKeys("admin");
	     driver.findElement(By.id("username_password")).sendKeys("pa$$w0rd");
	     driver.findElement(By.id("bigbutton")).click();
	     Thread.sleep(1000);
	     System.out.println(driver.getTitle());
	     WebElement menu = driver.findElement(By.id("grouptab_3"));
	     String menuText = menu.getText();
	     System.out.println(menuText);
	     
	     Thread.sleep(1000);
	     if (menu.isDisplayed())
	    	 System.out.println("Activities menu exist");
	     else
	    	 System.out.println("Menu doesnt exist");
	     
	     driver.quit();
	     
	}

}
