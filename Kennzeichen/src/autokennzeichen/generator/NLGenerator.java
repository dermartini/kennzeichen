/**
 * 
 */
package autokennzeichen.generator;

import java.util.ArrayList;
import java.util.List;

/**
 * Generates fake NL license tags. NL does not use regional prefixes.
 * 
 * @author hmueller
 *
 */
@Deprecated
public class NLGenerator implements LicenseTagGenerator {

	private LicenseTagHelper helper = null;

	private String[] chars = null;

	public NLGenerator() {
		this.helper = new LicenseTagHelper();

		List<String> charsList = new ArrayList<>();
		for (char c = '0'; c <= '9'; c++) {
			charsList.add(Character.toString(c));
		}
		for (char c = 'A'; c <= 'Z'; c++) {
			if (c != 'C' && c != 'Q') {
				charsList.add(Character.toString(c));
			}
		}

		this.chars = charsList.toArray(new String[charsList.size()]);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see autokennzeichen.generator.LicenseTagGenerator#generate()
	 */
	@Override
	public String generate() {
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < this.helper.rnd.nextInt(2) + 1; i++) {
			sb.append(this.helper.randomString(chars));
		}

		sb.append("-");

		for (int i = 0; i < this.helper.rnd.nextInt(3) + 1; i++) {
			sb.append(this.helper.randomString(chars));
		}

		sb.append("-");

		for (int i = 0; i < this.helper.rnd.nextInt(3) + 1; i++) {
			sb.append(this.helper.randomString(chars));
		}

		return sb.toString();
	}

}
