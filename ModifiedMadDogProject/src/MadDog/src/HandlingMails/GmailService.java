package MadDog.src.HandlingMails;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.devtools.v85.webauthn.model.Credential;

import com.fasterxml.jackson.core.JsonFactory;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.services.gmail.GmailScopes;

public class GmailService {
	private static final String APPLICATION_NAME ="Automation";
	private static final JsonFactory JSON_FACTORY = GsonFactory.getDefaultInstance();
	private static final String USER_ID="me";
	
	 private static final List<String> SCOPES = Collections.singletonList(GmailScopes.MAIL_GOOGLE_COM);
	    private static final String CREDENTIALS_FILE_PATH = 
	    		System.getProperty("user.dir")+
	    		File.separator + "src"+
//	    		File.separator + "main"+
//	    		File.separator + "resources"+
	    		File.separator + "credentials"+
	    		File.separator + "credentials.json";
	    private static final String TOKENS_DIRECTORY_PATH = 
	    		System.getProperty("user.dir")+
	    		File.separator + "src"+
//	    		File.separator + "main"+
//	    		File.separator + "resources"+
	    		File.separator + "credentials";
	    private static Credential getCredentials(final NetHttpTransport HTTP_TRANSPORT) throws IOException {
	        // Load client secrets.
	        InputStream in = GmailQuickstart.class.getResourceAsStream(CREDENTIALS_FILE_PATH);
	        if (in == null) {
	            throw new FileNotFoundException("Resource not found: " + CREDENTIALS_FILE_PATH);
	        }
	        GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(in));

	        // Build flow and trigger user authorization request.
	        GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(
	                HTTP_TRANSPORT, JSON_FACTORY, clientSecrets, SCOPES)
	                .setDataStoreFactory(new FileDataStoreFactory(new java.io.File(TOKENS_DIRECTORY_PATH)))
	                .setAccessType("offline")
	                .build();
	        LocalServerReceiver receiver = new LocalServerReceiver.Builder().setPort(8888).build();
	        Credential credential = new AuthorizationCodeInstalledApp(flow, receiver).authorize("user");
	        //returns an authorized Credential object.
	        return credential;
	    }
	    
}
