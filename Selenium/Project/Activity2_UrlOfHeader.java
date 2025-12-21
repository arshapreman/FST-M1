package crm;

import org.openqa.selenium.By;

import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity2_UrlOfHeader {

	public static void main(String[] args) {
		FirefoxDriver driver = new FirefoxDriver();
	     driver.get("http://alchemy.hguy.co/crm");
	     System.out.println(driver.getTitle());
	     String headerUrl = driver.findElement(By.tagName("img")).getAttribute("src");
         System.out.println("Header image URL: " + headerUrl);	
         driver.quit();
	}

}
