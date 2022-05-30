

	import java.io.FileInputStream;
	import java.io.FileNotFoundException;
	import java.io.IOException;
	import java.util.List;
	import java.util.Properties;
	import java.util.regex.Matcher;
	import java.util.regex.Pattern;

	import javax.mail.Store;

	import org.jsoup.Jsoup;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;

	import com.testing.framework.DateTimeUtils;
	import com.testing.framework.EmailUtils;

	public class ReadOTP {
//		static String getExtractedOTP(String extractedOTP) {
//			if (extractedOTP.length() == 4) {
//				  return extractedOTP;
//				} else if (extractedOTP.length() > 4) {
//				  return extractedOTP.substring(extractedOTP.length() - 4);
//				} else {
//				  // whatever is appropriate in this case
//				  throw new IllegalArgumentException("word has fewer than 4 characters!");
//				}
//		}

		public static void main(String[] args) throws Exception {
			// TODO Auto-generated method stub
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\LT-012\\Downloads\\chromedriver.exe");
			 
			EmailUtils emailUtils = new EmailUtils();
			Properties prop = new Properties();
			prop.setProperty("to", "swathipattem123@gmail.com");
			prop.setProperty("gmail_from", "swathipattem123@gmail.com");
			prop.setProperty("gmail_username", "swathipattem123@gmail.com");
			prop.setProperty("gmail_password", "Krify@123");
			prop.setProperty("gmail_port", "587"); 
			prop.put("mail.smtp.ssl.trust", "*");
			Store connection =emailUtils.connectToGmail(prop);
			List<String> emailtext = emailUtils.getUnreadMessageByFromEmail(connection, "Inbox", "hello@doctormoneyapp.com", "Doctor Money : E-Mail Verification");
	      		if(emailtext.size()<1) {
				throw new Exception("No Email Received");
			}
			else {
				  System.out.println("-------------------------------------------hi hi h-----------------");
					System.out.println(emailtext.get(0));
					
					System.out.println("-------------------------------------------hi hi h-----------------");
					
				String regex = "[^\\d]+";
				String[] OTP= emailtext.get(0).split(regex);
				System.out.println("OTP is "+OTP[1]);
				/*String OTP = emailtext.toString();
				System.out.println("-------------------------------------------kk-----------"+emailtext.toString());
				System.out.println("OTP is "+OTP);
			    System.out.println("--------------------------------------------kk----------");
				Pattern pattern=Pattern.compile("[\\d]+");
				Matcher matcher=pattern.matcher(OTP);
				while(matcher.find()) {
					System.out.println(matcher.group());
				}*/
//				String data=emailtext.toString();
//				
//				String OTP=String.valueOf(Jsoup.parse(data).text());
//				String extractedOTP=OTP.replaceAll("[^0-9]","");
//				//This prints otp
//				System.out.println(OTP);
				//System.out.println(extractedOTP);
				//System.out.println(getExtractedOTP(extractedOTP));
				
				
			}
			
			
			}
		}



}
