package MadDog.src;

import java.util.Properties;

import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.search.FlagTerm;

public class GetAuthCode {
	//public static void main( String[] args ) throws Exception {
		public static String GetOAuth() throws MessagingException {
		String subject ="";
		String OAuth="";
      Session session = Session.getDefaultInstance(new Properties( ));
      Store store = session.getStore("imaps");
      store.connect("imap.gmail.com", 993, "swathipattem123@gmail.com", "Krify@123");
      Folder inbox = store.getFolder( "INBOX" );
      inbox.open( Folder.READ_WRITE );

      // Fetch unseen messages from inbox folder
      Message[] messages = inbox.search(
          new FlagTerm(new Flags(Flags.Flag.SEEN), false));
      
      for ( Message message : messages ) {
    	  
        //  System.out.println(" subject : " + message.getSubject()) ;          
           message.getSubject().toString();  
           subject = message.getSubject();             
      }
      if (subject.length() > 4)
      {
    	  OAuth = subject.substring(subject.length() - 4);
      }
      else
      {
    	  OAuth = subject;
      }

      //System.out.println(OAuth);
       return    OAuth;
		
	}
}



//if (OTP.contains(":")) {
//    // Split it.
//   String[] res = OTP.split("[:]");
//for(String myStr: res) {
//System.out.println("MyStr : " + myStr);
//}
//} else {
//    throw new IllegalArgumentException("String " + OTP + " does not contain -");
//}
 
