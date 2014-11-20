/**
 * 
 */
package autokennzeichen.generator;

import java.util.ArrayList;
import java.util.List;

/**
 * Generates fake BE license tags. BE does not use regional prefixes.
 * 
 * @author hmueller
 *
 */
public class BEGenerator implements LicenseTagGenerator {
	
	private LicenseTagHelper helper = null;
	
	private String[] oneToSeven = null;
	
	private String[] aToZ = null;
	
	public BEGenerator() {
		this.helper = new LicenseTagHelper();
		
		List<String> charsList = new ArrayList<>();
		for( char c = '1'; c <= '7'; c++ ){			
			charsList.add( Character.toString(c) );	
		}
		this.oneToSeven = charsList.toArray(new String[charsList.size()]);
		
		charsList.clear();
			
		for( char c = 'A'; c <= 'Z'; c++ ){
			
			charsList.add( Character.toString(c) );	
		}
		this.aToZ = charsList.toArray(new String[charsList.size()]);
		
		
	}

	/* (non-Javadoc)
	 * @see autokennzeichen.generator.LicenseTagGenerator#generate()
	 */
	@Override
	public String generate() {
		StringBuilder sb = new StringBuilder();
		
		sb.append(this.helper.randomString(oneToSeven) );
		sb.append("-");
		sb.append(this.helper.randomString(aToZ) );
		sb.append(this.helper.randomString(aToZ) );
		sb.append(this.helper.randomString(aToZ) );
		sb.append("-");
		sb.append(this.helper.randomString(oneToSeven) );
		sb.append(this.helper.randomDigits(2) );
		
		return sb.toString();
	}

}
