/**
 * 
 */
package autokennzeichen.generator;

import java.util.*;

/**
 * Generates fake DE license tags using the real regional prefixes
 * 
 * @author hmueller
 *
 */
public class DEGenerator implements LicenseTagGenerator {
	
	private LicenseTagHelper helper = null;
	private String[] chars = null;
	
	public DEGenerator() {
		this.helper = new LicenseTagHelper("./src/autokennzeichen/generator/de_prefixes.txt");
		
		
		List<String> ifList = new ArrayList<>();
		for( char c = 'A'; c <='Z';c++){
			ifList.add( Character.toString(c) );
		}
		ifList.add("Ä");
		ifList.add("Ö");
		ifList.add("Ü");
		
		this.chars = ifList.toArray(new String[ifList.size()]);
	}

	/*
	 * (non-Javadoc)
	 * @see autokennzeichen.generator.LicenseTagGenerator#generate()
	 */
	@Override
	public String generate() {
		
		StringBuilder sb = new StringBuilder();
		sb.append(this.helper.randomPrefix());
		sb.append("-");
		sb.append(this.helper.randomString(chars));
		sb.append(" ");
		sb.append(this.helper.randomDigits(this.helper.rnd.nextInt(4)+1) );
					
		return sb.toString();
	}

}
