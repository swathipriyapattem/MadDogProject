package MadDog.src;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class sendEmail{
	
public static WebDriver driver;	
	public static void initialization() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\LT-012\\Downloads\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		//driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		
		}

	public static void sendemail() throws EmailException {
		Email email = new SimpleEmail();
		email.setHostName("smtp.gmail.com");
		email.setSmtpPort(465);
		email.setAuthenticator(new DefaultAuthenticator("swathipattem123@gmail.com", "Krify@123"));
		email.setSSLOnConnect(true);
		email.setFrom("hello@doctormoneyapp.com");
		email.setSubject("sample text");
		email.setMsg("This is a test mail from selenium");
		email.addTo("swathipriya@krify.net");
		email.send();
	}
	public static void failed(){
		
		File srcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(srcFile, new File("C:\\Users\\LT-012\\eclipse-workspace\\MadDogProject\\screenshots"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
}
