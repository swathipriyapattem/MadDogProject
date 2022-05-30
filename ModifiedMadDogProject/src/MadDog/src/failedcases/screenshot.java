

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(CustomListener.class)
public class screenshot extends Base{
	@BeforeMethod
	public void setUp() {
		initialization();
	}
	@AfterMethod
	public void quit() {
		driver.quit();
	}
  @Test
  public void TakeScreenshotTest() {
	  Assert.assertEquals(false,true);
	 
  }

  @BeforeClass
  public void beforeClass() {
	  System.out.println("-------start test------");
  }

}
