package activities;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity13 {
	
	public static void main(String[] args) {
		  WebDriver driver = new FirefoxDriver();
	      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    
	      driver.get("  https://training-support.net/webelements/tables");

	      System.out.println("Page title is: " + driver.getTitle());
	    int rowSize=  driver.findElements(By.xpath("//tbody/tr")).size();
	      System.out.println("Total Rows in the table " +rowSize);
	      
	      int colSize  = driver.findElements(By.xpath("//thead/tr/th")).size();
	        System.out.println("Number of columns: " +colSize);
	        
	        //Third row
	        String rowValues = driver.findElement(By.xpath("//tbody/tr[3]")).getText();
	        System.out.println("Value in 3rd row of the table : " + rowValues);
	        
	        String bookName = driver.findElement(By.xpath("//tbody/tr[2]/td[2]")).getText();
	        System.out.println(" Value in the 2nd row 2nd column: " + bookName);
	        
	        driver.quit();
}
}
