package MadDog.src;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.apache.commons.mail.EmailException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
@Listeners(CustomListener.class)
public class NewTest extends sendEmail {
	@BeforeMethod
	public void setUp() {
		initialization();
	}
//	@AfterMethod
//	public void quit() {
//		driver.quit();
//	}
  @Test
  public void Test() {
	  int a= 10;
	  int b= 20;
	  Assert.assertEquals(a, b);
	  System.out.println("---test done--");
  }

 
  public void beforeClass() {
	  System.out.println("-------start test------");
  }
  @AfterMethod
  public void afterClass(ITestResult result) throws EmailException
  {
	  if(result.getStatus()==ITestResult.FAILURE) {
		  sendEmail.sendemail();
		  System.out.println("test faild and email sent");
		  sendEmail.failed();
		  
	  }
		
  }
  

}
