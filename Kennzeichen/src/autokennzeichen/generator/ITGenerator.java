/**
 * 
 */
package autokennzeichen.generator;

import java.util.ArrayList;
import java.util.List;

/**
 * Generates fake IT license tags. IT does not use regional prefixes.
 * 
 * @author hmueller
 *
 */
public class ITGenerator implements LicenseTagGenerator {

	private LicenseTagHelper helper = null;
	private String[] aToZ = null;

	public ITGenerator() {
		this.helper = new LicenseTagHelper();

		List<String> charsList = new ArrayList<>();
		for (char c = 'A'; c <= 'Z'; c++) {
			charsList.add(Character.toString(c));
		}
		this.aToZ = charsList.toArray(new String[charsList.size()]);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see autokennzeichen.generator.LicenseTagGenerator#generate()
	 */
	@Override
	public String generate() {
		StringBuilder sb = new StringBuilder();

		sb.append(this.helper.randomString(aToZ));
		sb.append(this.helper.randomString(aToZ));
		sb.append("-");
		sb.append(this.helper.randomDigits(3));		
		sb.append("-");
		sb.append(this.helper.randomString(aToZ));
		sb.append(this.helper.randomString(aToZ));
		
		return sb.toString();

	}

}
