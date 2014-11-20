package kennzeichen;

import java.awt.List;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

public class ReadLog {

	public Set<String> getCountries() {

		Properties p = new Properties();
		
		Set<String> set = new HashSet<>();
		
		try (BufferedInputStream bis = new BufferedInputStream( new FileInputStream("settings.properties")) ) {
			
			p.load(bis);
			bis.close();
			set = p.stringPropertyNames();
			
			}

		catch (Exception e) {
			System.out.println("Fehler : " + e.getMessage());
		}
		System.out.println("Hallo");
		
		return set;
		
		}
	
	public List getAllEntries(String file){
		
		
		
		
		
		
		
		
		return null;
		
		
	}
}
