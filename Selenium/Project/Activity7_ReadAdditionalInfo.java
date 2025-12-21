package crm;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity7_ReadAdditionalInfo {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver =null;
		
		try
		{
	     driver = new FirefoxDriver();
	     driver.get("http://alchemy.hguy.co/crm");
	     driver.manage().window().maximize();
	     driver.findElement(By.id("user_name")).sendKeys("admin");
	     driver.findElement(By.id("username_password")).sendKeys("pa$$w0rd");
	     driver.findElement(By.id("bigbutton")).click();
	     Thread.sleep(1000);
	     System.out.println(driver.getTitle());
	     WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
	     WebElement menu = driver.findElement(By.id("grouptab_0"));
	     wait.until(ExpectedConditions.elementToBeClickable(menu));
	     menu.click();
	     
	     WebElement submenu = driver.findElement(By.id("moduleTab_9_Leads"));
	     wait.until(ExpectedConditions.elementToBeClickable(submenu));
	     submenu.click();
	     
	    Thread.sleep(7000);
	   
	     
	     WebElement addressicon = driver.findElement(By.xpath("(//a[text()='nikita@gmail.com']//following::span[@title='Additional Details'])[1]"));
	     wait.until(ExpectedConditions.elementToBeClickable(addressicon));
	     addressicon.click();
	     
	     Thread.sleep(7000);
	     String mobilenumber =driver.findElement(By.xpath("//span[@class='phone']")).getText();
	     
	     System.out.println(mobilenumber);
	     
	     
		}catch (Exception e) 
		{
			
			System.out.println(e.getMessage());
		}
	    finally {
	    	
	    	 driver.quit();
			
		} 
	        
	        
	    
	     

	}

}
