package TestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GoogleTest {
	WebDriver driver;
		@BeforeMethod
		public void setUp() {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\LT-012\\Downloads\\chromedriver_win32\\chromedriver.exe");
			 driver = new ChromeDriver();	
			WebDriverWait wait = new WebDriverWait(driver, 30);
			//driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.get("http://www.google.com");
		}
		@Test(priority =1,groups =" Test1")
		public void googleTitleTest() {
			String title = driver.getTitle();
			System.out.println(title);
		}
		@Test(priority =2,groups = "Test2")
		public void googleLogoTest() {
			boolean b = driver.findElement(By.xpath("//img[@alt=\"Google\"]")).isDisplayed();
		}
		
		@AfterMethod
		public void tearDown() {
			driver.quit();
		}
}
