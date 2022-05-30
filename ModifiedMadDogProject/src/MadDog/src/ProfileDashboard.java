package MadDog.src;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ProfileDashboard extends MaddogLogin{
	
	public static WebDriver profileDashboardMyphotos() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		driver.findElement(By.xpath("//a[@href=\"/artist/ProfileDashboard\"]")).click();
		//wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//img[@alt=\"logo\"]"))));
		driver.findElement(By.xpath("//button[text()=\"My Photos\"]")).click();
		//wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//h2[text()=\"Add new attachment\"]"))));
		driver.findElement(By.xpath("//div[@aria-haspopup=\"listbox\"]")).click();
		List<WebElement> category=driver.findElements(By.xpath("//li[@role=\"option\"]"));//to select category
		for(WebElement Name:category) {
			   System.out.println(Name.getText());	
			    	if(Name.getText().contains("Other 1")) {
			    	     Name.click(); 
			    		   break;			   
			    	}			     
		}
		//To upload image
		
		WebElement choosefile = driver.findElement(By.xpath("//input[@id=\"profile-button-file\"]"));
		choosefile.sendKeys("C:/Users/LT-012/Pictures/chandler.jpg");
		
		
		return driver;
	}
	
}