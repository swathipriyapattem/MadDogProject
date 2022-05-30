package MadDog.src;

import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class mdregst {
	public static WebDriver driver;
	
	public static  void initialization() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\LT-012\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		//driver.manage().window().maximize();
		}
	public static void main(String[] args) throws InterruptedException {
		
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\LT-012\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
	//	driver.manage().window().maximize();
		initialization();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://mdcstaging.krify.com/artist/registration");
		driver.findElement(By.xpath("//input[@name=\"first\"]")).sendKeys("swathi");
		driver.findElement(By.xpath("//input[@name=\"last\"]")).sendKeys("pattem");
		driver.findElement(By.xpath("//div[@id=\"mui-component-select-gender\"]")).click();
		List<WebElement> gender=driver.findElements(By.xpath("//li[@role=\"option\"]"));//to select gender
			for(WebElement Name:gender) {
				   //System.out.println(Name.getText());	
				    	if(Name.getText().equals("Female")) {
				    	     Name.click(); 
				    		   break;			   
				    	}			     
			}
			driver.findElement(By.xpath("//input[@name=\"date\"]")).sendKeys("06-12-1999");
			driver.findElement(By.xpath("//div[@id=\"mui-component-select-nationality\"]")).click();
			List<WebElement> Nationality=driver.findElements(By.xpath("//li[@role=\"option\"]"));//To select nationality
			for(WebElement countries:Nationality) {
				   //System.out.println(countries.getText());	
				    	if(countries.getText().equals("Indian")) {
				    	     countries.click(); 
				    		   break;			   
				    	}			     
			}
//			driver.findElement(By.xpath("//div[@id=\"mui-component-select-parent\"]")).click();
//			List<WebElement> continent=driver.findElements(By.xpath("//li[@role=\"option\"]"));//To select continent
//			for(WebElement countries:continent) {
//				   //System.out.println(countries.getText());	
//				    	if(countries.getText().equals("Asian")) {
//				    	     countries.click();
//				    		   break;			   
//				    	}			     
//			}
//			driver.findElement(By.xpath("//div[@id=\"mui-component-select-child\"]")).click();
//			List<WebElement> country=driver.findElements(By.xpath("//li[@role=\"option\"]"));//To select country
//			for(WebElement countries:country) {
//				   //System.out.println(countries.getText());	
//				    	if(countries.getText().equals("India")) {
//				    	     countries.click();
//				    		   break;			   
//				    	}			     
//			}
//			driver.findElement(By.xpath("//input[@name=\"ethnicStatus\"]")).click();
			driver.findElement(By.xpath("//input[@name=\"email\"]")).sendKeys("swathipattem123@gmail.com");
			driver.findElement(By.xpath("//input[@name=\"mobile\"]")).sendKeys("+44 7911 123456");
			driver.findElement(By.xpath("//input[@name=\"address\"]")).sendKeys("surrey");
			driver.findElement(By.xpath("//div[@id=\"mui-component-select-county\"]")).click();
			List<WebElement> countrie=driver.findElements(By.xpath("//li[@role=\"option\"]"));
			for(WebElement countries:countrie) {
				   //System.out.println(countries.getText());	
				    	if(countries.getText().contains("London")) {
				    	     countries.click(); 
				    		   break;			   
				    	}			     
			}
			driver.findElement(By.xpath("//input[@name=\"postcode\"]")).sendKeys("CR2 5ER");
			driver.findElement(By.xpath("//div[@id=\"mui-component-select-transport\"]")).click();
			List<WebElement> Transport=driver.findElements(By.xpath("//li[@role=\"option\"]"));
			for(WebElement option:Transport) {
				   //System.out.println(option.getText());	
				    	if(option.getText().contains("Yes")) {
				    	     option.click(); 
				    		   break;			   
				    	}			     
			}
			driver.findElement(By.xpath("//div[@id=\"mui-component-select-height\"]")).click();
			List<WebElement> Height=driver.findElements(By.xpath("//li[@role=\"option\"]"));
			for(WebElement options:Height) {
				   //System.out.println(options.getText());	
				    	if(options.getText().contains("5'5")) {
				    	     options.click(); 
				    		   break;			   
				    	}			     
			}
			driver.findElement(By.xpath("//div[@id=\"mui-component-select-dress\"]")).click();
			List<WebElement> dressSize=driver.findElements(By.xpath("//li[@role=\"option\"]"));
			for(WebElement sizes:dressSize) {
				   //System.out.println(sizes.getText());	
				    	if(sizes.getText().contains("10/12")) {
				    	     sizes.click(); 
				    		   break;			   
				    	}			     
			}
			driver.findElement(By.xpath("//button[text()=\"Continue\"]")).click();
			//wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//button[text()=\"Availability & Employment\"]"))));		
			Thread.sleep(1000);
			Actions act =  new Actions(driver);
			act.moveToElement(driver.findElement(By.xpath("//div[@id=\"mui-component-select-jobstatus\"]"))).click().perform();
		//driver.findElement(By.xpath("//div[@id=\"mui-component-select-jobstatus\"]")).click();
		  List<WebElement> Jobstatus=driver.findElements(By.xpath("//li[@role=\"option\"]"));
			for(WebElement options:Jobstatus) {
				  // System.out.println(options.getText());	
				    	if(options.getText().contains("Yes")) {
				    	     options.click(); 
				    		   break;			   
				    	}			     
			}
		//	wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//strong[text()=\"Other Job Type\"]"))));
			Thread.sleep(2000);
			Actions acti =  new Actions(driver);
			acti.moveToElement(driver.findElement(By.xpath("//div[@id=\"mui-component-select-jobtype\"]"))).click().perform();
		//driver.findElement(By.xpath("//div[@id=\"mui-component-select-jobtype\"]"));
		List<WebElement> JobType=driver.findElements(By.xpath("//li[@role=\"option\"]"));
			for(WebElement options:JobType) {
				   //System.out.println(options.getText());	
				    	if(options.getText().contains("Part time")) {
				    	     options.click(); 
				    		   break;			   
				    	}			     
			}
			driver.findElement(By.xpath("//input[@name=\"rtWork\"]")).click();
			driver.findElement(By.xpath("//input[@name=\"promowork_opt_in\"]")).click();
			driver.findElement(By.xpath("//button[text()=\"Continue\"]")).click();
		//	wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//button[text()=\"Photograph\"]"))));
			Thread.sleep(2000);
			//String filepath = "C:/Users/LT-012/Pictures/chandler.jpg";
			// image upload
			WebElement choosefile = driver.findElement(By.xpath("//input[@id=\"profile-button-file\"]"));
			choosefile.sendKeys("C:/Users/LT-012/Pictures/chandler.jpg");	
			driver.findElement(By.xpath("//button[text()=\"Continue\"]")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//input[@name=\"marketing_opt_in\"]")).click();
			driver.findElement(By.xpath("//input[@name=\"tcAccepted\"]")).click();
			driver.findElement(By.xpath("//div[@id=\"mui-component-select-category\"]")).click();
			List<WebElement> HAB=driver.findElements(By.xpath("//li[@role=\"option\"]"));
			for(WebElement options:HAB) {
				   //System.out.println(options.getText());	
				    	if(options.getText().contains("Newspaper")) {
				    	     options.click(); 
				    		   break;			   
				    	}			     
			}
			driver.findElement(By.xpath("//button[normalize-space(text())=\"Finish & submit\"]")).click();
			if(driver.findElement(By.xpath("//h4[@class=\"errormessage mb-0\"]")).isDisplayed()) {
				driver.findElement(By.xpath("//button[normalize-space(text())=\"Spot Errors\"]")).click();
			}else {
//				 LoginMD login = new LoginMD();
//				 login.login();
			}
	}

}
