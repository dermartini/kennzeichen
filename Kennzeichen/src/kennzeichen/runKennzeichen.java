package kennzeichen;

import autokennzeichen.generator.*;

import java.io.FileInputStream;
import java.util.Properties;

import autokennzeichen.generator.FileGenerator;

public class runKennzeichen {

	public static void main(String[] args) {
		
		// ######## Erzeugen des LogFiles #############
		
		FileGenerator.generateLogFile("logfile2", 10000);

		// ######## Erzeugen der Readlog #############
		
		ReadLog rl = new ReadLog();
		
		System.out.println(rl.getCountries() );
	

	}

}
