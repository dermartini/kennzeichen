package kennzeichen;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReadLog {
	
	Properties p = new Properties();
	
	public ReadLog(){

		try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream("settings.properties"))) {

			p.load(bis);
			
			bis.close();
			

		} catch (Exception e) {
			
			System.out.println("Fehler : " + e.getMessage());
		
		}
	
	}

	public Set<String> getCountries() {

		Set<String> set = new HashSet<String>();

		set = p.stringPropertyNames();
		
		return set;
		}
	
		

	
	public List<LogEntry> getAllEntries(String logfile) {

		String eineZeile;
		String[] StringArray = new String[2];
		List<LogEntry> list = new ArrayList<LogEntry>();

		try (BufferedReader br = new BufferedReader(new FileReader(logfile))) {

			while ((eineZeile = br.readLine()) != null) {

				StringArray = eineZeile.split(" -- ");

				// #### Split teilt Zeile auf und gibt ein Array mit den Strings
				// zurück
				// String timestamp = StringArray[0];
				// String licenseTag = StringArray[1];

				LogEntry lg = new LogEntry(Timestamp.valueOf(StringArray[0]),StringArray[1]);
				list.add(lg);

			}

		}

		catch (Exception e) {
			System.out.println("Fehler : " + e.getMessage());
		}

		return list;
	}

	public List<LogEntry> getAllEntriesByCountry(String land, String logfile) {

		String eineZeile;
		String[] StringArray = new String[2];
		List<LogEntry> list = new ArrayList<LogEntry>();

		try (BufferedReader br = new BufferedReader(new FileReader(logfile))) {

			while ((eineZeile = br.readLine()) != null) {
				
					StringArray = eineZeile.split(" -- ");

					String suchtext = StringArray[1];
									
					//### DEBUG
					//System.out.println("Suchtext " + suchtext);	
					//### DEBUG
					
					Pattern pat = Pattern.compile(p.getProperty(land));
					
					
					//### DEBUG
					//System.out.println("Patter " + p.getProperty(land));	
					//### DEBUG
					
					Matcher m = pat.matcher(suchtext);
					
					while (m.find()) {

						LogEntry lg = new LogEntry(Timestamp.valueOf(StringArray[0]), StringArray[1]);
						//### DEBUG
						//System.out.println("LOGEINTRAG " + lg.toString());	
						//### DEBUG
						list.add(lg);
					}					
				}
			
			System.out.println("Reading for " + land );
				
			}

		catch (Exception e) {
			System.out.println("Fehler : " + e.getMessage());
		}

		return list;
	}

}
