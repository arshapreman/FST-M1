package crm;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Activity4_LogintoSite {

	public static void main(String[] args) throws InterruptedException {
		FirefoxDriver driver = new FirefoxDriver();
	     driver.get("http://alchemy.hguy.co/crm");
	     driver.findElement(By.id("user_name")).sendKeys("admin");
	     driver.findElement(By.id("username_password")).sendKeys("pa$$w0rd");
	     driver.findElement(By.id("bigbutton")).click();
	     Thread.sleep(1000);
	     System.out.println(driver.getTitle());
	     driver.quit();
	     
	}
	}


