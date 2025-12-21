package crm;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity3_PrintFooter {

	public static void main(String[] args) {
		FirefoxDriver driver = new FirefoxDriver();
	     driver.get("http://alchemy.hguy.co/crm");
	     System.out.println(driver.getTitle());
	     String footerText =driver.findElement(By.id("admin_options")).getText();
	     System.out.println(footerText);
	     driver.quit();
	}

}
