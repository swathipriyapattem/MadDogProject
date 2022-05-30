package MadDog.src;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class TestCasesForProfileDashboard extends MaddogLogin{
	@Test
	public void verifyPageTitle() {
		String pagetitle = driver.getTitle();
		System.out.println("Page title is : "+pagetitle);
		Assert.assertEquals(pagetitle,"Mad Dog Casting");
	}
	@Test
	public void verifyLogo() {
       boolean flag = driver.findElement(By.xpath("//img[@alt=\"logo\"]")).isDisplayed();
       Assert.assertTrue(flag);
   }
	public void verifyLinks() {
		
	}
	
//	@AfterMethod
//	public void tearDown() {
//		driver.quit();
//	}
}
