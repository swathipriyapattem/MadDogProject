package MadDog.src;

import java.io.File;
import java.util.concurrent.TimeUnit;

import javax.mail.MessagingException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MaddogLogin extends GetAuthCode{
	@SuppressWarnings("unused")
	private static FluentWait<WebDriver> wait;
	public static WebDriver driver;
	@SuppressWarnings("deprecation")
	public static WebDriver startdriver() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\LT-012\\Downloads\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions opt = new ChromeOptions();
		opt.addExtensions(new File("C:\\Users\\LT-012\\eclipse-workspace\\MadDogProject\\target\\app.crx"));
		WebDriver driver = new ChromeDriver(opt);		
//		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return driver;	
	}

	public static void main(String[] args) throws InterruptedException, Exception {
		// TODO Auto-generated method stub
		driver=	startdriver();

		driver.get("https://mdcstaging.krify.com/login");
		driver.findElement(By.xpath("//input[@name=\"artistId\"]")).sendKeys("269459");
		driver.findElement(By.xpath("//input[@type=\"password\"]")).sendKeys("rEbSCTg");
		Thread.sleep(2000);
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//label[text()=\"I'm not a robot\"]")).click();
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//button[text()=\"Send via Email\"]")).click();
		Thread.sleep(2000);
		//GetAuthCode.GetOAuth();
		 System.out.println(GetAuthCode.GetOAuth());
		driver.findElement(By.xpath("//input[@name=\"auth\"]")).sendKeys(GetAuthCode.GetOAuth());
		driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
		
	}
	
}
