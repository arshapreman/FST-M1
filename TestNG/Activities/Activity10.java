package activities;
import static org.testng.Assert.assertEquals;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Activity10 {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Open browser
        driver.get("https://training-support.net/webelements/simple-form");
    }

    public static List<List<String>> readExcel(String filePath) {
        List<List<String>> data = new ArrayList<List<String>>();
        try {
            FileInputStream file = new FileInputStream(filePath);

            XSSFWorkbook workbook = new XSSFWorkbook(file);

            XSSFSheet sheet = workbook.getSheetAt(0);

            for (Row cells : sheet) {
             
                List<String> rowData = new ArrayList<String>();
                for (Cell cell : cells) {
                
                    rowData.add(cell.getStringCellValue());
                }
             
                data.add(rowData);
            }
            file.close();
            workbook.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }

    @DataProvider(name = "Events")
    public static Object[][] signUpInfo() {
        String filePath = "src/test/resources/Activity10.xlsx";
        List<List<String>> data = readExcel(filePath);
        return new Object[][] { 
            { data.get(1) },
            { data.get(2) },
            { data.get(3) }
        };
    }

    @Test(dataProvider = "Events")
    public void registerTest(List<String> rows) {

        WebElement fullName = wait.until(
            d -> d.findElement(By.id("full-name"))
        );
        fullName.clear();
        fullName.sendKeys(rows.get(0));

        WebElement email = driver.findElement(By.id("email"));
        email.clear();
        email.sendKeys(rows.get(1));

        WebElement date = driver.findElement(By.name("event-date"));
        date.clear();
        date.sendKeys(rows.get(2).replaceAll("\"", ""));

        WebElement details = driver.findElement(By.id("additional-details"));
        details.clear();
        details.sendKeys(rows.get(3));

        driver.findElement(By.xpath("//button[text()='Submit']")).click();

        String message = wait.until(
            d -> d.findElement(By.id("action-confirmation")).getText()
        );

        assertEquals(message, "Your event has been scheduled!");

        driver.navigate().refresh();
        wait.until(d -> d.findElement(By.id("full-name")).isDisplayed());
    }
    @AfterClass
    public void tearDown() {
       
        driver.quit();
    }
}
