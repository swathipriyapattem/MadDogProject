package MadDog.src;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class addExtension {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\LT-012\\Downloads\\chromedriver.exe");
		ChromeOptions opt = new ChromeOptions();
		opt.addExtensions(new File("C:\\Users\\LT-012\\eclipse-workspace\\MadDogProject\\target\\app.crx"));
		WebDriver driver = new ChromeDriver(opt);
		driver.get("https://www.google.com/recaptcha/api2/demo");
		Thread.sleep(2000);
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//div[@class=\"recaptcha-checkbox-border\"]")).click();
		Thread.sleep(1000);
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//div[@class=\"button-holder help-button-holder\"]")).click();
		
	}

}
