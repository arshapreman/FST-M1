package crm;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;


public class Activity1_Verifythewebsitetitle {

	public static void main(String[] args)
	{
		
		FirefoxDriver driver = new FirefoxDriver();
	    driver.get("http://alchemy.hguy.co/crm");
	    String actualTitle = driver.getTitle();
        System.out.println("Website title is: " +actualTitle);
        Assert.assertEquals(actualTitle, "SuiteCRM", "Title does not match!");
        driver.quit();
	    
	}

}
