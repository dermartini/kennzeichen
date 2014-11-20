package autokennzeichen.generator;

import java.util.*;

/**
 * Generates fake AT license tags using the real regional prefixes
 * 
 * @author hmueller
 *
 */
public class ATGenerator implements LicenseTagGenerator {
	
	private LicenseTagHelper helper = null;
	
	private String[] chars = null;
	
	public ATGenerator() {
		this.helper = new LicenseTagHelper("./src/autokennzeichen/generator/at_prefixes.txt");
		
		List<String> charsList = new ArrayList<>();
		for( char c = '0'; c <= '9'; c++ ){
			//Häufigkeit von Zahlen erhöhen
			charsList.add( Character.toString(c) );
			charsList.add( Character.toString(c) );
			charsList.add( Character.toString(c) );
		}
		for( char c = 'A'; c <= 'Z'; c++ ){
			charsList.add( Character.toString(c) );
		}
					
		this.chars = charsList.toArray(new String[charsList.size()]);
	}

	/* (non-Javadoc)
	 * @see autokennzeichen.generator.LicenseTagGenerator#generate()
	 */
	@Override
	public String generate() {
		StringBuilder sb = new StringBuilder();
		sb.append( this.helper.randomPrefix() );
		sb.append("-");
		for( int i = 0; i < this.helper.rnd.nextInt(4)+2; i++){
			sb.append(this.helper.randomString(chars) );
		}
		return sb.toString();
	}

}
