package project;
import static java.time.Duration.ofMillis;
import static org.openqa.selenium.interactions.PointerInput.MouseButton.LEFT;
import static org.openqa.selenium.interactions.PointerInput.Origin.viewport;
 
import java.time.Duration;
import java.util.Arrays;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.PointerInput.Kind;
import org.openqa.selenium.interactions.Sequence;
 
import io.appium.java_client.AppiumDriver;
 
public class Gesture {
	private final static PointerInput pointer = new PointerInput(Kind.TOUCH, "pointer");
	public static void doLongPress(AppiumDriver driver, Point start) {
	    // Create s sequence of actions
	    Sequence longPress = new Sequence(pointer, 1)
	            .addAction(pointer.createPointerMove(ofMillis(0), viewport(), start.getX(), start.getY()))
	            .addAction(pointer.createPointerDown(LEFT.asArg()))
	            .addAction(new Pause(pointer, Duration.ofMillis(1100)))
	            .addAction(pointer.createPointerUp(LEFT.asArg()));
 
	    // Perform the actions
	    driver.perform(Arrays.asList(longPress));
	}
 
 
	
	//Set the pointer type ->  by default it will be mouse so have to change to touch(pointer/finger)
		private static final PointerInput finger = new PointerInput(Kind.TOUCH, "finger");
		
	// Create the swipe action
		public static void doSwipe(AppiumDriver driver, Point start, Point end, int duration)
		{
			//create the sequence of actions
			Sequence swipe = new Sequence(finger, 1);
			swipe.addAction(finger.createPointerMove(ofMillis(0), viewport(), start.getX(), start.getY()));
			swipe.addAction(finger.createPointerDown(LEFT.asArg()));
			swipe.addAction(finger.createPointerMove(ofMillis(duration), viewport(), end.getX(), end.getY()));
			swipe.addAction(finger.createPointerUp(LEFT.asArg()));
			//Perform the actions
			driver.perform(Arrays.asList(swipe));
		}
		
		
		 public static void scrollFromBottomToTop(AppiumDriver driver, WebElement element) {
		        int screenWidth = driver.manage().window().getSize().width;
		        int screenHeight = driver.manage().window().getSize().height;

		        int startX = screenWidth / 2;
		        int startY = (int) (screenHeight * 0.8);
		        int endX = screenWidth / 2;
		        int endY = (int) (screenHeight * 0.2);

		        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");

		        int maxSwipes = 10; // Safety to prevent infinite loop
		        int swipes = 0;

		        while (!element.isDisplayed() && swipes < maxSwipes) {
		            Sequence swipe = new Sequence(finger, 1);
		            swipe.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY));
		            swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
		            swipe.addAction(finger.createPointerMove(Duration.ofMillis(800), PointerInput.Origin.viewport(), endX, endY));
		            swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
		            driver.perform(Arrays.asList(swipe));

		            swipes++;

		            try {
		                Thread.sleep(500); // small pause to let element appear
		            } catch (InterruptedException e) {
		                e.printStackTrace();
		            }
		        }

		        if (element.isDisplayed()) {
		            System.out.println("Element is now visible!");
		        } else {
		            System.out.println("Element not found after max swipes!");
		        }
		    }
		
}


		 
