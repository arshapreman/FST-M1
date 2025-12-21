package crm;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity8_Tables1 
{

	public static void main(String[] args) throws InterruptedException 
	{
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
		     WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(80));
		     WebElement menu = driver.findElement(By.id("grouptab_0"));
		     wait.until(ExpectedConditions.elementToBeClickable(menu));
		     menu.click();
		     driver.findElement(By.id("moduleTab_9_Accounts")).click();
		     Thread.sleep(5000);
		     WebElement table =driver.findElement(By.xpath("//table[@class='list view table-responsive']"));
		     List<WebElement> rows = table.findElements(By.tagName("tr"));
		     System.out.println(" Names from the list with odd rows ");
		     Thread.sleep(1000);
		     
		     for (int i = 1; i < rows.size(); i += 2) {  
	                if (i >= 13) break;  
	                WebElement row = rows.get(i);
	                WebElement nameCell = row.findElements(By.tagName("td")).get(2);  
	                System.out.println(nameCell.getText());  
	            }
		     
		    		 }
         
		catch (Exception e) 
		{
			System.out.println(e.getMessage());
			}
finally {
	 driver.quit();
}
	}

	
}
