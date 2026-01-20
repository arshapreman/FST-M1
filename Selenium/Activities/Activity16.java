package activities;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity16 {

	public static void main(String[] args) {
		 WebDriver driver = new FirefoxDriver();
	      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	      driver.get("https://training-support.net/webelements/selects");
	      System.out.println("Page title is: " + driver.getTitle());
	      
	      WebElement dropdown = driver.findElement(By.xpath("//div/select"));
	      Select options = new Select(dropdown);
	      options.selectByVisibleText("Two");
	      System.out.println("Second option by Visible text: "+ options.getFirstSelectedOption().getText());
	      options.selectByIndex(3);
	      System.out.println("Third Option by Index : "+ options.getFirstSelectedOption().getText());
	      options.selectByValue("four");
	      System.out.println("Fourth Option by Value "+ options.getFirstSelectedOption().getText());
	  
	        List<WebElement> allOptions = options.getOptions();
	        System.out.println("All Options in the dropdown: ");
	        for(WebElement option : allOptions) 
	        {
	            System.out.println(option.getText());
	        }

	      
	      
	      driver.quit();
	      


	}

}
