package MadDog.src.HandlingMails;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Part;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.search.FlagTerm;

import org.jsoup.Jsoup;

public class NewEmailOtp {
	 
    public static void main( String[] args ) throws Exception {
        String OTP="";
      Session session = Session.getDefaultInstance(new Properties( ));
      Store store = session.getStore("imaps");
      store.connect("imap.gmail.com", 993, "swathipattem123@gmail.com", "Krify@123");
      Folder inbox = store.getFolder( "INBOX" );
      inbox.open( Folder.READ_WRITE );

      // Fetch unseen messages from inbox folder
      Message[] messages = inbox.search(
          new FlagTerm(new Flags(Flags.Flag.SEEN), false));

      // Sort messages from recent to oldest
   /*   Arrays.sort( messages, ( m1, m2 ) -> {
        try {
          return m2.getSentDate().compareTo( m1.getSentDate() );
        } catch ( MessagingException e ) {
          throw new RuntimeException( e );
        }
      } );*/

      for ( Message message : messages ) {
        System.out.println(
            "sendDate: " + message.getSentDate()
            + " subject:" + message.getSubject()) ;
           ;
          if(message.getSubject().contains("Doctor Money : E-Mail Verification")) {
              
              Object content = message.getContent();  
              if (content instanceof String)  
              {  
                  System.out.println("Body: "+ (String)content );
                   OTP = (String)content;  
                  
              }  
              else if (content instanceof Multipart)  
              {  
                  Multipart mp = (Multipart)content;
                  OTP=getFinalContent(mp.getBodyPart(0)).toString();
                  System.out.println("Body: "+getFinalContent(mp.getBodyPart(0)).toString());
                  
              }  
              
              
//  Multipart  content=     (Multipart)message.getContent();
               OTP=Jsoup.parse(OTP).text();
            //message.setFlag(Flags.Flag.SEEN, true);
        String extractedOTP=OTP.replaceAll("[^0-9]","");
        //This prints otp
        System.out.println(getExtractedOTP(extractedOTP));
      }}
    }
    
    static String getExtractedOTP(String extractedOTP) {
        if (extractedOTP.length() == 4) {
              return extractedOTP;
            } else if (extractedOTP.length() > 4) {
              return extractedOTP.substring(extractedOTP.length() - 4);
            } else {
              // whatever is appropriate in this case
              throw new IllegalArgumentException("word has fewer than 4 characters!");
            }
    }
    private static String getFinalContent(Part p) throws MessagingException,
   IOException {

String finalContents = "";
if (p.getContent() instanceof String) {
   finalContents = (String) p.getContent();
} else {
   Multipart mp = (Multipart) p.getContent();
   if (mp.getCount() > 0) {
       Part bp = mp.getBodyPart(0);
       try {
           finalContents = dumpPart(bp);
       } catch (Exception e) {
           e.printStackTrace();
       }
   }
}
return finalContents.trim();
}

private static String dumpPart(Part p) throws Exception {

InputStream is = p.getInputStream();
// If "is" is not already buffered, wrap a BufferedInputStream
// around it.
if (!(is instanceof BufferedInputStream)) {
   is = new BufferedInputStream(is);
}
return getStringFromInputStream(is);
}

private static String getStringFromInputStream(InputStream is) {

BufferedReader br = null;
StringBuilder sb = new StringBuilder();
String line;
try {
   br = new BufferedReader(new InputStreamReader(is));
   while ((line = br.readLine()) != null) {
       sb.append(line);
       sb.append("\n");
   }
} catch (IOException e) {
   e.printStackTrace();
} finally {
   if (br != null) {
       try {
           br.close();
       } catch (IOException e) {
           e.printStackTrace();
       }
   }
}
return sb.toString();
}
    
  }


