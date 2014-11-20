package kennzeichen;

import autokennzeichen.generator.*;

import java.io.FileInputStream;
import java.util.Properties;

import autokennzeichen.generator.FileGenerator;

public class runKennzeichen {

	public static void main(String[] args) {
		
		// ######## Erzeugen des LogFiles #############
		
		//FileGenerator.generateLogFile("logfile", 100);

		// ######## Erzeugen der Readlog #############
		
		ReadLog rl = new ReadLog();
		
		//System.out.println(rl.getCountries() );
		
		//System.out.println( rl.getAllEntries("logfile").get(1) );
		
		
		System.out.println(rl.getAllEntriesByCountry("DE", "logfile").size() );
	

	}

}
