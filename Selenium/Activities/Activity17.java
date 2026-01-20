package activities;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity17 {

	public static void main(String[] args) {
		 WebDriver driver = new FirefoxDriver();
	      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	      driver.get("https://training-support.net/webelements/selects");
	      System.out.println("Page title is: " + driver.getTitle());
	      
	    WebElement MultiDropdwn=  driver.findElement(By.xpath("//div/select[contains(@class, 'h-80')]"));
	    
	    Select options = new Select(MultiDropdwn);
	    options.selectByVisibleText("HTML");
	      System.out.println("Visible text: "+ options.getFirstSelectedOption().getText());
	      for(int i=3;i<=5;i++)
	      {
	    	  options.selectByIndex(i);
//	    	  System.out.println("By Index : " +i  +options.getAllSelectedOptions().get(i));
	      }

	      options.selectByValue("nodejs");
	      System.out.println("By  Value "+ options.getFirstSelectedOption().getText());
	      
	      // Print the selected options
	        List<WebElement> selectedOptions = options.getAllSelectedOptions();
	        System.out.println("Selected options are: ");
	        for (WebElement option : selectedOptions) {
	            System.out.println(option.getText());
	        }
	      
	      options.deselectByIndex(4);
	      System.out.println("Deselected JS");
	      
	      // Print the selected options
	      selectedOptions = options.getAllSelectedOptions();
	        System.out.println("Selected options are: ");
	        for (WebElement option : selectedOptions) {
	            System.out.println(option.getText());
	        }
	      
	      driver.quit();
	  

	}

}
