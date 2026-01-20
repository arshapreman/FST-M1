package activities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity14 {
	public static void main(String[] args) {
		  WebDriver driver = new FirefoxDriver();
	      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    
	      driver.get("  https://training-support.net/webelements/tables");
	      System.out.println("Page title is: " + driver.getTitle());
	      
	      int rowSize=  driver.findElements(By.xpath("//tbody/tr")).size();
	      System.out.println("Total Rows in the table " +rowSize);
	      
	      int colSize  = driver.findElements(By.xpath("//thead/tr/th")).size();
	        System.out.println("Number of columns: " +colSize);
//5th row's  book name
	        String bookName = driver.findElement(By.xpath("//tbody/tr[5]/td[2]")).getText();
	        System.out.println("Bookname in 5th row before sort: " + bookName);
	        
	        //Sort the price column in asc order
	        driver.findElement(By.xpath("//thead/tr/th[text()='Price']")).click();
	        
	        String bookNameSorted = driver.findElement(By.xpath("//tbody/tr[5]/td[2]")).getText();
	        System.out.println("Bookname in 5th row after sorting the price:  " + bookNameSorted);
	        
	        
	        driver.quit();

}
}
