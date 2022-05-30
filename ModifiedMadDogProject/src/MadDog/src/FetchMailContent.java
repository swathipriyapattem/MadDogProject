package MadDog.src;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

import javax.mail.BodyPart;
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

public class FetchMailContent {
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
         if(message.getSubject().contains("Your Mad Dog 2020 application form")) {
             
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
 }}
}

private static String getFinalContent(Part p) throws MessagingException,
IOException {

String finalContents = "";
if (p.getContent() instanceof String) {
finalContents = (String) p.getContent();
} else {
Multipart mp = (Multipart) p.getContent();

}
return finalContents.trim();
}
}


